package com.example.xlanguage.loading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.xlanguage.R;
import com.example.xlanguage.type_learn.SceneDrag_One;

public class loading extends AppCompatActivity {

    ImageView motivateImg , motivaImgSecond , motivateFour;
    LottieAnimationView sparkanimate;
    TextView dataloading , prefName;
    TextView tittle, alphabetC , nonalphabetB;
    ImageView imgC;
    String getTittle[] , getEnglishTittle[] , getAlphabet[] , getNonAlphabet[],dataLevel,prefencesNameList , prefEditList;
    int getImageItem[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Handler waiting = new Handler();
        prefName = findViewById(R.id.prefName);
        tittle = findViewById(R.id.tittleEnglish);
        alphabetC = findViewById(R.id.alphabetc);
        nonalphabetB = findViewById(R.id.nonAlphabetB);
        imgC = findViewById(R.id.cImage);
        Intent getDataFromIntent = getIntent();
        Bundle b = getDataFromIntent.getExtras();

        Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        getImageItem = b.getIntArray("imageData");
        getEnglishTittle = b.getStringArray("tittleData");
        getAlphabet = b.getStringArray("alphabetData");
        getNonAlphabet = b.getStringArray("nonalphabetData");
        dataLevel = b.getString("levelData");
        prefencesNameList = b.getString("prefencesName");
        prefName.setText(prefencesNameList);
        tittle.setText(getEnglishTittle[0]);
        alphabetC.setText(getAlphabet[0]);
        nonalphabetB.setText(getNonAlphabet[0]);
        imgC.setImageResource(getImageItem[0]);
        SharedPreferences data = getSharedPreferences(prefencesNameList,MODE_PRIVATE);


        Animation motivateAnimationfadeIn = AnimationUtils.loadAnimation(loading.this,R.anim.translate_animation);
        Animation motivateAnimationfadeout = AnimationUtils.loadAnimation(loading.this,R.anim.fade_out);
        Animation motivateAnimationLeft = AnimationUtils.loadAnimation(loading.this,R.anim.translate_animation_left);
        dataloading = findViewById(R.id.positionloading);
        motivateImg = findViewById(R.id.motivate_imgfirst);
        sparkanimate = findViewById(R.id.sparkanimate);
        motivaImgSecond = findViewById(R.id.motivate_imgsecond);
        motivateFour = findViewById(R.id.motivate_four);
        motivateAnimationfadeIn.setDuration(1000);


        int getDatas = data.getInt(prefencesNameList,0);
        dataloading.setText(String.valueOf(getDatas));
        motivateImg.startAnimation(motivateAnimationfadeIn);
        ObjectAnimator move = ObjectAnimator.ofFloat(motivaImgSecond,motivaImgSecond.TRANSLATION_X,0);
            move.setDuration(3000);
            move.setInterpolator(new AnticipateOvershootInterpolator());

            ObjectAnimator animation_motivateFour = ObjectAnimator.ofFloat(motivateFour,motivateFour.TRANSLATION_Y,0);
            animation_motivateFour.setInterpolator(new AnticipateOvershootInterpolator());
            animation_motivateFour.setDuration(3000);
        Handler secondImgHandler = new Handler();
         secondImgHandler.postDelayed(new Runnable() {
             @Override
             public void run() {
                move.start();
             }
         },3000);
         Handler fourHandler = new Handler();
         fourHandler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 animation_motivateFour.start();
                 sparkanimate.setProgress(0F);
                 sparkanimate.playAnimation();
             }
         },5000);
        waiting.postDelayed(new Runnable() {
            @Override
            public void run() {
                motivateImg.startAnimation(motivateAnimationfadeout);
                Intent playdragdorp = new Intent(loading.this, SceneDrag_One.class);
                playdragdorp.putExtra("levelnext",getDatas);
                playdragdorp.putExtra("currentImage",getImageItem);
                playdragdorp.putExtra("currentTittle",getEnglishTittle);
                playdragdorp.putExtra("currentAlphabet",getAlphabet);
                playdragdorp.putExtra("currentNonAlphabet",getNonAlphabet);
                playdragdorp.putExtra("Level",dataLevel);
                playdragdorp.putExtra("namePrefe",prefencesNameList);
                playdragdorp.putExtra("editPref",prefEditList);
                playdragdorp.putExtra("positionItem",0);
                startActivity(playdragdorp);
                finish();
            }
        },10000);
        ConstraintLayout constraintlayout = findViewById(R.id.layouts);
        AnimationDrawable animationdrawable = (AnimationDrawable) constraintlayout.getBackground();
        animationdrawable.setEnterFadeDuration(2000);
        animationdrawable.setExitFadeDuration(4000);
        animationdrawable.start();
    }
}