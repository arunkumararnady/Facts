package com.assignment.facts.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.assignment.facts.R;
import com.assignment.facts.adapter.RecyclerAdapter;
import com.assignment.facts.viewmodel.MainViewModel;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment, container, false);
        ButterKnife.bind(this, view);
        showLoadingProgress(true);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return view;
    }

    private void showLoadingProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
