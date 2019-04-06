package com.csd.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.csd.myapplication.R;
import com.csd.myapplication.models.MyItem;

import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<MyItem> myItems;

    public MyItemRecyclerViewAdapter(Context context, List<MyItem> myItems) {
        this.context = context;
        this.myItems = myItems;
    }

    @NonNull
    @Override
    public MyItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_item_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        MyItem myItem = myItems.get(i);
        viewHolder.title.setText(myItem.getTitle());
        viewHolder.subTitle.setText(myItem.getSubTitle());
        viewHolder.icon.setImageResource(myItem.getIconid());

    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        TextView subTitle;
        RelativeLayout list;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tvtitle);
            this.subTitle = itemView.findViewById(R.id.tvsubTitle);
            this.list = itemView.findViewById(R.id.rlitemView);
            this.icon = itemView.findViewById(R.id.ivicon);
        }
    }
}
