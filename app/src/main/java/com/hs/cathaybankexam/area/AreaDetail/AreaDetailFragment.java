package com.hs.cathaybankexam.area.AreaDetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hs.cathaybankexam.R;
import com.hs.cathaybankexam.model.Area;
import com.hs.cathaybankexam.model.Plant;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AreaDetailFragment extends Fragment implements AreaDetailContract.View {
    private PlantAdapter adapter;
    private ProgressBar progressBar;
    private TextView areaTitle;
    private TextView areaInfo;
    private TextView areaDate;
    private TextView areaWebUrl;

    private ImageView areaImage;
    private AreaDetailPresenter presenter;
    private Area area;

    public static AreaDetailFragment newInstance() {
        AreaDetailFragment fragment = new AreaDetailFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AreaDetailPresenter();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            area = bundle.getParcelable("area");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area_detail, container, false);
        progressBar = view.findViewById(R.id.progress);
        areaTitle = view.findViewById(R.id.area_title);
        areaImage = view.findViewById(R.id.area_pic);
        areaInfo = view.findViewById(R.id.area_info);
        areaDate = view.findViewById(R.id.area_date);
        areaWebUrl = view.findViewById(R.id.area_webview);

        areaTitle.setText(area.getE_Name());
        areaInfo.setText(area.getE_Info());
        areaDate.setText(area.getE_Memo());
        areaWebUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb(area.getE_URL());
            }
        });

        Glide.with(getContext())
                .load(area.getE_Pic_URL())
                .into(areaImage);

        RecyclerView recyclerView = view.findViewById(R.id.area_detail_plants_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlantAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        presenter.getAreaData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        presenter.destroy();
    }

    @Override
    public void onGetPlantDataSuccess(List<Plant> plants) {
        adapter.update(plants);
    }

    @Override
    public void onGetPlantDataError(Throwable throwable) {

    }

    @Override
    public void showProgressing(boolean show) {

    }

    private void openWeb(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
