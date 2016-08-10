package com.ddmeng.appbarlayoutsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "AppBarInDetails";
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.bottom_sheet_content)
    View bottomSheetContent;

    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setTitle("Details Title");

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.i(TAG, "onOffsetChanged: verticalOffset " + verticalOffset);
            }
        });

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetContent);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setPeekHeight(100);

    }

    @OnClick(R.id.floating_action_button)
    void onFABClicked(View view) {
        Snackbar.make(view, "Hi, I'm a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // DO Sth when Action clicked
                    }
                }).show();
    }

    @OnClick(R.id.card_item_1)
    void showBottomSheet() {
        int lastState = bottomSheetBehavior.getState();
        switch (lastState) {
            case BottomSheetBehavior.STATE_COLLAPSED:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case BottomSheetBehavior.STATE_EXPANDED:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case BottomSheetBehavior.STATE_HIDDEN:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
        }
    }

    @OnClick(R.id.card_item_2)
    void showBottomSheetDialog() {
        MyBottomSheetDialogFragment myBottomSheetDialogFragment = new MyBottomSheetDialogFragment();
        myBottomSheetDialogFragment.show(getSupportFragmentManager(), MyBottomSheetDialogFragment.TAG);
    }

    @OnClick(R.id.card_item_3)
    void showNewActivity() {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

}
