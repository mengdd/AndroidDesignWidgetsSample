package com.ddmeng.appbarlayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = RecyclerViewActivity.class.getSimpleName();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private static final String itemData = "This is some dummy text for shown in list view, every single word will be treated as an item";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity_layout);
        ButterKnife.bind(this);

        toolbar.setTitle("Hello RecyclerView");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        String[] listItems = itemData.split(" ");
        Log.i(TAG, "ata list length: " + listItems.length);

        List<String> list = new ArrayList<>();
        Collections.addAll(list, listItems);

        RecyclerViewListAdapter adapter = new RecyclerViewListAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
