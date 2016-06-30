package com.ddmeng.appbarlayoutsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabFragment extends Fragment {
    private static final String TAG = "TabFragment";

    @BindView(R.id.list_in_fragment)
    RecyclerView recyclerView;

    private static final String itemData = "This is some dummy text for shown in list view, every single word will be treated as an item";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        String[] listItems = itemData.split(" ");
        Log.i(TAG, "ata list length: " + listItems.length);

        List<String> list = new ArrayList<>();
        Collections.addAll(list, listItems);

        RecyclerViewListAdapter adapter = new RecyclerViewListAdapter(list);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
