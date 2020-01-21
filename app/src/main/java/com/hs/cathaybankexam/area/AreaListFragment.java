package com.hs.cathaybankexam.area;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hs.cathaybankexam.R;
import com.hs.cathaybankexam.model.Area;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AreaListFragment extends Fragment implements AreaContract.View {

    private RecyclerView.LayoutManager layoutManager;
    private AreaAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AreaPresenter presenter;

    public static AreaListFragment newInstance() {
        AreaListFragment fragment = new AreaListFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AreaPresenter(this, new AreaRepoImpl());
        Log.i("HS", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area_list, container, false);
//        progressBar = view.findViewById(R.id.progress);
        recyclerView = view.findViewById(R.id.area_list_recyclerview);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AreaAdapter(getContext());
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getAreaData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void onGetAreaDataSuccess(List<Area> areas) {
        adapter.update(areas);
    }

    @Override
    public void onGetAreaDataError(Throwable throwable) {

    }

    @Override
    public void showProgressing(boolean show) {
//        if (show) {
//            progressBar.setVisibility(View.VISIBLE);
//            return;
//        }
//        progressBar.setVisibility(View.INVISIBLE);
    }
}
