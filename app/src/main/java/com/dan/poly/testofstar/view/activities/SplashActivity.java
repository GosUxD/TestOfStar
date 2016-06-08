package com.dan.poly.testofstar.view.activities;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.dan.poly.testofstar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 6/8/2016.
 */
public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.activity_splash_logo)
    ImageView mLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


        startAnim();
    }

    public void startAnim() {
        int scale = (int) getResources().getDisplayMetrics().density;
        ObjectAnimator logoAnimator = ObjectAnimator.ofFloat(mLogo, View.TRANSLATION_Y, 200 * scale);
        logoAnimator.setInterpolator(new BounceInterpolator());
        logoAnimator.setDuration(1000);
        logoAnimator.setStartDelay(1000);
        logoAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivity.this, FeedActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        logoAnimator.start();
    }


}
