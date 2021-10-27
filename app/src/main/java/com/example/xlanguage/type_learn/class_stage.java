package com.example.xlanguage.type_learn;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.xlanguage.R;

public class class_stage {
    String ENGLISH_FIELD_ONE[];
    String JAPANESE_FIELD_TWO[];
    String ROMAJI_FIELD_THREE[];
//    String ENGLIH_FIELD_FOUR[];
//    String JAPANESE_FIELD_FIVE[];
//    String ROMAJI_FIELD_SEVEN[];
    int IMAGE_LIST_FIELD[];
    int POSITION;
    TextView ENGLISH_TEXT_VIEW_ONE , JAPAN_TEXT_VIEW_ONE, ROMAJI_TEXT_VIEW_ONE;
    ImageView IMAGE_VIEW_STAGE;
    TextView ENGLISH_TEXT_VIEW_SECOND , JAPAN_TEXT_VIEW_SECOND , ROMAJI_TEXT_VIEW_SECOND;
    Context apps;
    LinearLayout BOX_ONE , BOX_TWO;
    LottieAnimationView VERIFIED_ANSWER,FAILED_ANSWER;
    String pref_name , post_sceneone;
    int postONE[];
    Intent Intent_Main;
    public class_stage(String ENGLISH_DATA[] , String JAPAN_DATA[] , String ROMAJI_DATA[] , int IMAGE_LIST[] , int POSITION
            , TextView ENGLISH_TEXT_VIEW_ONE_ID, TextView JAPAN_TEXT_VIEW_ONE_ID, TextView ROMAJI_TEXT_VIEW_ONE_ID , ImageView IMAGE_LIST_VIEW_ID
            , TextView ENGLISH_TEXT_VIEW_SECOND_ID , TextView JAPAN_TEXT_VIEW_SECOND_ID, TextView ROMAJI_TEXT_VIEW_SECOND_ID,
                       Context apps,LottieAnimationView verified_succes, LottieAnimationView verified_failed, String pref_name,String post_sceneone,int postONE[]
            ,Intent intent_Main
    ){
        this.ENGLISH_FIELD_ONE = ENGLISH_DATA;
        this.JAPANESE_FIELD_TWO = JAPAN_DATA;
        this.ROMAJI_FIELD_THREE = ROMAJI_DATA;
        this.IMAGE_LIST_FIELD = IMAGE_LIST;
        this.POSITION = POSITION;
        //VIEW ONE
        this.ENGLISH_TEXT_VIEW_ONE = ENGLISH_TEXT_VIEW_ONE_ID;
        this.JAPAN_TEXT_VIEW_ONE = JAPAN_TEXT_VIEW_ONE_ID;
        this.ROMAJI_TEXT_VIEW_ONE  = ROMAJI_TEXT_VIEW_ONE_ID;
        //IMAGE VIEW
        this.IMAGE_VIEW_STAGE = IMAGE_LIST_VIEW_ID;
        //VIEW TWO
        this.ENGLISH_TEXT_VIEW_SECOND = ENGLISH_TEXT_VIEW_SECOND_ID;
        this.JAPAN_TEXT_VIEW_SECOND = JAPAN_TEXT_VIEW_SECOND_ID;
        this.ROMAJI_TEXT_VIEW_SECOND = ROMAJI_TEXT_VIEW_SECOND_ID;
        this.apps = apps;
        this.VERIFIED_ANSWER = verified_succes;
        this.FAILED_ANSWER = verified_failed;
        this.pref_name = pref_name;
        this.post_sceneone = post_sceneone;
        this.Intent_Main = intent_Main;
    }
    public class_stage(String ENGLISH_DATA[] , String JAPAN_DATA[] , String ROMAJI_DATA[] , int IMAGE_LIST[] , int POSITION
        , TextView ENGLISH_TEXT_VIEW_ONE_ID, TextView JAPAN_TEXT_VIEW_ONE_ID, TextView ROMAJI_TEXT_VIEW_ONE_ID , ImageView IMAGE_LIST_VIEW_ID
        , TextView ENGLISH_TEXT_VIEW_SECOND_ID , TextView JAPAN_TEXT_VIEW_SECOND_ID, TextView ROMAJI_TEXT_VIEW_SECOND_ID,
                       Context apps
    ){
        this.ENGLISH_FIELD_ONE = ENGLISH_DATA;
        this.JAPANESE_FIELD_TWO = JAPAN_DATA;
        this.ROMAJI_FIELD_THREE = ROMAJI_DATA;
        this.IMAGE_LIST_FIELD = IMAGE_LIST;
        this.POSITION = POSITION;
        //VIEW ONE
        this.ENGLISH_TEXT_VIEW_ONE = ENGLISH_TEXT_VIEW_ONE_ID;
        this.JAPAN_TEXT_VIEW_ONE = JAPAN_TEXT_VIEW_ONE_ID;
        this.ROMAJI_TEXT_VIEW_ONE  = ROMAJI_TEXT_VIEW_ONE_ID;
        //IMAGE VIEW
        this.IMAGE_VIEW_STAGE = IMAGE_LIST_VIEW_ID;
        //VIEW TWO
        this.ENGLISH_TEXT_VIEW_SECOND = ENGLISH_TEXT_VIEW_SECOND_ID;
        this.JAPAN_TEXT_VIEW_SECOND = JAPAN_TEXT_VIEW_SECOND_ID;
        this.ROMAJI_TEXT_VIEW_SECOND = ROMAJI_TEXT_VIEW_SECOND_ID;
        this.apps = apps;
    }
    public class_stage(String ENGLISH_DATA[] , String JAPAN_DATA[] , String ROMAJI_DATA[] , int IMAGE_LIST[] , int POSITION
            , TextView ENGLISH_TEXT_VIEW_ONE_ID, TextView JAPAN_TEXT_VIEW_ONE_ID, TextView ROMAJI_TEXT_VIEW_ONE_ID , ImageView IMAGE_LIST_VIEW_ID
            , TextView ENGLISH_TEXT_VIEW_SECOND_ID , TextView JAPAN_TEXT_VIEW_SECOND_ID, TextView ROMAJI_TEXT_VIEW_SECOND_ID,
                       Context apps,LinearLayout BOX_ONE , LinearLayout BOX_TWO
    ){
        this.ENGLISH_FIELD_ONE = ENGLISH_DATA;
        this.JAPANESE_FIELD_TWO = JAPAN_DATA;
        this.ROMAJI_FIELD_THREE = ROMAJI_DATA;
        this.IMAGE_LIST_FIELD = IMAGE_LIST;
        this.POSITION = POSITION;
        //VIEW ONE
        this.ENGLISH_TEXT_VIEW_ONE = ENGLISH_TEXT_VIEW_ONE_ID;
        this.JAPAN_TEXT_VIEW_ONE = JAPAN_TEXT_VIEW_ONE_ID;
        this.ROMAJI_TEXT_VIEW_ONE  = ROMAJI_TEXT_VIEW_ONE_ID;
        //IMAGE VIEW
        this.IMAGE_VIEW_STAGE = IMAGE_LIST_VIEW_ID;
        //VIEW TWO
        this.ENGLISH_TEXT_VIEW_SECOND = ENGLISH_TEXT_VIEW_SECOND_ID;
        this.JAPAN_TEXT_VIEW_SECOND = JAPAN_TEXT_VIEW_SECOND_ID;
        this.ROMAJI_TEXT_VIEW_SECOND = ROMAJI_TEXT_VIEW_SECOND_ID;
        this.apps = apps;
        this.BOX_ONE = BOX_ONE;
        this.BOX_TWO = BOX_TWO;
    }


    public void createLayourStageNew(){

        MediaPlayer click_item = MediaPlayer.create(apps, R.raw.select_clik);
        MediaPlayer unclick_item = MediaPlayer.create(apps,R.raw.click_error);
        MediaPlayer answer_true = MediaPlayer.create(apps,R.raw.notif_cli);
        SharedPreferences level_pref = apps.getSharedPreferences("LEVEL_POSISITION",Context.MODE_PRIVATE);
        final int[] positions = {level_pref.getInt("LEVEL_POSISITION",0)};
        SharedPreferences.Editor save_positions = level_pref.edit();
        if(positions[0] >= IMAGE_LIST_FIELD.length){
            save_positions.clear();
            save_positions.commit();
        }


        String ENGLISH_FIELD = ENGLISH_FIELD_ONE[positions[0]];
        String JAPAN_FIELD = JAPANESE_FIELD_TWO[positions[0]];
        String ROMAJI_FIELD = ROMAJI_FIELD_THREE[positions[0]];
            TextView TITTLE_ENGLISH_ONE = (TextView) ENGLISH_TEXT_VIEW_ONE;
            TextView TITTLE_ENGLISH_TWO = (TextView) ENGLISH_TEXT_VIEW_SECOND;
            TextView JAPANE_TEXT_VIEW_ONE = (TextView) JAPAN_TEXT_VIEW_ONE;
            TextView JAPANE_TEXT_VIEW_SECOND = (TextView) JAPAN_TEXT_VIEW_SECOND;
        TextView ROMAJI_VIEW_ONE = (TextView) ROMAJI_TEXT_VIEW_ONE;
        TextView ROMAJI_VIEW_TWO = (TextView) ROMAJI_TEXT_VIEW_SECOND;
        ImageView IMAGE_AREA = IMAGE_VIEW_STAGE;
        int maxLen = IMAGE_LIST_FIELD.length;
        ROMAJI_VIEW_ONE.setTag(ROMAJI_FIELD_THREE[positions[0]]);
       if(positions[0] >= maxLen){
            TITTLE_ENGLISH_ONE.setText(ENGLISH_FIELD_ONE[positions[0]]);
            ROMAJI_VIEW_ONE.setText(ROMAJI_FIELD_THREE[positions[0]]);
            JAPANE_TEXT_VIEW_ONE.setText(JAPANESE_FIELD_TWO[positions[0]]);
            //view bottom
            TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0] - 1]);
            ROMAJI_VIEW_TWO.setText(ROMAJI_FIELD_THREE[positions[0] - 1]);
            JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0] - 1]);
            IMAGE_AREA.setImageResource(IMAGE_LIST_FIELD[positions[0]]);
        } else{
            TITTLE_ENGLISH_ONE.setText(ENGLISH_FIELD_ONE[positions[0]]);
            ROMAJI_VIEW_ONE.setText(ROMAJI_FIELD_THREE[positions[0]]);
            JAPANE_TEXT_VIEW_ONE.setText(JAPANESE_FIELD_TWO[positions[0]]);
            //view bottom
            TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0] + 1]);
            ROMAJI_VIEW_TWO.setText(ROMAJI_FIELD_THREE[positions[0] + 1]);
            JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0] + 1]);
            IMAGE_AREA.setImageResource(IMAGE_LIST_FIELD[positions[0]]);
       }

        //view top

        ROMAJI_VIEW_ONE.setOnTouchListener(new multiChoiceListener());
        ROMAJI_VIEW_TWO.setOnTouchListener(new multiChoiceListener());
        IMAGE_AREA.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int getActions = event.getAction();
                switch (getActions){
                    case DragEvent.ACTION_DRAG_STARTED:
                        if(!click_item.isPlaying()){
                            click_item.start();
                        }else{
                            click_item.pause();
                        }
                    case DragEvent.ACTION_DRAG_ENDED:
                        View localStates = (View) event.getLocalState();
                        TextView tags_Object = (TextView) localStates;
                        String tags_fromOBj = (String) tags_Object.getTag();
                        String MATCH_ROMAJING_DROPTEXT = ROMAJI_FIELD_THREE[positions[0]];
                        String tags_fromIMg = MATCH_ROMAJING_DROPTEXT;
                            Toast.makeText(apps,"same: " + tags_fromOBj, Toast.LENGTH_SHORT).show();
                            Toast.makeText(apps, "same: " + tags_fromIMg, Toast.LENGTH_SHORT).show();
                        if(event.getResult()){
                            if(positions[0] >= ROMAJI_FIELD.length()){
                                positions[0] = 0;
                             }
                            positions[0]++;
                            if(tags_fromOBj == tags_fromIMg){
                                if(positions[0] % 3 == 0){
                                        save_positions.commit();


                                    Intent_Main.putExtra("namePrefe",pref_name);
                                    Intent_Main.putExtra("currentImage",IMAGE_LIST_FIELD);
                                    Intent_Main.putExtra("currentTittle",ENGLISH_FIELD_ONE);
                                    Intent_Main.putExtra("currentAlphabet",JAPANESE_FIELD_TWO);
                                    Intent_Main.putExtra("currentRomaji",ROMAJI_FIELD_THREE);



                                    apps.startActivity(Intent_Main);


                                }
                                if(!answer_true.isPlaying()){
                                    answer_true.start();
                                } else{
                                    answer_true.pause();
                                }
                                //animation
                                ObjectAnimator romaji_one = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_ONE,ROMAJI_TEXT_VIEW_ONE.ALPHA,0F);
                                romaji_one.setInterpolator(new LinearInterpolator());
                                romaji_one.setDuration(2000L);
                                romaji_one.start();
                                ObjectAnimator romaji_two = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_SECOND, ROMAJI_TEXT_VIEW_SECOND.ALPHA,0F);
                                romaji_two.setDuration(2000L);
                                romaji_two.setInterpolator(new LinearInterpolator());
                                romaji_two.start();
                                //view english
                                ObjectAnimator english_view_one = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_ONE, ENGLISH_TEXT_VIEW_ONE.ALPHA,0F);
                                english_view_one.setDuration(2000L);
                                english_view_one.setInterpolator(new LinearInterpolator());
                                english_view_one.start();

                                ObjectAnimator english_view_two = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_SECOND, ENGLISH_TEXT_VIEW_SECOND.ALPHA,0F);
                                english_view_two.setDuration(2000L);
                                english_view_two.setInterpolator(new LinearInterpolator());
                                english_view_two.start();

                                //JAPAN
                                ObjectAnimator japan_viewone = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_ONE,JAPANE_TEXT_VIEW_ONE.ALPHA,0F);
                                japan_viewone.setDuration(2000L);
                                japan_viewone.setInterpolator(new LinearInterpolator());
                                japan_viewone.start();


                                ObjectAnimator japan_viewtwo = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_SECOND,JAPANE_TEXT_VIEW_SECOND.ALPHA,0F);
                                japan_viewtwo.setDuration(2000L);
                                japan_viewtwo.setInterpolator(new LinearInterpolator());
                                japan_viewtwo.start();




                                //Image
                                ObjectAnimator image_obj = ObjectAnimator.ofFloat(IMAGE_AREA,IMAGE_AREA.ALPHA,0F);
                                image_obj.setInterpolator(new LinearInterpolator());
                                image_obj.setDuration(2000L);
                                image_obj.start();

                                VERIFIED_ANSWER.playAnimation();
                                VERIFIED_ANSWER.setVisibility(View.VISIBLE);

                                VERIFIED_ANSWER.addAnimatorListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {
                                        VERIFIED_ANSWER.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                    VERIFIED_ANSWER.pauseAnimation();
                                    VERIFIED_ANSWER.setVisibility(View.INVISIBLE);
                                        //romaji
                                        ObjectAnimator romaji_one = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_ONE,ROMAJI_TEXT_VIEW_ONE.ALPHA,1F);
                                        romaji_one.setInterpolator(new LinearInterpolator());
                                        romaji_one.setDuration(2000L);
                                        romaji_one.start();
                                        ObjectAnimator romaji_two = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_SECOND, ROMAJI_TEXT_VIEW_SECOND.ALPHA, 1F);
                                        romaji_two.setInterpolator( new LinearInterpolator());
                                        romaji_two.setDuration(2000L);
                                        romaji_two.start();

                                        //view english
                                        ObjectAnimator english_view_one = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_ONE, ENGLISH_TEXT_VIEW_ONE.ALPHA,1F);
                                        english_view_one.setDuration(2000L);
                                        english_view_one.setInterpolator(new LinearInterpolator());
                                        english_view_one.start();

                                        ObjectAnimator english_view_two = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_SECOND, ENGLISH_TEXT_VIEW_SECOND.ALPHA,1F);
                                        english_view_two.setDuration(2000L);
                                        english_view_two.setInterpolator(new LinearInterpolator());
                                        english_view_two.start();

                                        //JAPAN
                                        ObjectAnimator japan_viewone = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_ONE,JAPANE_TEXT_VIEW_ONE.ALPHA,1F);
                                        japan_viewone.setDuration(2000L);
                                        japan_viewone.setInterpolator(new LinearInterpolator());
                                        japan_viewone.start();


                                        ObjectAnimator japan_viewtwo = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_SECOND,JAPANE_TEXT_VIEW_SECOND.ALPHA,1F);
                                        japan_viewtwo.setDuration(2000L);
                                        japan_viewtwo.setInterpolator(new LinearInterpolator());
                                        japan_viewtwo.start();
                                        
                                        //Image
                                        ObjectAnimator image_obj = ObjectAnimator.ofFloat(IMAGE_AREA,IMAGE_AREA.ALPHA,1F);
                                        image_obj.setInterpolator(new LinearInterpolator());
                                        image_obj.setDuration(2000L);
                                        image_obj.start();
                                    }
                            
                                    @Override
                                    public void onAnimationCancel(Animator animation) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {

                                    }
                                });
                            } else{
                                //failed answer
                                if(!unclick_item.isPlaying()){
                                    unclick_item.start();
                                } else{
                                    unclick_item.pause();
                                }
                                FAILED_ANSWER.playAnimation();
                                FAILED_ANSWER.setVisibility(View.VISIBLE);
                                ObjectAnimator romaji_one = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_ONE,ROMAJI_TEXT_VIEW_ONE.ALPHA,0F);
                                romaji_one.setInterpolator(new LinearInterpolator());
                                romaji_one.setDuration(2000L);
                                romaji_one.start();
                                ObjectAnimator romaji_two = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_SECOND, ROMAJI_TEXT_VIEW_SECOND.ALPHA,0F);
                                romaji_two.setDuration(2000L);
                                romaji_two.setInterpolator(new LinearInterpolator());
                                romaji_two.start();
                                //view english
                                ObjectAnimator english_view_one = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_ONE, ENGLISH_TEXT_VIEW_ONE.ALPHA,0F);
                                english_view_one.setDuration(2000L);
                                english_view_one.setInterpolator(new LinearInterpolator());
                                english_view_one.start();

                                ObjectAnimator english_view_two = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_SECOND, ENGLISH_TEXT_VIEW_SECOND.ALPHA,0F);
                                english_view_two.setDuration(2000L);
                                english_view_two.setInterpolator(new LinearInterpolator());
                                english_view_two.start();

                                //JAPAN
                                ObjectAnimator japan_viewone = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_ONE,JAPANE_TEXT_VIEW_ONE.ALPHA,0F);
                                japan_viewone.setDuration(2000L);
                                japan_viewone.setInterpolator(new LinearInterpolator());
                                japan_viewone.start();


                                ObjectAnimator japan_viewtwo = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_ONE,JAPANE_TEXT_VIEW_ONE.ALPHA,0F);
                                japan_viewtwo.setDuration(2000L);
                                japan_viewtwo.setInterpolator(new LinearInterpolator());
                                japan_viewtwo.start();




                                //Image
                                ObjectAnimator image_obj = ObjectAnimator.ofFloat(IMAGE_AREA,IMAGE_AREA.ALPHA,0F);
                                image_obj.setInterpolator(new LinearInterpolator());
                                image_obj.setDuration(2000L);
                                image_obj.start();
                                FAILED_ANSWER.addAnimatorListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {
                                        FAILED_ANSWER.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                    FAILED_ANSWER.pauseAnimation();
                                    FAILED_ANSWER.setVisibility(View.INVISIBLE);
                                        ObjectAnimator romaji_one = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_ONE,ROMAJI_TEXT_VIEW_ONE.ALPHA,1F);
                                        romaji_one.setInterpolator(new LinearInterpolator());
                                        romaji_one.setDuration(2000L);
                                        romaji_one.start();
                                        ObjectAnimator romaji_two = ObjectAnimator.ofFloat(ROMAJI_TEXT_VIEW_SECOND, ROMAJI_TEXT_VIEW_SECOND.ALPHA, 1F);
                                        romaji_two.setInterpolator( new LinearInterpolator());
                                        romaji_two.setDuration(2000L);
                                        romaji_two.start();

                                        //view english
                                        ObjectAnimator english_view_one = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_ONE, ENGLISH_TEXT_VIEW_ONE.ALPHA,1F);
                                        english_view_one.setDuration(2000L);
                                        english_view_one.setInterpolator(new LinearInterpolator());
                                        english_view_one.start();

                                        ObjectAnimator english_view_two = ObjectAnimator.ofFloat(ENGLISH_TEXT_VIEW_SECOND, ENGLISH_TEXT_VIEW_SECOND.ALPHA,1F);
                                        english_view_two.setDuration(2000L);
                                        english_view_two.setInterpolator(new LinearInterpolator());
                                        english_view_two.start();

                                        //JAPAN
                                        ObjectAnimator japan_viewone = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_ONE,JAPANE_TEXT_VIEW_ONE.ALPHA,1F);
                                        japan_viewone.setDuration(2000L);
                                        japan_viewone.setInterpolator(new LinearInterpolator());
                                        japan_viewone.start();


                                        ObjectAnimator japan_viewtwo = ObjectAnimator.ofFloat(JAPANE_TEXT_VIEW_SECOND,JAPANE_TEXT_VIEW_SECOND.ALPHA,1F);
                                        japan_viewtwo.setDuration(2000L);
                                        japan_viewtwo.setInterpolator(new LinearInterpolator());
                                        japan_viewtwo.start();

                                        //Image
                                        ObjectAnimator image_obj = ObjectAnimator.ofFloat(IMAGE_AREA,IMAGE_AREA.ALPHA,1F);
                                        image_obj.setInterpolator(new LinearInterpolator());
                                        image_obj.setDuration(2000L);
                                        image_obj.start();
                                    }

                                    @Override
                                    public void onAnimationCancel(Animator animation) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {

                                    }
                                });
                            }
                            //set Text and images

                            ROMAJI_VIEW_ONE.setTag(ROMAJI_FIELD_THREE[positions[0]]);
                            IMAGE_AREA.setTag(ROMAJI_FIELD_THREE[positions[0]]);
                            if(positions[0] >= maxLen){
                                TITTLE_ENGLISH_ONE.setText(ENGLISH_FIELD_ONE[positions[0]]);
                                ROMAJI_VIEW_ONE.setText(ROMAJI_FIELD_THREE[positions[0]]);
                                JAPANE_TEXT_VIEW_ONE.setText(JAPANESE_FIELD_TWO[positions[0]]);
                                //view bottom
                                TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0] - 1]);
                                ROMAJI_VIEW_TWO.setText(ROMAJI_FIELD_THREE[positions[0] - 1]);
                                JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0] - 1]);
                                IMAGE_AREA.setImageResource(IMAGE_LIST_FIELD[positions[0]]);
                            } else{
                                TITTLE_ENGLISH_ONE.setText(ENGLISH_FIELD_ONE[positions[0]]);
                                ROMAJI_VIEW_ONE.setText(ROMAJI_FIELD_THREE[positions[0]]);
                                JAPANE_TEXT_VIEW_ONE.setText(JAPANESE_FIELD_TWO[positions[0]]);
                                //view bottom
                                TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0] + 1]);
                                ROMAJI_VIEW_TWO.setText(ROMAJI_FIELD_THREE[positions[0] + 1]);
                                JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0] + 1]);
                                IMAGE_AREA.setImageResource(IMAGE_LIST_FIELD[positions[0]]);
                            }


                        } else{
                            Toast.makeText(apps,"Drop Failed Work !" , Toast.LENGTH_LONG).show();
                        }
                        break;
                }
                return true;
            }
        });
    }

    public void createLayoutStage(){
        final int[] positions = {0};
        String ENGLISH_FIELD = ENGLISH_FIELD_ONE[positions[0]];
        String JAPAN_FIELD = JAPANESE_FIELD_TWO[positions[0]];
        String ROMAJI_FIELD = ROMAJI_FIELD_THREE[positions[0]];
        TextView TITTLE_ENGLISH_ONE = (TextView) ENGLISH_TEXT_VIEW_ONE;
        TextView TITTLE_ENGLISH_TWO = (TextView) ENGLISH_TEXT_VIEW_SECOND;
        TextView JAPANE_TEXT_VIEW_ONE = (TextView) JAPAN_TEXT_VIEW_ONE;
        TextView JAPANE_TEXT_VIEW_SECOND = (TextView) JAPAN_TEXT_VIEW_SECOND;
        TextView ROMAJI_VIEW_ONE = (TextView) ROMAJI_TEXT_VIEW_ONE;
        TextView ROMAJI_VIEW_TWO = (TextView) ROMAJI_TEXT_VIEW_SECOND;
        ImageView IMAGE_AREA = IMAGE_VIEW_STAGE;
        int maxLen = IMAGE_LIST_FIELD.length;



        if(positions[0] >= maxLen){
            TITTLE_ENGLISH_ONE.setText(ENGLISH_FIELD_ONE[positions[0]]);
            JAPANE_TEXT_VIEW_ONE.setText(JAPANESE_FIELD_TWO[positions[0]]);
            ROMAJI_TEXT_VIEW_ONE.setText(ROMAJI_FIELD_THREE[positions[0]]);
            IMAGE_AREA.setImageResource(IMAGE_LIST_FIELD[positions[0]]);

            //setTAG OBJECT FIRST
            String TAG_ENGLISH_ONE = ENGLISH_FIELD_ONE[positions[0]];
            String TAG_JAPAN_ONE = JAPANESE_FIELD_TWO[positions[0]];
            String TAG_ROMAJI_ONE = ROMAJI_FIELD_THREE[positions[0]];
            String TAG_IMAGE_ONE = ROMAJI_FIELD_THREE[positions[0]];

            // set TAG
            TITTLE_ENGLISH_ONE.setTag( TAG_ENGLISH_ONE);
            JAPANE_TEXT_VIEW_ONE.setTag(TAG_JAPAN_ONE);
            ROMAJI_TEXT_VIEW_ONE.setTag(TAG_ROMAJI_ONE);
            IMAGE_AREA.setTag(TAG_IMAGE_ONE);
            String TAG_ENGLISH_TWO = ENGLISH_FIELD_ONE[positions[0]-1];
            String TAG_JAPAN_TWO = JAPANESE_FIELD_TWO[positions[0] -1];
            String TAG_ROMAJI_TWO = ROMAJI_FIELD_THREE[positions[0] -1];
            TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0] - 1]);
            JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0] -1 ]);
            ROMAJI_TEXT_VIEW_SECOND.setText(ROMAJI_FIELD_THREE[positions[0]- 1]);
            //set TAG
            TITTLE_ENGLISH_TWO.setTag(TAG_ENGLISH_TWO);
            JAPANE_TEXT_VIEW_SECOND.setTag(TAG_ROMAJI_TWO);
            ROMAJI_TEXT_VIEW_SECOND.setTag(TAG_ROMAJI_TWO);
        } else if (positions[0] <=maxLen){
            TITTLE_ENGLISH_ONE.setText(ENGLISH_FIELD_ONE[positions[0]]);
            JAPANE_TEXT_VIEW_ONE.setText(JAPANESE_FIELD_TWO[positions[0]]);
            ROMAJI_TEXT_VIEW_ONE.setText(ROMAJI_FIELD_THREE[positions[0]]);
            IMAGE_AREA.setImageResource(IMAGE_LIST_FIELD[positions[0]]);

            //setTAG OBJECT FIRST
            String TAG_ENGLISH_ONE = ENGLISH_FIELD_ONE[positions[0]];
            String TAG_JAPAN_ONE = JAPANESE_FIELD_TWO[positions[0]];
            String TAG_ROMAJI_ONE = ROMAJI_FIELD_THREE[positions[0]];
            String TAG_IMAGE_ONE = ROMAJI_FIELD_THREE[positions[0]];

            // set TAG
            TITTLE_ENGLISH_ONE.setTag( TAG_ENGLISH_ONE);
            JAPANE_TEXT_VIEW_ONE.setTag(TAG_JAPAN_ONE);
            ROMAJI_TEXT_VIEW_ONE.setTag(TAG_ROMAJI_ONE);
            IMAGE_AREA.setTag(TAG_IMAGE_ONE);

            String TAG_ENGLISH_TWO = ENGLISH_FIELD_ONE[positions[0]+1];
            String TAG_JAPAN_TWO = JAPANESE_FIELD_TWO[positions[0] +1];
            String TAG_ROMAJI_TWO = ROMAJI_FIELD_THREE[positions[0] +1];

            TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0] + 1]);
            JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0] + 1 ]);
            ROMAJI_TEXT_VIEW_SECOND.setText(ROMAJI_FIELD_THREE[positions[0] + 1]);
            //set TAG
            TITTLE_ENGLISH_ONE.setTag(TAG_ENGLISH_TWO);
            JAPANE_TEXT_VIEW_SECOND.setTag(TAG_JAPAN_TWO);
            ROMAJI_TEXT_VIEW_SECOND.setTag(TAG_ROMAJI_TWO);
            TITTLE_ENGLISH_ONE.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData clip_data =  ClipData.newPlainText("","");
                    View.DragShadowBuilder shadows = new View.DragShadowBuilder(v);
                    v.startDrag(clip_data,shadows,null,0);
                    return true;
                }
            });

            TITTLE_ENGLISH_TWO.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData clip_data =  ClipData.newPlainText("","");
                    View.DragShadowBuilder shdow = new View.DragShadowBuilder(v);
                    v.startDrag(clip_data,shdow,null,0);
                    return true;
                }
            });

            JAPANE_TEXT_VIEW_ONE.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData clip_data =  ClipData.newPlainText("","");
                    View.DragShadowBuilder shadows = new View.DragShadowBuilder(v);
                    v.startDrag(clip_data,shadows,null,0);
                    return true;
                }
            });

            JAPANE_TEXT_VIEW_SECOND.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData clipss_data =  ClipData.newPlainText("","");
                    View.DragShadowBuilder shdow = new View.DragShadowBuilder(v);
                    v.startDrag(clipss_data,shdow,null,0);
                    return true;
                }
            });
            ROMAJI_VIEW_ONE.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData clips_data =  ClipData.newPlainText("","");
                    View.DragShadowBuilder shdows = new View.DragShadowBuilder(v);
                    v.startDrag(clips_data,shdows,null,0);
                    return true;
                }
            });
            ROMAJI_VIEW_TWO.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData clips_data =  ClipData.newPlainText("","");
                    View.DragShadowBuilder sdow = new View.DragShadowBuilder(v);
                    v.startDrag(clips_data,sdow,null,0);
                    return true;
                }
            });

        }

        TITTLE_ENGLISH_ONE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
              ClipData clip_data =  ClipData.newPlainText("","");
              View.DragShadowBuilder shadows = new View.DragShadowBuilder(v);
              v.startDrag(clip_data,shadows,null,0);
                return true;
            }
        });

        TITTLE_ENGLISH_TWO.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData clip_data =  ClipData.newPlainText("","");
                View.DragShadowBuilder shdow = new View.DragShadowBuilder(v);
                v.startDrag(clip_data,shdow,null,0);
                return true;
            }
        });

        JAPANE_TEXT_VIEW_ONE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData clip_data =  ClipData.newPlainText("","");
                View.DragShadowBuilder shadows = new View.DragShadowBuilder(v);
                v.startDrag(clip_data,shadows,null,0);
                return true;
            }
        });

        JAPANE_TEXT_VIEW_SECOND.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               ClipData clipss_data =  ClipData.newPlainText("","");
               View.DragShadowBuilder shdow = new View.DragShadowBuilder(v);
               v.startDrag(clipss_data,shdow,null,0);
                return true;
            }
        });
        ROMAJI_VIEW_ONE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData clips_data =  ClipData.newPlainText("","");
                View.DragShadowBuilder shdows = new View.DragShadowBuilder(v);
                v.startDrag(clips_data,shdows,null,0);
                return true;
            }
        });
        ROMAJI_VIEW_TWO.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData clips_data =  ClipData.newPlainText("","");
                View.DragShadowBuilder sdow = new View.DragShadowBuilder(v);
                v.startDrag(clips_data,sdow,null,0);
                return true;
            }
        });

        IMAGE_AREA.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()){
                    case DragEvent.ACTION_DRAG_ENDED:
                        View getLocalState = (View)event.getLocalState();


                        TextView areaDropTag = (TextView) getLocalState;
                        String ITEM_OBJECT;
                        ImageView Drop_Text = (ImageView) v;
                        String getTAGDROP = (String) Drop_Text.getTag().toString();

                        if(getTAGDROP == ROMAJI_FIELD_THREE[positions[0]]){
                            Toast.makeText(apps,"DATA img TAG:" + getTAGDROP ,Toast.LENGTH_SHORT).show();
                            Toast.makeText(apps,"DATA img OBJ: " + getLocalState , Toast.LENGTH_SHORT).show();;
                        } else{
                            Toast.makeText(apps,"!DATA img TAG:" + getTAGDROP ,Toast.LENGTH_SHORT).show();
                            Toast.makeText(apps,"!DATA img OBJ: " + getLocalState , Toast.LENGTH_SHORT).show();;

                        }
                        if(event.getResult()){


                            positions[0]++;
                            Toast.makeText(apps,"drop succes",Toast.LENGTH_LONG).show();
                            if(positions[0] == IMAGE_LIST_FIELD.length){
                                positions[0] = 0;
                            } else{
                                //get MAX
                                int getMAX_LEN = ENGLISH_FIELD_ONE.length;
                                //default
                                TITTLE_ENGLISH_ONE.setText(ENGLISH_FIELD_ONE[positions[0]]);
                                JAPANE_TEXT_VIEW_ONE.setText(JAPANESE_FIELD_TWO[positions[0]]);
                                ROMAJI_TEXT_VIEW_ONE.setText(ROMAJI_FIELD_THREE[positions[0]]);
                                IMAGE_VIEW_STAGE.setImageResource(IMAGE_LIST_FIELD[positions[0]]);
                                //setTAG OBJECT FIRST
                                TITTLE_ENGLISH_ONE.setTag( ENGLISH_FIELD_ONE[positions[0]]);
                                JAPANE_TEXT_VIEW_ONE.setTag(JAPANESE_FIELD_TWO[positions[0]]);
                                ROMAJI_TEXT_VIEW_ONE.setTag(ROMAJI_FIELD_THREE[positions[0]]);
                                IMAGE_AREA.setTag(ROMAJI_FIELD_THREE[positions[0]]);
                                if(positions[0] >= getMAX_LEN){
                                    TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0] - 1]);
                                    JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0] -1]);
                                    ROMAJI_TEXT_VIEW_SECOND.setText(ROMAJI_FIELD_THREE[positions[0] -1]);
                                    //set TAG
                                    TITTLE_ENGLISH_TWO.setTag(ENGLISH_FIELD_ONE[positions[0] - 1]);
                                    JAPANE_TEXT_VIEW_SECOND.setTag(JAPANESE_FIELD_TWO[positions[0] - 1]);
                                    ROMAJI_TEXT_VIEW_SECOND.setTag(ROMAJI_FIELD_THREE[positions[0] - 1]);
                                } else{
                                    TITTLE_ENGLISH_TWO.setText(ENGLISH_FIELD_ONE[positions[0]] + 1);
                                    JAPANE_TEXT_VIEW_SECOND.setText(JAPANESE_FIELD_TWO[positions[0]] + 1);
                                    ROMAJI_TEXT_VIEW_SECOND.setText(ROMAJI_FIELD_THREE[positions[0]] + 1);
                                    //set TAG
                                    TITTLE_ENGLISH_ONE.setTag(ENGLISH_FIELD_ONE[positions[0] + 1]);
                                    JAPANE_TEXT_VIEW_SECOND.setTag(JAPANESE_FIELD_TWO[positions[0] + 1]);
                                    ROMAJI_TEXT_VIEW_SECOND.setTag(ROMAJI_FIELD_THREE[positions[0] + 1]);
                                }
                            }

                        } else{
                            Toast.makeText(apps,"drop_failed",Toast.LENGTH_SHORT).show();
                        }
                }
                return  true;
            }
        });
    }


     class multiChoiceListener implements View.OnTouchListener {
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
