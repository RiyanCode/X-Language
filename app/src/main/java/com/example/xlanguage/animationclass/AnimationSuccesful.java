package com.example.xlanguage.animationclass;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.airbnb.lottie.LottieAnimationView;
import com.example.xlanguage.R;

import java.util.logging.Handler;

public class AnimationSuccesful {
    Activity activity;
    AlertDialog dialog;
    LottieAnimationView animationview;
    public AnimationSuccesful(Activity myActivity,LottieAnimationView lottieAnim){
        this.activity = myActivity;
        this.animationview = lottieAnim;
    }

    void startDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();

    }
    void dismissDialog(){
        dialog.dismiss();;
    }
}
