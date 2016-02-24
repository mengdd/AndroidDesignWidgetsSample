package com.ddmeng.appbarlayoutsample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ListViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.content_text)
    TextView textView;

    public ListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
