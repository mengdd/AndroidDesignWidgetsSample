package com.ddmeng.appbarlayoutsample;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputActivity extends AppCompatActivity {

    @BindView(R.id.username_text_input_layout)
    TextInputLayout usernameInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);

        usernameInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.length() > 0 && text.length() <= 4) {
                    usernameInputLayout.setError(getString(R.string.username_required));
                    usernameInputLayout.setErrorEnabled(true);
                } else {
                    usernameInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
