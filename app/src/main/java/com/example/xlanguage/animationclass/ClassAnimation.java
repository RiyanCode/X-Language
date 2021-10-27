package com.example.xlanguage.animationclass;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Interpolator;
import android.view.View;
import android.view.animation.BounceInterpolator;

import java.util.logging.Handler;

public class ClassAnimation {

    View v;
    int valueAnimation;
    long duration;
    TimeInterpolator interpolatorType;
    public ClassAnimation(View v , int valueAnimation , long duration, TimeInterpolator interpolatorType){
        this.v = v;
        this.valueAnimation = valueAnimation;
        this.duration = duration;
        this.interpolatorType = interpolatorType;
    }

    public void fadeOutAnimation(){
        ObjectAnimator objectFadeOut = ObjectAnimator.ofFloat(v,v.ALPHA,0);
        objectFadeOut.setDuration(duration);
        objectFadeOut.setInterpolator(interpolatorType);
        objectFadeOut.start();
    }

    public void fadeOutAnimation(TimeInterpolator interpolatorCustomType){
        ObjectAnimator objectFadeOut = ObjectAnimator.ofFloat(v,v.ALPHA,0);
        objectFadeOut.setDuration(duration);
        objectFadeOut.setInterpolator(interpolatorCustomType);
    }

    public void fadeInAnimation(){
        ObjectAnimator objectFadeIn = ObjectAnimator.ofFloat(v,v.ALPHA,1);
        objectFadeIn.setDuration(duration);
        objectFadeIn.setInterpolator(interpolatorType);
    }
    public void fadeInAnimation(TimeInterpolator interpolatorTypeCustom){
        ObjectAnimator objectFadeIn = ObjectAnimator.ofFloat(v,v.ALPHA,1);
        objectFadeIn.setDuration(duration);
        objectFadeIn.setInterpolator(interpolatorTypeCustom);
    }

    public void fadeOutFadeIn(){
        ObjectAnimator objectFadeOut = ObjectAnimator.ofFloat(v,v.ALPHA,0);
        ObjectAnimator objectFadeIn = ObjectAnimator.ofFloat(v,v.ALPHA,1);
        objectFadeOut.setInterpolator(interpolatorType);
        objectFadeIn.setInterpolator(interpolatorType);
        objectFadeIn.setDuration(duration);
        objectFadeOut.setDuration(duration);

    }
}
