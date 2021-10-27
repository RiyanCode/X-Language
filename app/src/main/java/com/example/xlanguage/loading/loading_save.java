package com.example.xlanguage.loading;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;
import com.example.xlanguage.MainActivity;
import com.example.xlanguage.R;

public class loading_save extends AppCompatActivity {

    Button nexts;
    int getTmpLevel;


    ImageView motivate_one,motivate_two;
    ProgressBar loadingSave;

    LottieAnimationView saveAnimation , smileAnimation;
    int progress_s = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_save);
        Intent getDataFromIntent = getIntent();
        Bundle bndle_save = getDataFromIntent.getExtras();

        //declare ID image
        motivate_one = findViewById(R.id.motivate_first);
        motivate_two = findViewById(R.id.motivate_two);

        ObjectAnimator animation_one_translateY = ObjectAnimator.ofFloat(motivate_one,motivate_one.TRANSLATION_Y,0);
        animation_one_translateY.setDuration(4000);
        animation_one_translateY.setInterpolator(new AnticipateOvershootInterpolator());
        ObjectAnimator animation_one_translateXleft = ObjectAnimator.ofFloat(motivate_one,motivate_one.TRANSLATION_X,-500);
        animation_one_translateXleft.setDuration(4000);
        animation_one_translateXleft.setInterpolator(new AnticipateOvershootInterpolator());
        ObjectAnimator animation_one_fadeoutAlpha = ObjectAnimator.ofFloat(motivate_one,motivate_one.ALPHA,0);
        animation_one_fadeoutAlpha.setDuration(3000);
        animation_one_fadeoutAlpha.setInterpolator(
                new LinearInterpolator()
        );
        ObjectAnimator animation_two_translateY = ObjectAnimator.ofFloat(motivate_two,motivate_two.TRANSLATION_Y,0);
        animation_two_translateY.setDuration(3000);
        animation_two_translateY.setInterpolator(new AnticipateOvershootInterpolator());
        ObjectAnimator animation_two_translateXright = ObjectAnimator.ofFloat(motivate_two,motivate_two.TRANSLATION_X,700);
        animation_two_translateXright.setDuration(7000);
        animation_two_translateXright.setInterpolator(new AnticipateOvershootInterpolator());
        Handler delayAnimationOne = new Handler();
        animation_one_translateY .start();
        delayAnimationOne.postDelayed(new Runnable() {
            @Override
            public void run() {
                animation_one_translateXleft.start();
                animation_one_fadeoutAlpha.start();
            }
        },3000);

        Handler delayAnimationTwo = new Handler();
        delayAnimationTwo.postDelayed(new Runnable() {
            @Override
            public void run() {
                animation_two_translateY.start();
            }
        },5000);

        Handler delayAnimationTwoLeft = new Handler();
        delayAnimationTwoLeft.postDelayed(new Runnable() {
            @Override
            public void run() {
                animation_two_translateXright.start();
            }
        },7000);
        Handler mainActivityIntent = new Handler();
        mainActivityIntent.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(loading_save.this, MainActivity.class);

                mainIntent.putExtra("current_level_dragdrop",getDataFromIntent);

                startActivity(mainIntent);
                finish();
            }
        },10000);
    }
}