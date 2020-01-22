package com.hs.cathaybankexam.area.AreaList;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hs.cathaybankexam.R;
import com.hs.cathaybankexam.area.OnItemClick;
import com.hs.cathaybankexam.model.Area;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {

    private List<Area> items;
    private Context context;
    private OnItemClick onItemClick;

    private static final int ANIMATION_DURATION = 500;
    private boolean onAttach = true;

    public AreaAdapter(Context context, OnItemClick onItemClick) {
        this.context = context;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public AreaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_area, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getE_Name());
        holder.description.setText(items.get(position).getE_Info());
        holder.release_date.setText(items.get(position).getE_Memo());

        holder.itemView.setOnClickListener(new ClickListener(items.get(position)));

        Glide.with(this.context)
                .load(items.get(position).getE_Pic_URL())
                .centerCrop()
                .into(holder.imageView);

        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                onAttach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        super.onAttachedToRecyclerView(recyclerView);
    }

    void update(List<Area> mItems) {
        this.items = mItems;
        notifyDataSetChanged();
    }

    private void setAnimation(View itemView, int i) {
        if (!onAttach) {
            i = -1;
        }
        boolean isNotFirstItem = i == -1;
        i++;
        itemView.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(itemView, "alpha", 0.f, 0.5f, 1.0f);
        ObjectAnimator.ofFloat(itemView, "alpha", 0.f).start();
        animator.setStartDelay(isNotFirstItem ? ANIMATION_DURATION / 2 : (i * ANIMATION_DURATION / 3));
        animator.setDuration(ANIMATION_DURATION);
        animatorSet.play(animator);
        animator.start();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pic)
        ImageView imageView;
        private TextView title;
        private TextView description;
        private TextView release_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            release_date = itemView.findViewById(R.id.date);

        }
    }

    class ClickListener implements View.OnClickListener {

        private Area area;

        ClickListener(Area area) {
            this.area = area;
        }

        @Override
        public void onClick(View v) {
            onItemClick.onClick(area);
        }
    }

}
