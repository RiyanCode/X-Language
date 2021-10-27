    package com.example.xlanguage.type_learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.xlanguage.R;
import com.example.xlanguage.loading.loading_save;
import com.example.xlanguage.quest_new.quest_system;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SceneDrag_One extends AppCompatActivity {

    ImageView imageScene;
    TextView EnglishText , RomajiJapan;
    ImageView understandDropArea;
    TextToSpeech speachObject;
    TextView countTimer, level_display;
    SharedPreferences getTime;
    SharedPreferences.Editor editPrefences;
    SharedPreferences shareds;
    private long START_TIME_IN_MILLIS;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    long millisUntilFinished;
    ProgressBar levelTopBar;
    int levelProgress;
    LottieAnimationView circle_imageScene , background_shape , backgroundDropArea_pulse , verifiedAnswer, unverifiedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_drag_one);
        SharedPreferences prefs = getSharedPreferences("SAVED_T", MODE_PRIVATE);
        millisUntilFinished = prefs.getLong("millisUntilFinished", 600000);
        Intent getDataFromLoading= getIntent();
        Bundle bxs = getDataFromLoading.getExtras();
        level_display = findViewById(R.id.display_level_scene_one);
        final int[] progressLearn = {getDataFromLoading.getIntExtra("Level", 0)};
        levelTopBar = findViewById(R.id.levelBarSceneOne);

        // set sound
        MediaPlayer clickedHold = MediaPlayer.create(this,R.raw.select_clik);
        MediaPlayer unclickedHold = MediaPlayer.create(this,R.raw.click_error);
        MediaPlayer answerTrue = MediaPlayer.create(this,R.raw.notif_cli);
        MediaPlayer answerFailed = MediaPlayer.create(this,R.raw.error_login);
        //verified answer
        verifiedAnswer = findViewById(R.id.verified_true);
        verifiedAnswer.setScaleX(0F);
        verifiedAnswer.setScaleY(0F);
        // circle image scene

        circle_imageScene = findViewById(R.id.circle_one);
        backgroundDropArea_pulse = findViewById(R.id.background_dropArea);
        
        // background shape
        background_shape = findViewById(R.id.background_shape);
        ConstraintLayout scene_bg_gradientAnim = findViewById(R.id.bg_scene_one);
        AnimationDrawable animationDragDrop = (AnimationDrawable) scene_bg_gradientAnim.getBackground();
        animationDragDrop.setEnterFadeDuration(2000);
        animationDragDrop.setExitFadeDuration(4000);
        animationDragDrop.start();
        String getPrefName = bxs.getString("namePrefe");
        mCountDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            private long millisUntilFinished; // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                this.millisUntilFinished = millisUntilFinished;
                SharedPreferences.Editor editor = getSharedPreferences("SAVED_T", MODE_PRIVATE).edit();
                editor.putLong("millisUntilFinished", millisUntilFinished);
                editor.commit();
                countTimer.setText("" + String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
                                - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));

            }

            public void onFinish() {
                Intent Complete = new Intent(SceneDrag_One.this, loading_save.class);
                SharedPreferences.Editor clear_data = getSharedPreferences("SAVED_T",MODE_PRIVATE).edit();
                Complete.putExtra("dataLevelDrag", progressLearn[0]);
                clear_data.remove("millisUntilFinished");
                clear_data.commit();
             //   Complete.putExtra("dataLevelDrag",levelD);
                startActivity(Complete);
            }
        }.start();
        getTime = getSharedPreferences("SAVE_TIME",MODE_PRIVATE);;

        START_TIME_IN_MILLIS =getTime.getLong("TIME_CURRENT",60000);
        imageScene = findViewById(R.id.imageViewSceneOne);
        EnglishText = findViewById(R.id.englishTextSceneOne);
        RomajiJapan = findViewById(R.id.japanRomajiSceneOne);
        understandDropArea = findViewById(R.id.dropAreaUnderstand);
        countTimer = findViewById(R.id.timerView);

        speachObject = new TextToSpeech(SceneDrag_One.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                speachObject.setLanguage(Locale.JAPANESE);
                speachObject.setPitch(1.2F);
            }
        });
        //position


        Bundle bx = getDataFromLoading.getExtras();
        int imageListSceneOne[] = bx.getIntArray("currentImage");
        String englishText[] = bx.getStringArray("currentTittle");
        String japanText[] = bx.getStringArray("currentAlphabet");
        String romajiText[]  = bx.getStringArray("currentNonAlphabet");
        String PREF_POST = bxs.getString("PREF_POSITION");
        SharedPreferences SAVE_POSITION = getSharedPreferences(PREF_POST,MODE_PRIVATE);
        final int[] positionSceneOne={SAVE_POSITION.getInt("POSITION_IMAGE",0)};

        if(positionSceneOne[0] >= imageListSceneOne.length){
            positionSceneOne[0] =0;
            SharedPreferences.Editor edits = SAVE_POSITION.edit();
            edits.clear();
        }
        imageScene.setImageResource(imageListSceneOne[positionSceneOne[0]]);
        EnglishText.setText(englishText[positionSceneOne[0]]);
        RomajiJapan.setText(japanText[positionSceneOne[0]]);

        Handler DelayChangeText = new Handler();
            DelayChangeText.postDelayed(new Runnable() {
                @Override
                public void run() {
                        RomajiJapan.setText(romajiText[positionSceneOne[0]]);
                }
            },3000);
               imageScene.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                ClipData clipdata = ClipData.newPlainText("","");

                View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
                v.startDrag(clipdata,shadow,null,0);
                return true;
            }
        });

        understandDropArea.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()){
                    case DragEvent.ACTION_DRAG_STARTED:
                        clickedHold.start();
                        Handler pasueClicked = new Handler();
                        pasueClicked.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                clickedHold.pause();
                            }
                        },2000L);
                        circle_imageScene.setVisibility(View.VISIBLE);
                        ObjectAnimator circleFade  = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.ALPHA,1);
                        circleFade.setDuration(200);
                        ObjectAnimator circleScale = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.SCALE_X,1.5F);
                        circleScale.setDuration(1000L);
                        ObjectAnimator circleScaleY = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.SCALE_Y,1.5F);
                            circleScaleY.setDuration(1000L);
                            circleFade.start();
                            circleScale.start();
                            circleScaleY.start();

                        backgroundDropArea_pulse.setVisibility(View.VISIBLE);
                        ObjectAnimator circlePulseFade = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.ALPHA,1);
                        ObjectAnimator scaleXPulse = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.SCALE_X,2.3F);
                        ObjectAnimator scaleYPulse = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.SCALE_Y,2.3F);
                        circleFade.setInterpolator(new LinearInterpolator());
                        scaleXPulse.setInterpolator(new LinearInterpolator());
                        scaleYPulse.setInterpolator(new LinearInterpolator());
                        circleFade.setDuration(200);
                        scaleXPulse.setDuration(100);
                        scaleYPulse.setDuration(100);

                            circlePulseFade.start();
                            scaleXPulse.start();
                            scaleYPulse.start();

                            //set scale drop area when event.getAction() == Action.STARTED;
                        ObjectAnimator scaleDropArea_X = ObjectAnimator.ofFloat(understandDropArea,understandDropArea.SCALE_X,1.4F);
                        ObjectAnimator scaleDropArea_Y = ObjectAnimator.ofFloat(understandDropArea,understandDropArea.SCALE_Y,1.4F);

                        scaleDropArea_X.setDuration(200);
                        scaleDropArea_Y.setDuration(200).setInterpolator(new BounceInterpolator());
                        scaleDropArea_X.setInterpolator(new BounceInterpolator());
                        scaleDropArea_X.start();
                        scaleDropArea_Y.start();

                            long durationAnimationDraged = 900l;
                            ObjectAnimator scale_xImage = ObjectAnimator.ofFloat(imageScene,imageScene.SCALE_X,0.7F);
                            ObjectAnimator scale_yImage = ObjectAnimator.ofFloat(imageScene,imageScene.SCALE_Y,0.7F);
                            scale_xImage.setInterpolator(new BounceInterpolator());
                            scale_yImage.setInterpolator(new BounceInterpolator());
                            scale_xImage.setDuration(durationAnimationDraged);
                            scale_xImage.setDuration(durationAnimationDraged);
                            scale_xImage.start();
                            scale_yImage.start();
                            View castView = (View) imageScene;

                            imageScene.setVisibility(View.INVISIBLE);

                            //background shape
                        background_shape.setVisibility(View.VISIBLE);
                        ObjectAnimator background_ShapeFadeIn = ObjectAnimator.ofFloat(background_shape,
                                background_shape.ALPHA,1);
                        background_ShapeFadeIn.setInterpolator(new BounceInterpolator());
                        background_ShapeFadeIn.setDuration(230);
                        background_ShapeFadeIn.start();


                        speachObject.speak(japanText[positionSceneOne[0]], TextToSpeech.QUEUE_FLUSH,null);
                        //Scale -X -Y

                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                    case DragEvent.ACTION_DRAG_ENDED:
                        if(event.getResult()){
                            answerTrue.start();
                            verifiedAnswer.setVisibility(View.VISIBLE);
                            verifiedAnswer.playAnimation();
                            ObjectAnimator ANIMATION_SCALE_VERIFIED_X = ObjectAnimator.ofFloat(verifiedAnswer,verifiedAnswer.SCALE_X,1.0F);
                            ANIMATION_SCALE_VERIFIED_X.setDuration(1000L);
                            ANIMATION_SCALE_VERIFIED_X.setInterpolator(new BounceInterpolator());
                            ObjectAnimator ANIMATION_SCALE_VERIFIED_Y = ObjectAnimator.ofFloat(verifiedAnswer,verifiedAnswer.SCALE_Y,1.0F);
                            ANIMATION_SCALE_VERIFIED_Y.setDuration(1000L);
                            ANIMATION_SCALE_VERIFIED_Y.setInterpolator(new BounceInterpolator());
                            ANIMATION_SCALE_VERIFIED_X.start();
                            ANIMATION_SCALE_VERIFIED_Y.start();
                        Handler delayFadeOutVerifiedAnswer = new Handler();
                        delayFadeOutVerifiedAnswer.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                verifiedAnswer.setVisibility(View.INVISIBLE);
                                answerTrue.pause();
                            }
                        },4000L);



                            //fade out
                            ObjectAnimator FADE_OUT_IMAGE = ObjectAnimator.ofFloat(imageScene, imageScene.ALPHA,0);
                            ObjectAnimator FADE_OUT_ENGLISH = ObjectAnimator.ofFloat(EnglishText,EnglishText.ALPHA,0);
                            ObjectAnimator FADE_OUT_ROMAJI_JAPAN = ObjectAnimator.ofFloat(RomajiJapan,RomajiJapan.ALPHA,0);
                            FADE_OUT_ENGLISH.setDuration(300);
                            FADE_OUT_IMAGE.setDuration(300);
                            FADE_OUT_ROMAJI_JAPAN.setDuration(300);
                            imageScene.setEnabled(false);

                            FADE_OUT_IMAGE.setInterpolator(new LinearInterpolator());
                            FADE_OUT_ENGLISH.setInterpolator(new LinearInterpolator());
                            FADE_OUT_ROMAJI_JAPAN.setInterpolator(new LinearInterpolator());

                            //start
                            FADE_OUT_IMAGE.start();
                            FADE_OUT_ENGLISH.start();
                            FADE_OUT_ROMAJI_JAPAN.start();

                            //delay
                            Handler FADE_IN_SHOW = new Handler();
                            FADE_IN_SHOW.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    ObjectAnimator FADE_IN_IMAGE = ObjectAnimator.ofFloat(imageScene,imageScene.ALPHA,1);
                                    ObjectAnimator FADE_IN_ENGLISH = ObjectAnimator.ofFloat(EnglishText,EnglishText.ALPHA, 1);
                                    ObjectAnimator FADE_IN_ROMAJI_JAPAN = ObjectAnimator.ofFloat(RomajiJapan, RomajiJapan.ALPHA,1);
                                    //change image
                                    //set Interpolator
                                    FADE_IN_IMAGE.setInterpolator(new LinearInterpolator());
                                    FADE_IN_ENGLISH.setInterpolator(new LinearInterpolator());
                                    FADE_IN_ROMAJI_JAPAN.setInterpolator(new LinearInterpolator());
                                    //setDuration
                                    FADE_IN_IMAGE.setDuration(4000);
                                    FADE_IN_ENGLISH.setDuration(4000);
                                    FADE_IN_ROMAJI_JAPAN.setDuration(4000);


                                    FADE_IN_IMAGE.start();
                                    FADE_IN_ENGLISH.start();
                                    FADE_IN_ROMAJI_JAPAN.start();;
                                    //change image
                                    imageScene.setImageResource(imageListSceneOne[positionSceneOne[0]]);
                                    EnglishText.setText(englishText[positionSceneOne[0]]);
                                    RomajiJapan.setText(japanText[positionSceneOne[0]]);

                                    imageScene.setEnabled(true);
                                    verifiedAnswer.setVisibility(View.INVISIBLE);
                                    verifiedAnswer.setScaleX(0F);
                                    verifiedAnswer.setScaleY(0F);
                                    verifiedAnswer.pauseAnimation();
                                }
                            },3000);
                            //do
                            ObjectAnimator pulseFadeOut = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.ALPHA,0);
                            ObjectAnimator pulseDefaultScaleX = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.SCALE_X,1.0F);
                            ObjectAnimator pulseDefaultScaleY = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.SCALE_Y,1.0F);
                            pulseFadeOut.setDuration(200).setInterpolator(new BounceInterpolator());
                            pulseDefaultScaleX.setDuration(200).setInterpolator(new BounceInterpolator());
                            pulseDefaultScaleY.setDuration(200).setInterpolator(new BounceInterpolator());
                            pulseFadeOut.start();
                            pulseDefaultScaleX.start();
                            pulseDefaultScaleY.start();

                            //verified answer



                            backgroundDropArea_pulse.setVisibility(View.INVISIBLE);
                            ObjectAnimator circleFadeOut  = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.ALPHA,1);
                            circleFadeOut.setDuration(200);

                            ObjectAnimator circleScaleDefault_X = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.SCALE_X,0F);
                            circleScaleDefault_X.setDuration(1000L);
                            ObjectAnimator circleScaleDefault_Y = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.SCALE_Y,0F);
                            circleScaleDefault_Y.setDuration(1000L);
                            circleFadeOut.start();
                            circleScaleDefault_X.start();
                            circleScaleDefault_Y.start();

                            circle_imageScene.setVisibility(View.INVISIBLE);


                            //set drop area to default scale when result = true
                            ObjectAnimator set_DropArea_XDefa_ = ObjectAnimator.ofFloat(understandDropArea,understandDropArea.SCALE_X,1.0F);
                            ObjectAnimator set_DropArea_YDefa_ = ObjectAnimator.ofFloat(understandDropArea,understandDropArea.SCALE_Y,1.0F);
                            set_DropArea_XDefa_.setDuration(200).setInterpolator(new BounceInterpolator());
                            set_DropArea_YDefa_.setDuration(200).setInterpolator(new BounceInterpolator());
                            set_DropArea_XDefa_.start();
                            set_DropArea_YDefa_.start();

                            //set background shape
                            background_shape.setVisibility(View.INVISIBLE);
                            ObjectAnimator background_shapeFadeOut = ObjectAnimator.ofFloat(background_shape,background_shape.ALPHA,0);
                            background_shapeFadeOut.setInterpolator(new BounceInterpolator());
                            background_shapeFadeOut.setDuration(200);
                            background_shapeFadeOut.start();

                            positionSceneOne[0]++;

                            levelTopBar.setProgress(positionSceneOne[0]);
                            levelTopBar.setMax(imageListSceneOne.length);
                            progressLearn[0]++;
                            String lev = String.valueOf(progressLearn[0]++);
                            level_display.setText(lev);
                            shareds = getApplicationContext().getSharedPreferences(getPrefName,MODE_PRIVATE);
                            editPrefences = shareds.edit();
                            editPrefences.putInt(getPrefName, progressLearn[0]);
                            editPrefences.commit();

                            ObjectAnimator scaleDef_xImage =ObjectAnimator.ofFloat(imageScene,imageScene.SCALE_X,1.0f);
                            ObjectAnimator scaleDef_yImage = ObjectAnimator.ofFloat(imageScene, imageScene.SCALE_Y,1.0f);
                            scaleDef_xImage.setDuration(900L);
                            scaleDef_xImage.start();
                            scaleDef_yImage.start();

                            imageScene.setVisibility(View.VISIBLE);
                            if(positionSceneOne[0] == imageListSceneOne.length){
                                positionSceneOne[0] = 0;
                                Handler delayTrueSpeak = new Handler();
                                delayTrueSpeak.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        speachObject.speak(japanText[positionSceneOne[0]], TextToSpeech.QUEUE_FLUSH,null);
                                    }
                                },7000);
                                scaleDef_xImage.setDuration(900L);
                                scaleDef_xImage.start();
                                scaleDef_yImage.start();
                            } else{

                                Intent getImage = getIntent();
                                Bundle getDataImage = getImage.getExtras();
                                int imageDataSceneOne[] = getDataImage.getIntArray("currentImage");
                                String englishTextSceneOne[] = getDataImage.getStringArray("currentTittle");
                                String japanTextSceneOne[] = getDataImage.getStringArray("currentAlphabet");
                                String romajiTextSceneOne[]  = getDataImage.getStringArray("currentNonAlphabet");
                                final int[] progressLearn = {getImage.getIntExtra("levelnext",3)};
                                SharedPreferences.Editor  edit = SAVE_POSITION.edit();
                                edit.putInt("POSITION_IMAGE",positionSceneOne[0]);
                                edit.commit();

                                if(positionSceneOne[0] == imageListSceneOne.length - 1){
                                    edit.clear();
                                }
                                if(positionSceneOne[0] % 4 == 0){
                                    verifiedAnswer.setVisibility(View.INVISIBLE);
                                    Intent SCENE_TWO = new Intent(SceneDrag_One.this, check_nounType.class);
                                    SCENE_TWO.putExtra("positionFROMSCENEONE",positionSceneOne[0]);
                                    SCENE_TWO.putExtra("Level",progressLearn[0]);
                                    SCENE_TWO.putExtra("currentImage",imageDataSceneOne);
                                    SCENE_TWO.putExtra("currentTittle",englishTextSceneOne);
                                    SCENE_TWO.putExtra("currentAlphabet",japanTextSceneOne);
                                    SCENE_TWO.putExtra("currentNonAlphabet",romajiTextSceneOne);
                                    SCENE_TWO.putExtra("positionItem",positionSceneOne[0]);
                                    SCENE_TWO.putExtra("prefName",getPrefName);
                                    SCENE_TWO.putExtra("PREF_LEVEL",PREF_POST);

                                    startActivity(SCENE_TWO);
                                } else if(positionSceneOne[0] % 6 == 0){
                                    Intent SCENE_TWO = new Intent(SceneDrag_One.this, stage_proceduralDrops.class);
                                    SCENE_TWO.putExtra("Level",progressLearn);
                                    SCENE_TWO.putExtra("IMAGE_SCENE_ONE",imageDataSceneOne);
                                    SCENE_TWO.putExtra("ENGLISH_TEXT_SCENE_ONE",englishTextSceneOne);
                                    SCENE_TWO.putExtra("JAPANESE_TEXT_SCENE_ONE",japanTextSceneOne);
                                    SCENE_TWO.putExtra("ROMAJI_TEXT_SCENE_ONE",romajiTextSceneOne);
                                    SCENE_TWO.putExtra("positionItem",positionSceneOne[0]);
                                    SCENE_TWO.putExtra("prefName",getPrefName);
                                    SCENE_TWO.putExtra("PREF_LEVEL",PREF_POST);
                                }


                                Handler DelayChangeText = new Handler();
                                DelayChangeText.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        RomajiJapan.setText(romajiText[positionSceneOne[0]]);
                                        speachObject.speak(japanText[positionSceneOne[0]], TextToSpeech.QUEUE_FLUSH,null);

                                    }
                                },5000);
                            }

                        } else{
                            //do somethinghh
                            unclickedHold.start();
                            Handler unclickedPause = new Handler();
                            unclickedPause.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    unclickedHold.pause();
                                }
                            },4000L);
                            ObjectAnimator scaleDef_xImage =ObjectAnimator.ofFloat(imageScene,imageScene.SCALE_X,1.0f);
                            ObjectAnimator scaleDef_yImage = ObjectAnimator.ofFloat(imageScene, imageScene.SCALE_Y,1.0f);
                            scaleDef_xImage.setDuration(900L);
                            scaleDef_xImage.start();
                            scaleDef_yImage.start();

                            //set circle aniamtion to default scale when state = false
                            circle_imageScene.setVisibility(View.INVISIBLE);
                            ObjectAnimator circleFadeOut  = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.ALPHA,1);
                            circleFadeOut.setDuration(200);
                            ObjectAnimator circleScaleDefault_X = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.SCALE_X,0F);
                            circleScaleDefault_X.setDuration(1000L);
                            ObjectAnimator circleScaleDefault_Y = ObjectAnimator.ofFloat(circle_imageScene,circle_imageScene.SCALE_Y,0F);
                            circleScaleDefault_Y.setDuration(1000L);
                            circleFadeOut.start();
                            circleScaleDefault_X.start();
                            circleScaleDefault_Y.start();

                            backgroundDropArea_pulse.setVisibility(View.INVISIBLE);
                            ObjectAnimator pulseFadeOut = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.ALPHA,0);
                            ObjectAnimator pulseDefaultScaleX = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.SCALE_X,1.0F);
                            ObjectAnimator pulseDefaultScaleY = ObjectAnimator.ofFloat(backgroundDropArea_pulse,backgroundDropArea_pulse.SCALE_Y,1.0F);
                            pulseFadeOut.setDuration(200).setInterpolator(new BounceInterpolator());
                            pulseDefaultScaleX.setDuration(200).setInterpolator(new BounceInterpolator());
                            pulseDefaultScaleY.setDuration(200).setInterpolator(new BounceInterpolator());
                            pulseFadeOut.start();
                            pulseDefaultScaleX.start();
                            pulseDefaultScaleY.start();



                            //set drop area to default scale when result = true
                            ObjectAnimator set_DropArea_XDefa_ = ObjectAnimator.ofFloat(understandDropArea,understandDropArea.SCALE_X,1.0F);
                            ObjectAnimator set_DropArea_YDefa_ = ObjectAnimator.ofFloat(understandDropArea,understandDropArea.SCALE_Y,1.0F);
                            set_DropArea_XDefa_.setDuration(200).setInterpolator(new BounceInterpolator());
                            set_DropArea_YDefa_.setDuration(200).setInterpolator(new BounceInterpolator());
                            set_DropArea_XDefa_.start();
                            set_DropArea_YDefa_.start();

                            //set background
                            background_shape.setVisibility(View.INVISIBLE);
                            ObjectAnimator background_shapeFadeOut = ObjectAnimator.ofFloat(background_shape,background_shape.ALPHA,0);
                            background_shapeFadeOut.setInterpolator(new BounceInterpolator());
                            background_shapeFadeOut.setDuration(200);
                            background_shapeFadeOut.start();

                            Toast.makeText(getApplicationContext(), "Drop Failed", Toast.LENGTH_SHORT).show();
                            imageScene.setVisibility(View.VISIBLE);
                            imageScene.setEnabled(true);
                        }
                        break;
                }
                return true;
            }
        });



    }
}