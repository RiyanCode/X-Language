package com.example.xlanguage.type_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.xlanguage.R;

import java.util.Locale;

public class SceneDrag_Two extends AppCompatActivity {

    ImageView object_one, object_two, object_three, show_language;
    TextView areadDroped , text_one , text_two , text_three, areaDropJapan;
    TextToSpeech textToSpech;
    LottieAnimationView answerTrues, answerWrongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_drag_two);
        Intent getData = getIntent();
        Bundle dataBundleSceneOne = getData.getExtras();
        SharedPreferences SAVE_DATA_TWO = getSharedPreferences("SAVE_POST_TWO",MODE_PRIVATE);
        final int[] post_scene_2 = {SAVE_DATA_TWO.getInt("POSITION_SCENE_TWOS",0)};
        Log.d(String.valueOf(post_scene_2[0]), "onCreate: ");
        object_one = findViewById(R.id.imageViewSceneOne_itemone);
        object_two = findViewById(R.id.imageViewSceneOne_itemtwo);
        object_three = findViewById(R.id.imageViewSceneOne_itemthree);
        answerTrues = findViewById(R.id.verified_scenetwo_true);
        answerWrongs = findViewById(R.id.verified_scenetwo_false);


        text_one = findViewById(R.id.text_ones);
        text_two = findViewById(R.id.text_twos);
        text_three = findViewById(R.id.text_threes);
        text_one.setAlpha(0f);
        text_two.setAlpha(0f);
        text_three.setAlpha(0f);
        /*
        ObjectAnimator scale_XtoGrow_text_one = ObjectAnimator.ofFloat(text_one,text_one.SCALE_X,0.0F);
        ObjectAnimator scale_YtoGrow_text_one = ObjectAnimator.ofFloat(text_one,text_one.SCALE_Y,0.0F);
        ObjectAnimator scale_XtoGrow_text_two = ObjectAnimator.ofFloat(text_two,text_two.SCALE_X,0F);
        ObjectAnimator scale_YtoGrow_text_two = ObjectAnimator.ofFloat(text_two,text_two.SCALE_Y,0F);
        ObjectAnimator scale_XtoGrow_text_three = ObjectAnimator.ofFloat(text_three,text_three.SCALE_X,0F);
        ObjectAnimator scale_YtoGrow_text_three = ObjectAnimator.ofFloat(text_three,text_three.SCALE_Y,0F);

        scale_XtoGrow_text_one.setInterpolator(new BounceInterpolator());
        scale_YtoGrow_text_one.setInterpolator(new BounceInterpolator());
        scale_XtoGrow_text_two.setInterpolator(new BounceInterpolator());
        scale_YtoGrow_text_two.setInterpolator(new BounceInterpolator());
        scale_XtoGrow_text_three.setInterpolator(new BounceInterpolator());
        scale_YtoGrow_text_three.setInterpolator(new BounceInterpolator());

        scale_XtoGrow_text_one.setDuration(3000L);
        scale_YtoGrow_text_one.setDuration(3000L);
        scale_XtoGrow_text_two.setDuration(3000L);
        scale_YtoGrow_text_two.setDuration(3000L);
        scale_XtoGrow_text_three.setDuration(3000L);
        scale_YtoGrow_text_three.setDuration(3000L);

        scale_XtoGrow_text_one.start();
        scale_YtoGrow_text_one.start();
        scale_XtoGrow_text_two.start();
        scale_YtoGrow_text_two.start();
        scale_XtoGrow_text_three.start();
        scale_YtoGrow_text_three.start();

        ObjectAnimator fade_in_one = ObjectAnimator.ofFloat(text_one,text_one.ALPHA,1);
        ObjectAnimator fade_in_two = ObjectAnimator.ofFloat(text_two,text_two.ALPHA,1);
        text_one.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
        text_two.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] - 1]);
        text_three.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] - 2]);

        ObjectAnimator fade_in_three = ObjectAnimator.ofFloat(text_three,text_three.ALPHA,1);
        fade_in_one.setInterpolator(new LinearInterpolator());
        fade_in_two.setInterpolator(new LinearInterpolator());
        fade_in_three.setInterpolator(new LinearInterpolator());
        fade_in_one.setDuration(3000L);
        fade_in_two.setDuration(3000L);
        fade_in_three.setDuration(3000L);
        fade_in_one.start();
        fade_in_two.start();
        fade_in_three.start();

         */

/*
        //display scale
        ObjectAnimator scale_XtoGrow_text_one = ObjectAnimator.ofFloat(text_one,text_one.SCALE_X,1.0F);
        ObjectAnimator scale_YtoGrow_text_one = ObjectAnimator.ofFloat(text_one,text_one.SCALE_Y,1.0F);
        ObjectAnimator scale_XtoGrow_text_two = ObjectAnimator.ofFloat(text_two,text_two.SCALE_X,1F);
        ObjectAnimator scale_YtoGrow_text_two = ObjectAnimator.ofFloat(text_two,text_two.SCALE_Y,1F);
        ObjectAnimator scale_XtoGrow_text_three = ObjectAnimator.ofFloat(text_three,text_three.SCALE_X,1F);
        ObjectAnimator scale_YtoGrow_text_three = ObjectAnimator.ofFloat(text_three,text_three.SCALE_Y,1F);

        scale_XtoGrow_text_one.setInterpolator(new BounceInterpolator());
        scale_YtoGrow_text_one.setInterpolator(new BounceInterpolator());
        scale_XtoGrow_text_two.setInterpolator(new BounceInterpolator());
        scale_YtoGrow_text_two.setInterpolator(new BounceInterpolator());
        scale_XtoGrow_text_three.setInterpolator(new BounceInterpolator());
        scale_YtoGrow_text_three.setInterpolator(new BounceInterpolator());

        scale_XtoGrow_text_one.setDuration(1000L);
        scale_YtoGrow_text_one.setDuration(1000L);
        scale_XtoGrow_text_two.setDuration(1000L);
        scale_YtoGrow_text_two.setDuration(1000L);
        scale_XtoGrow_text_three.setDuration(1000L);
        scale_YtoGrow_text_three.setDuration(1000L);

        scale_XtoGrow_text_one.start();
        scale_YtoGrow_text_one.start();
        scale_XtoGrow_text_two.start();
        scale_YtoGrow_text_two.start();
        scale_XtoGrow_text_three.start();
        scale_YtoGrow_text_three.start();
*/

        show_language = findViewById(R.id.display_romaji);

        MediaPlayer click_item = MediaPlayer.create(this,R.raw.select_clik);
        MediaPlayer unclick_item = MediaPlayer.create(this,R.raw.click_error);
        MediaPlayer answer_true = MediaPlayer.create(this,R.raw.notif_cli);



        areadDroped = findViewById(R.id.dropAreaScenetwo);
        areaDropJapan = findViewById(R.id.areaddroptextJapan);

        int IMAGE_FROM_SCENE_ONE[] = dataBundleSceneOne.getIntArray("currentImage");
        String ENGLISH_TEXT_SCENE_ONE[] = dataBundleSceneOne.getStringArray("currentTittle");
        String JAPAN_TEXT_SCENE_ONE[] = dataBundleSceneOne.getStringArray("currentAlphabet");
        String ROMAJI_TEXT_SCENE_ONE[] = dataBundleSceneOne.getStringArray("currentNonAlphabet");

        if(post_scene_2[0] >= IMAGE_FROM_SCENE_ONE.length){
            post_scene_2[0] = 0;
            SharedPreferences.Editor editData = SAVE_DATA_TWO.edit();
            editData.clear();
            editData.commit();
        }
        textToSpech = new TextToSpeech(SceneDrag_Two.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpech.setLanguage(Locale.JAPANESE);
                textToSpech.setPitch(1.2F);
            }
        });
        int dataLevel = dataBundleSceneOne.getInt("Level",0);
        //set IMAGe

        //set Tag
        int max = IMAGE_FROM_SCENE_ONE.length;
        int min = IMAGE_FROM_SCENE_ONE.length - max;

        show_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(post_scene_2[0] >= max){


                    Handler delay_english = new Handler();
                    delay_english.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            text_one.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] - 1]);
                            text_three.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] - 2]);
                        }
                    },3000);

                    Handler delay_alphabet = new Handler();
                    delay_alphabet.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            text_one.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0] - 1]);
                            text_three.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0] - 2]);
                        }
                    },4000);

                    Handler delay_romaji = new Handler();
                    delay_romaji.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            text_one.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 1]);
                            text_three.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 2]);
                        }
                    },6000);

                    Handler fade_out = new Handler();
                    fade_out.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ObjectAnimator fade_one = ObjectAnimator.ofFloat(text_one,text_one.ALPHA,0);
                            ObjectAnimator fade_two = ObjectAnimator.ofFloat(text_two,text_two.ALPHA,0);
                            ObjectAnimator fade_three = ObjectAnimator.ofFloat(text_three,text_three.ALPHA,0);
                            fade_one.setInterpolator(new LinearInterpolator());
                            fade_two.setInterpolator(new LinearInterpolator());
                            fade_three.setInterpolator(new LinearInterpolator());

                            fade_one.setDuration(2000);
                            fade_two.setDuration(2000);
                            fade_three.setDuration(2000);

                            fade_one.start();
                            fade_two.start();
                            fade_three.start();
                            text_one.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 1]);
                            text_three.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 2]);
                        }
                    },7000);
                } else if(post_scene_2[0] <= max - 2){
                text_one.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                text_two.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] + 1]);
                text_three.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] + 2]);

                    ObjectAnimator fade_in_one = ObjectAnimator.ofFloat(text_one,text_one.ALPHA,1);
                    ObjectAnimator fade_in_two = ObjectAnimator.ofFloat(text_two,text_two.ALPHA,1);
                    ObjectAnimator fade_in_three = ObjectAnimator.ofFloat(text_three,text_three.ALPHA,1);
                    fade_in_one.setInterpolator(new LinearInterpolator());
                    fade_in_two.setInterpolator(new LinearInterpolator());
                    fade_in_three.setInterpolator(new LinearInterpolator());
                    fade_in_one.setDuration(3000L);
                    fade_in_two.setDuration(3000L);
                    fade_in_three.setDuration(3000L);
                    fade_in_one.start();
                    fade_in_two.start();
                    fade_in_three.start();
                    Handler delay_english = new Handler();
                    delay_english.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            text_one.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] + 1]);
                            text_three.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0] + 2]);
                        }
                    },3000);

                    Handler delay_alphabet = new Handler();
                    delay_alphabet.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            text_one.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0] + 1]);
                            text_three.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0] + 2]);
                        }
                    },4000);

                    Handler delay_romaji = new Handler();
                    delay_romaji.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            text_one.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 1]);
                            text_three.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 2]);
                        }
                    },6000);

                    Handler fade_out = new Handler();
                    fade_out.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ObjectAnimator fade_one = ObjectAnimator.ofFloat(text_one,text_one.ALPHA,0);
                            ObjectAnimator fade_two = ObjectAnimator.ofFloat(text_two,text_two.ALPHA,0);
                            ObjectAnimator fade_three = ObjectAnimator.ofFloat(text_three,text_three.ALPHA,0);
                            fade_one.setInterpolator(new LinearInterpolator());
                            fade_two.setInterpolator(new LinearInterpolator());
                            fade_three.setInterpolator(new LinearInterpolator());

                            fade_one.setDuration(2000);
                            fade_two.setDuration(2000);
                            fade_three.setDuration(2000);

                            fade_one.start();
                            fade_two.start();
                            fade_three.start();
                            text_one.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                            text_two.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 1]);
                            text_three.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 2]);
                        }
                    },7000);
                }
            }
        });
        if(post_scene_2[0] == max){
            post_scene_2[0] = 0;
        }
        if(post_scene_2[0] >= max){
            post_scene_2[0] = 0;
            object_one.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0]]);
            object_two.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] - 1]);
            object_three.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] - 2]);
            Handler delay_one = new Handler();
            areadDroped.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
            areaDropJapan.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0]]);
            delay_one.postDelayed(new Runnable() {
                @Override
                public void run() {
                    areadDroped.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0]]);
                }
            },3000);

            Handler delay_two = new Handler();
            delay_two.postDelayed(new Runnable() {
                @Override
                public void run() {
                    areadDroped.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                }
            },6000);

            String FIRST_OBJECT_TAG = ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]];
            String TWO_OBJECT_TAG = ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 1];
            String THREE_OBJECT_TAG = ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 2];

            object_one.setTag(FIRST_OBJECT_TAG);
            object_two.setTag(TWO_OBJECT_TAG);
            object_three.setTag(THREE_OBJECT_TAG);
            object_one.setOnTouchListener(new choiceMultipleItem());
            object_two.setOnTouchListener(new choiceMultipleItem());
            object_three.setOnTouchListener(new choiceMultipleItem());

        } else if ( post_scene_2[0] <=max - 3){

            object_one.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0]]);
            object_two.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] + 1]);
            object_three.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] + 2]);
             Handler delay_one = new Handler();
            areadDroped.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
            areaDropJapan.setText(JAPAN_TEXT_SCENE_ONE[post_scene_2[0]]);
            delay_one.postDelayed(new Runnable() {
                @Override
                public void run() {
                    areadDroped.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                }
            },2000);

            Handler delay_two = new Handler();
            delay_two.postDelayed(new Runnable() {
                @Override
                public void run() {
                    object_one.setEnabled(true);
                    areadDroped.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                }
            },3000);
            String FIRST_OBJECT_TAG = ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]];
            String TWO_OBJECT_TAG = ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 1];
            String THREE_OBJECT_TAG = ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 2];

            object_one.setTag(FIRST_OBJECT_TAG);
            object_two.setTag(TWO_OBJECT_TAG);
            object_three.setTag(THREE_OBJECT_TAG);
            object_one.setOnTouchListener(new choiceMultipleItem());
            object_two.setOnTouchListener(new choiceMultipleItem());
            object_three.setOnTouchListener(new choiceMultipleItem());

        }

        areadDroped.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()){
                    case DragEvent.ACTION_DRAG_STARTED:
                        View viewObjectS = (View) event.getLocalState();
                        ImageView IMAGE_OBJECTS = (ImageView) viewObjectS;
                        String getTAG = (String)IMAGE_OBJECTS.getTag();
                        textToSpech.speak(getTAG, TextToSpeech.QUEUE_FLUSH,null);
                        click_item.start();
                        if(!click_item.isPlaying()) {
                            click_item.start();
                        } else{
                            click_item.pause();
                        }
                         case DragEvent.ACTION_DRAG_ENDED:
                        View viewObject = (View) event.getLocalState();
                        ImageView IMAGE_OBJECT = (ImageView) viewObject;
                        TextView dropAREA_TEXT = (TextView) v;
                        String TAG_OBJECT = (String) IMAGE_OBJECT.getTag();
                        String MATCH_ROMAJING_DROPTEXT = ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]];
                        String TAG_AREA = (String) MATCH_ROMAJING_DROPTEXT;
                        if(event.getResult()){
                            if(!answer_true.isPlaying()){
                                answer_true.start();
                            } else {
                                answer_true.pause();
                            }
                            object_one.setEnabled(false);
                            Handler enableObject = new Handler();
                            enableObject.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    object_one.setEnabled(true);
                                }
                            },4000L);
                            if(TAG_OBJECT != TAG_AREA){
                                answerWrongs.setVisibility(View.VISIBLE);
                                answerWrongs.playAnimation();
                                Handler stop = new Handler();
                                stop.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        Toast.makeText(getApplicationContext(), "TAG_OBJECT: " + TAG_OBJECT + "\nTAG_AREA:" + TAG_AREA,Toast.LENGTH_LONG).show();

                                        answerWrongs.setVisibility(View.INVISIBLE);
                                    }
                                },4000);

                            }
                            if(TAG_AREA == TAG_OBJECT){
                                object_one.setEnabled(true);
                                ObjectAnimator scale_verifiedX = ObjectAnimator.ofFloat(answerTrues, answerTrues.SCALE_X,1.2F);
                                ObjectAnimator scale_verifiedY = ObjectAnimator.ofFloat(answerTrues, answerTrues.SCALE_Y,1.2F);
                                scale_verifiedX.setInterpolator(new BounceInterpolator());
                                scale_verifiedY.setInterpolator(new BounceInterpolator());
                                scale_verifiedX.setDuration(2500L);
                                scale_verifiedY.setDuration(2500L);

                                scale_verifiedX.start();
                                scale_verifiedY.start();;
                                if(!answerTrues.isAnimating()){
                                    answerTrues.setVisibility(View.VISIBLE);
                                    answerTrues.playAnimation();

                                } else {
                                  answerTrues.pauseAnimation();
                                    answerTrues.setVisibility(View.INVISIBLE);
                                }



                                Handler scaletozeroAnswer = new Handler();
                                scaletozeroAnswer.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ObjectAnimator scale_verifiedDefault_X = ObjectAnimator.ofFloat(answerTrues,answerTrues.SCALE_X,0);
                                        ObjectAnimator scale_verifiedDefault_Y = ObjectAnimator.ofFloat(answerTrues,answerTrues.SCALE_Y,0);
                                        scale_verifiedDefault_X.setDuration(2000L);
                                        scale_verifiedDefault_Y.setDuration(2000L);
                                        scale_verifiedDefault_X.setInterpolator(new BounceInterpolator());
                                        scale_verifiedDefault_Y.setInterpolator(new BounceInterpolator());
                                        scale_verifiedDefault_X.start();
                                        scale_verifiedDefault_Y.start();
                                    }
                                },2000);


                            }
                            post_scene_2[0]++;
                            fadeOutImage_SCENE_TWO();
                            SharedPreferences.Editor  save_data = SAVE_DATA_TWO.edit();
                            save_data.putInt("POSITION_SCENE_TWOS",post_scene_2[0]);
                            save_data.commit();
                            int max = IMAGE_FROM_SCENE_ONE.length - 3;
                            int min = IMAGE_FROM_SCENE_ONE.length - max;
                            if(post_scene_2[0] == IMAGE_FROM_SCENE_ONE.length){
                                post_scene_2[0] = 0;
                                SharedPreferences.Editor CLEAR_POST = SAVE_DATA_TWO.edit();
                                CLEAR_POST.clear();
                                CLEAR_POST.commit();
                            } else {
                                if (post_scene_2[0] >= max) {

                                    object_one.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0]]);
                                    object_two.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] - 1]);
                                    object_three.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] - 2]);
                                    Handler delay_one = new Handler();
                                    dropAREA_TEXT.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                                    areaDropJapan.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                                    delay_one.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            dropAREA_TEXT.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                                        }
                                    },3000);

//                                    Handler delay_two = new Handler();
//                                    delay_two.postDelayed(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            dropAREA_TEXT.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
//                                        }
//                                    },6000);

                                    //setTAg
                                    object_one.setTag(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                                    object_two.setTag(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 1]);
                                    object_three.setTag(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] - 2]);
                                } else if (post_scene_2[0] <= max) {
                                    object_one.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0]]);
                                    object_two.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] + 1]);
                                    object_three.setImageResource(IMAGE_FROM_SCENE_ONE[post_scene_2[0] + 2]);
                                    areaDropJapan.setText(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                                    dropAREA_TEXT.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                                    //setTag

                                    Handler delay_one = new Handler();
                                    delay_one.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            dropAREA_TEXT.setText(ENGLISH_TEXT_SCENE_ONE[post_scene_2[0]]);
                                        }
                                    },3000);


                                    object_one.setTag(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0]]);
                                    object_two.setTag(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 1]);
                                    object_three.setTag(ROMAJI_TEXT_SCENE_ONE[post_scene_2[0] + 2]);

                                }
                                if (post_scene_2[0] % 2 == 0) {
                                    Intent MOVE_SCENE_ONE = new Intent(SceneDrag_Two.this, SceneDrag_One.class);
                                    MOVE_SCENE_ONE.putExtra("currentImage", IMAGE_FROM_SCENE_ONE);
                                    MOVE_SCENE_ONE.putExtra("currentTittle", ENGLISH_TEXT_SCENE_ONE);
                                    MOVE_SCENE_ONE.putExtra("currentAlphabet", JAPAN_TEXT_SCENE_ONE);
                                    MOVE_SCENE_ONE.putExtra("currentNonAlphabet", ROMAJI_TEXT_SCENE_ONE);
                                    MOVE_SCENE_ONE.putExtra("Level", dataLevel);
                                    startActivity(MOVE_SCENE_ONE);
                                }
                            }
                        } else{

                            ObjectAnimator scale_verifiedFalseX = ObjectAnimator.ofFloat(answerWrongs, answerWrongs.SCALE_X,2.0F);
                            ObjectAnimator scale_verifiedFalseY = ObjectAnimator.ofFloat(answerWrongs, answerWrongs.SCALE_Y,2.0F);
                            scale_verifiedFalseX.setInterpolator(new BounceInterpolator());
                            scale_verifiedFalseY.setInterpolator(new BounceInterpolator());
                            scale_verifiedFalseX.setDuration(100L);
                            scale_verifiedFalseY.setDuration(100L);
                            unclick_item.start();
                            if(!unclick_item.isPlaying()){
                                unclick_item.start();
                            } else{
                                unclick_item.pause();
                            }
                        }
                        break;
                }
                return true;
            }
        });

    }
    public void fadeOutImage_SCENE_TWO(){
        ObjectAnimator image_oneFadeOut = ObjectAnimator.ofFloat(object_one,object_one.ALPHA,0);
        ObjectAnimator image_twoFadeOut = ObjectAnimator.ofFloat(object_two,object_two.ALPHA,0);
        ObjectAnimator image_threeFadeOut = ObjectAnimator.ofFloat(object_three,object_three.ALPHA,0);
        //set duration & interpolation
        image_oneFadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        image_twoFadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        image_threeFadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());

        ObjectAnimator textOne_FadeOut = ObjectAnimator.ofFloat(text_one,text_one.ALPHA,0);
        ObjectAnimator textTwo_FadeOut = ObjectAnimator.ofFloat(text_two,text_two.ALPHA,0);
        ObjectAnimator textThree_FadeOut = ObjectAnimator.ofFloat(text_three,text_three.ALPHA,0);

        ObjectAnimator drop_fadeOut = ObjectAnimator.ofFloat(areadDroped,areadDroped.ALPHA,0);
        drop_fadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        drop_fadeOut.start();

        ObjectAnimator dropJapan_fadeOut = ObjectAnimator.ofFloat(areaDropJapan,areaDropJapan.ALPHA,0);
        dropJapan_fadeOut.setDuration(3000L);
        dropJapan_fadeOut.setInterpolator(new LinearInterpolator());
        dropJapan_fadeOut.start();
        textOne_FadeOut.setDuration(3000L).setInterpolator(new LinearInterpolator());
        textTwo_FadeOut.setDuration(3000L).setInterpolator(new LinearInterpolator());
        textThree_FadeOut.setDuration(3000L).setInterpolator(new LinearInterpolator());

        image_oneFadeOut.start();
        image_twoFadeOut.start();
        image_threeFadeOut.start();
        Handler delayFadeIn = new Handler();
        delayFadeIn.postDelayed(new Runnable() {
            @Override
            public void run() {

                fadeInImage_SCENE_TWO();
            }
        },4000);

    }
    public void fadeInImage_SCENE_TWO(){
        ObjectAnimator image_oneFadeOut = ObjectAnimator.ofFloat(object_one,object_one.ALPHA,1);
        ObjectAnimator image_twoFadeOut = ObjectAnimator.ofFloat(object_two,object_two.ALPHA,1);
        ObjectAnimator image_threeFadeOut = ObjectAnimator.ofFloat(object_three,object_three.ALPHA,1);
        //set duration & interpolation
        image_oneFadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        image_twoFadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        image_threeFadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());

        ObjectAnimator drop_fadeOut = ObjectAnimator.ofFloat(areadDroped,areadDroped.ALPHA,1);
        drop_fadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        drop_fadeOut.start();

        ObjectAnimator dropJapan_fadeOut = ObjectAnimator.ofFloat(areaDropJapan,areaDropJapan.ALPHA,1);
        dropJapan_fadeOut.setDuration(3000L);
        dropJapan_fadeOut.setInterpolator(new LinearInterpolator());
        dropJapan_fadeOut.start();

        ObjectAnimator textOne_FadeOut = ObjectAnimator.ofFloat(text_one,text_one.ALPHA,1);
        ObjectAnimator textTwo_FadeOut = ObjectAnimator.ofFloat(text_two,text_two.ALPHA,1);
        ObjectAnimator textThree_FadeOut = ObjectAnimator.ofFloat(text_three,text_three.ALPHA,1);

        textOne_FadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        textTwo_FadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());
        textThree_FadeOut.setDuration(1000L).setInterpolator(new LinearInterpolator());


        image_oneFadeOut.start();
        image_twoFadeOut.start();
        image_threeFadeOut.start();

    }
    class dropAreaListener implements View.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()){
                case DragEvent.ACTION_DRAG_ENDED:
                    if(event.getResult()){
                        //do something
                        Toast.makeText(getApplicationContext(),"Drop Succes" ,Toast.LENGTH_SHORT).show();
                    } else{
                        //do something
                        Toast.makeText(getApplicationContext(),"Drop Failed" , Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            return true;
        }
    }

     class choiceMultipleItem implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == event.ACTION_DOWN) {
                ClipData clipData = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowbuilder = new View.DragShadowBuilder(v);
                v.startDrag(clipData, shadowbuilder, v, 0);
            } else {
                return true;
            }
            return false;
        }
    }


}