package com.dan.poly.testofstar.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.dan.poly.testofstar.R;
import com.dan.poly.testofstar.view.fragments.FeedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new FeedFragment()).commit();
        }

    }
}
