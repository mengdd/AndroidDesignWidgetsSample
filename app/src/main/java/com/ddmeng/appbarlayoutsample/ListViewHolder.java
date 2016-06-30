package com.ddmeng.appbarlayoutsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.content_text)
    TextView textView;

    public ListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.card_item)
    void onListItemClicked() {
        Context context = itemView.getContext();
        Intent intent = new Intent(context, DetailsActivity.class);
        context.startActivity(intent);

    }
}
