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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hs.cathaybankexam.MainActivity;
import com.hs.cathaybankexam.R;
import com.hs.cathaybankexam.area.OnItemClick;
import com.hs.cathaybankexam.model.Area;
import com.hs.cathaybankexam.model.Plant;
import com.hs.cathaybankexam.plant.PlantActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AreaDetailFragment extends Fragment implements AreaDetailContract.View {
    private PlantAdapter adapter;
    private ProgressBar progressBar;

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
        presenter = new AreaDetailPresenter(this, new AreaDetailRepoImpl());

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
        TextView areaTitle = view.findViewById(R.id.area_title);
        ImageView areaImage = view.findViewById(R.id.area_pic);
        TextView areaInfo = view.findViewById(R.id.area_info);
        TextView areaDate = view.findViewById(R.id.area_date);
        TextView areaWebUrl = view.findViewById(R.id.area_webview);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getChildFragmentManager().getBackStackEntryCount() > 0) {
                    ((MainActivity) getContext()).onBackPressed();
                }
            }
        });

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
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlantAdapter(getContext(), new OnItemClick() {
            @Override
            public void onClick(Object object) {
                if(!(object instanceof Plant)){
                    return;
                }
                Plant plant = (Plant) object;
                Intent i = new Intent(getActivity(), PlantActivity.class);
                Bundle b = new Bundle();
                b.putParcelable("plant", plant);
                i.putExtras(b);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getAreaDetailPlantData(area.getE_Name());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void onGetPlantDataSuccess(List<Plant> plants) {
        adapter.update(plants);
    }

    @Override
    public void onGetPlantDataError(Throwable throwable) {
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

    private void openWeb(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
