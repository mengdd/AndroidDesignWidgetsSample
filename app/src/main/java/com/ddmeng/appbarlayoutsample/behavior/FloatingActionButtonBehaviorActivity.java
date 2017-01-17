package com.ddmeng.appbarlayoutsample.behavior;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import com.ddmeng.appbarlayoutsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FloatingActionButtonBehaviorActivity extends AppCompatActivity {

    @BindView(R.id.container)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button_behavior);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.show_button)
    void onShowButtonClick() {
        Snackbar.make(coordinatorLayout, "Hey there!", Snackbar.LENGTH_LONG).show();

    }
}
