package com.hs.cathaybankexam.plant;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hs.cathaybankexam.R;
import com.hs.cathaybankexam.model.Plant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantActivity extends AppCompatActivity {
    @BindView(R.id.plant_pic)
    ImageView imageView;
    @BindView(R.id.plant_title)
    TextView plantTitle;
    @BindView(R.id.plant_eng_title)
    TextView plantEngTitle;
    @BindView(R.id.plant_also_known_name)
    TextView plantOtherName;
    @BindView(R.id.plant_brief)
    TextView plantBrief;
    @BindView(R.id.plant_feature)
    TextView plantFeature;
    @BindView(R.id.plant_function)
    TextView plantFunction;
    @BindView(R.id.plant_update_date)
    TextView plantUpdateDate;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    private Plant plant;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);
        ButterKnife.bind(this);

        plant = getIntent().getExtras().getParcelable("plant");
        initToolbar();

        if (plant != null) {
            initView();
        }
    }

    void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void initView() {
        Glide.with(this.getBaseContext())
                .load(plant.getF_Pic01_URL())
                .centerInside()
                .into(imageView);

        toolbarTitle.setText(plant.getF_Name_Ch());
        plantTitle.append(plant.getF_Name_Ch());
        plantEngTitle.append(plant.getF_Name_En());
        plantOtherName.append(plant.getF_AlsoKnown());
        plantBrief.append(plant.getF_Brief());
        plantFeature.append(plant.getF_Feature());
        plantFunction.append(plant.getF_Function_Application());
        plantUpdateDate.append(plant.getF_Update());
    }
}
