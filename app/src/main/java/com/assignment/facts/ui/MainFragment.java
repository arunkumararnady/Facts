package com.assignment.facts.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.assignment.facts.R;
import com.assignment.facts.adapter.RecyclerAdapter;
import com.assignment.facts.data.CountryData;
import com.assignment.facts.data.RowData;
import com.assignment.facts.viewmodel.MainViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {

    @BindView(R.id.recycler_list)
    RecyclerView recyclerListView;

    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.progressbarLayout)
    RelativeLayout progressBar;

    @BindView(R.id.about_fragment)
    RelativeLayout container;

    private RecyclerAdapter recyclerAdapter;
    private MainViewModel mainViewModel;
    private List<RowData> dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment, container, false);
        ButterKnife.bind(this, view);
        showLoadingProgress(true);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return view;
    }

    private void initData() {
        if (!isOnline(getContext())) {
            showError();
        } else {
            mainViewModel.refresh();
            getViewModelData();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void getViewModelData() {
        mainViewModel.getCountryLiveData().observe(this, new Observer<CountryData>() {
            @Override
            public void onChanged(@Nullable CountryData countryModel) {
                countryModel = mainViewModel.getCountryLiveData().getValue();
                if(countryModel != null) {
                    dataList = countryModel.getRowsData();
                    showListView(countryModel);
                    getActionBar().setTitle(countryModel.getTitle());
                }
            }
        });
    }

    public void showListView(CountryData countryData) {
        //TODO
        showLoadingProgress(false);
    }

    public void showError() {
        Snackbar.make(container, "Failed to get data!", Snackbar.LENGTH_LONG)
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
        showLoadingProgress(false);
        swipeRefreshLayout.setRefreshing(false);
    }

    private void showLoadingProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
