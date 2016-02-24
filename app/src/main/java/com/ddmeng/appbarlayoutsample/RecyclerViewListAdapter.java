package com.ddmeng.appbarlayoutsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<String> dataList;

    public RecyclerViewListAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,
                parent, false);
        return new ListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}
