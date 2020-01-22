package com.hs.cathaybankexam.area.AreaList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hs.cathaybankexam.MainActivity;
import com.hs.cathaybankexam.R;
import com.hs.cathaybankexam.area.AreaDetail.AreaDetailFragment;
import com.hs.cathaybankexam.area.OnItemClick;
import com.hs.cathaybankexam.model.Area;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class AreaListFragment extends Fragment implements AreaContract.View {

    SwipeRefreshLayout swipeRefreshLayout;

    private AreaAdapter adapter;
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
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area_list, container, false);
        progressBar = view.findViewById(R.id.progress);
        RecyclerView recyclerView = view.findViewById(R.id.area_list_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AreaAdapter(getContext(), new AreaClick());
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout = view.findViewById(R.id.layout_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        presenter.getAreaData();
                        if (swipeRefreshLayout != null) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                });
            }
        });


        return view;
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
        Toast.makeText(getContext(), R.string.get_date_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressing(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            return;
        }
        progressBar.setVisibility(View.INVISIBLE);
    }

    class AreaClick implements OnItemClick {

        @Override
        public void onClick(Object object) {
            if(!(object instanceof Area)){
                return;
            }

            AreaDetailFragment detailFragment = new AreaDetailFragment();

            Area area = (Area) object;
            Bundle bundle = new Bundle();
            bundle.putParcelable("area", area);
            detailFragment.setArguments(bundle);

            FragmentManager fm = getFragmentManager();
            ((MainActivity) getContext()).getSupportFragmentManager()
                    .beginTransaction()
                    .hide(fm.findFragmentByTag("area_list_fragment"))
                    .add(R.id.fragment_holder, detailFragment, "area_detail_fragment")
                    .addToBackStack(null)
                    .commit();
        }
    }
}

