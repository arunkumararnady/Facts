package com.assignment.facts.ui;

import android.arch.lifecycle.ViewModelProviders;
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
import com.assignment.facts.utils.AppUtil;
import com.assignment.facts.adapter.RecyclerAdapter;
import com.assignment.facts.data.CountryData;
import com.assignment.facts.data.RowData;
import com.assignment.facts.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {

    @BindView(R.id.about_fragment)
    RelativeLayout container;

    @BindView(R.id.recycler_list)
    RecyclerView recyclerListView;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.progressbar_layout)
    RelativeLayout progressBar;

    private RecyclerAdapter recyclerAdapter;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment, container, false);
        ButterKnife.bind(this, view);
        initUI();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initUI() {
        showLoadingProgress(true);
        swipeRefreshLayout.setOnRefreshListener(this::initData);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (recyclerAdapter == null) {
            recyclerAdapter = new RecyclerAdapter(getContext(), new ArrayList<>());
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerListView.setAdapter(recyclerAdapter);
        recyclerListView.setLayoutManager(manager);
        DividerItemDecoration dividerDecoration = new DividerItemDecoration(recyclerListView.getContext(),
                manager.getOrientation());
        recyclerListView.addItemDecoration(dividerDecoration);
    }

    private void initData() {
        if (!AppUtil.getInstance().isOnline(getContext())) {
            showError();
        } else {
            mainViewModel.getCountryLiveData().observe(this, this::updateUI);
        }
    }

    private void updateUI(CountryData countryModel) {
        getActionBar().setTitle(countryModel.getTitle());
        if (countryModel != null) {
            List<RowData> dataList  = countryModel.getRowsData();
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).getTitle() == null && dataList.get(i).getDescription() == null) {
                    dataList.remove(i);
                }
            }
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);
            }
            recyclerAdapter.setRows(dataList);
            recyclerListView.setVisibility(View.VISIBLE);
        }
        showLoadingProgress(false);
    }

    private void showError() {
        Snackbar.make(container, getString(R.string.error_message), Snackbar.LENGTH_LONG)
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

}
