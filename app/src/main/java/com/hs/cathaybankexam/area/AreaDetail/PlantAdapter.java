package com.hs.cathaybankexam.area.AreaDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hs.cathaybankexam.R;
import com.hs.cathaybankexam.area.OnItemClick;
import com.hs.cathaybankexam.model.Plant;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {

    private List<Plant> items;
    private Context context;

    private OnItemClick onItemClick;

    PlantAdapter(Context context, OnItemClick onItemClick) {
        this.context = context;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_plant_profile, parent, false);
        PlantAdapter.ViewHolder holder = new PlantAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getF_Name_Ch());

        Glide.with(this.context)
                .load(items.get(position).getF_Pic01_URL())
                .circleCrop()
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new ClickListener(items.get(position)));
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }


    void update(List<Plant> mItems) {
        this.items = mItems;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    class ClickListener implements View.OnClickListener {

        private Plant plant;
        public ClickListener(Plant plant) {
            this.plant = plant;
        }

        @Override
        public void onClick(View v) {
            onItemClick.onClick(plant);
        }
    }
}
