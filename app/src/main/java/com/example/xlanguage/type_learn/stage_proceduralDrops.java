package com.example.xlanguage.type_learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xlanguage.R;

public class stage_proceduralDrops extends AppCompatActivity {
    ImageView proceduralDropImage;
    TextView ENGLISH_PROCEDURAL_ONE , ENGLISH_PROCEDURAL_TWO , ROMAJI_PROCEDURAL_ONE, ROMAJI_PROCEDURAL_TWO
            , JAPAN_PROCEDURAL_ONE , JAPAN_PROCEDURAL_TWO;
    SharedPreferences KEY_SHARED;

    Intent intentDrag_two;
    Bundle getDataFromIntent;
    ConstraintLayout TOP_ITEM , BOTTOM_ITEM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_procedural_drops);SCENE_ONE();

    }
    public void SCENE_ONE(){
        SharedPreferences SAVE_DATA_PROCEDURAL = getSharedPreferences("SAVE_POST_PROCEDURAL",MODE_PRIVATE);
        final int[] POSITION_IMAGE = {SAVE_DATA_PROCEDURAL.getInt("POSITION_PROCEDURAL", 0)};
      TOP_ITEM = findViewById(R.id.AREA_TOP);
        BOTTOM_ITEM = findViewById(R.id.AREA_BOTTOM);
        proceduralDropImage = findViewById(R.id.procedural_image);
        ENGLISH_PROCEDURAL_ONE = findViewById(R.id.ENGLISH_AREA_TOP_ONE);
        ENGLISH_PROCEDURAL_TWO = findViewById(R.id.ENGLISH_AREA_TOP_TWO);
        ROMAJI_PROCEDURAL_ONE = findViewById(R.id.ROMAJI_AREA_TOP_ONE);
        ROMAJI_PROCEDURAL_TWO = findViewById(R.id.ROMAJI_AREA_TOP_TWO);
        JAPAN_PROCEDURAL_ONE = findViewById(R.id.JAPANESE_AREA_TOP_ONE);
        JAPAN_PROCEDURAL_TWO = findViewById(R.id.JAPANESE_AREA_TOP_TWO);
        intentDrag_two = getIntent();
        getDataFromIntent = intentDrag_two.getExtras();
        int IMAGE_SCENE_ONE[] = getDataFromIntent.getIntArray("currentImage");
        String ENGLISH_TEXT[] = getDataFromIntent.getStringArray("currentTittle");
        String ROMAJI_TEXT[] = getDataFromIntent.getStringArray("currentAlphabet");
        String JAPAN_TEXT[]  = getDataFromIntent.getStringArray("currentNonAlphabet");
        //set to 0
        if(POSITION_IMAGE[0] == IMAGE_SCENE_ONE.length){
            POSITION_IMAGE[0] = 0;
        }

        TOP_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);
        BOTTOM_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);
        int max = IMAGE_SCENE_ONE.length;
        if(POSITION_IMAGE[0] >= max - 1) {


            TOP_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);
            BOTTOM_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0] -1]);

            TOP_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);
            BOTTOM_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);

            proceduralDropImage.setImageResource(IMAGE_SCENE_ONE[POSITION_IMAGE[0]]);
            //one
            ENGLISH_PROCEDURAL_ONE.setText(ENGLISH_TEXT[POSITION_IMAGE[0]]);
            ROMAJI_PROCEDURAL_ONE.setText(ROMAJI_TEXT[POSITION_IMAGE[0]]);
            JAPAN_PROCEDURAL_ONE.setText(JAPAN_TEXT[POSITION_IMAGE[0]]);

            //two
            ENGLISH_PROCEDURAL_TWO.setText(ENGLISH_TEXT[POSITION_IMAGE[0] - 1]);
            ROMAJI_PROCEDURAL_TWO.setText(ROMAJI_TEXT[POSITION_IMAGE[0] - 1]);
            JAPAN_PROCEDURAL_TWO.setText(JAPAN_TEXT[POSITION_IMAGE[0] - 1]);

        } else{

            TOP_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);
            BOTTOM_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0] +1]);
            proceduralDropImage.setImageResource(IMAGE_SCENE_ONE[POSITION_IMAGE[0]]);
            //one
            ENGLISH_PROCEDURAL_ONE.setText(ENGLISH_TEXT[POSITION_IMAGE[0]]);
            ROMAJI_PROCEDURAL_ONE.setText(ROMAJI_TEXT[POSITION_IMAGE[0]]);
            JAPAN_PROCEDURAL_ONE.setText(JAPAN_TEXT[POSITION_IMAGE[0]]);

            //two
            ENGLISH_PROCEDURAL_TWO.setText(ENGLISH_TEXT[POSITION_IMAGE[0] +1]);
            ROMAJI_PROCEDURAL_TWO.setText(ROMAJI_TEXT[POSITION_IMAGE[0] +1]);
            JAPAN_PROCEDURAL_TWO.setText(JAPAN_TEXT[POSITION_IMAGE[0] +1]);
        }

        TOP_ITEM.setOnTouchListener(new ITEM_CHOSE());
        BOTTOM_ITEM.setOnTouchListener(new ITEM_CHOSE());
        proceduralDropImage.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int getAction = event.getAction();
                switch (getAction){
                    case DragEvent.ACTION_DRAG_STARTED:
                        Toast.makeText(getApplicationContext(),"ACTION START",Toast.LENGTH_SHORT).show();
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        if(POSITION_IMAGE[0] == max){
                            POSITION_IMAGE[0] = 0;
                        }
                        View IMAGE_DROPED = (View) event.getLocalState();
                        String getTAG_ITEMDROPED = (String) IMAGE_DROPED.getTag();
                        if(event.getResult()){
                            //true

                            if(POSITION_IMAGE[0] >= max - 1){
                                POSITION_IMAGE[0] = 0;
                                if(getTAG_ITEMDROPED == ROMAJI_TEXT[POSITION_IMAGE[0]]){
                                    Toast.makeText(getApplicationContext(),"TRUE",Toast.LENGTH_SHORT).show();
                                } else{
                                    Toast.makeText(getApplicationContext(),"FALSE",Toast.LENGTH_SHORT).show();
                                }
                            } else{

                                if(getTAG_ITEMDROPED == ROMAJI_TEXT[POSITION_IMAGE[0]]){
                                    Toast.makeText(getApplicationContext(),"TRUE",Toast.LENGTH_SHORT).show();
                                } else{
                                    Toast.makeText(getApplicationContext(),"FALSE",Toast.LENGTH_SHORT).show();
                                }
                            }
                            Toast.makeText(getApplicationContext(),"DROP SUCCES",Toast.LENGTH_SHORT).show();
                            POSITION_IMAGE[0]++;
                            SharedPreferences.Editor edit_save = SAVE_DATA_PROCEDURAL.edit();
                            edit_save.putInt("POSITION_PROCEDURAL", POSITION_IMAGE[0]);
                            edit_save.commit();
                            if(POSITION_IMAGE[0] == max){
                                POSITION_IMAGE[0] = 0;

                            } else{
                                if(POSITION_IMAGE[0] % 2 == 0){
                                    Intent CHANGE_ACTIVITY = new Intent(stage_proceduralDrops.this, SceneDrag_Two.class);
                                    CHANGE_ACTIVITY.putExtra("currentImage",IMAGE_SCENE_ONE);
                                    CHANGE_ACTIVITY.putExtra("currentTittle",ENGLISH_TEXT);
                                    CHANGE_ACTIVITY.putExtra("currentAlphabet",JAPAN_TEXT);
                                    CHANGE_ACTIVITY.putExtra("currentNonAlphabet",ROMAJI_TEXT);
                                    startActivity(CHANGE_ACTIVITY);
                                }
                                if(POSITION_IMAGE[0] >= max - 1) {
                                    proceduralDropImage.setImageResource(IMAGE_SCENE_ONE[POSITION_IMAGE[0]]);
                                    //one

                                    TOP_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);
                                    BOTTOM_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0] - 1]);
                                    ENGLISH_PROCEDURAL_ONE.setText(ENGLISH_TEXT[POSITION_IMAGE[0]]);
                                    ROMAJI_PROCEDURAL_ONE.setText(ROMAJI_TEXT[POSITION_IMAGE[0]]);
                                    JAPAN_PROCEDURAL_ONE.setText(JAPAN_TEXT[POSITION_IMAGE[0]]);

                                    //two
                                    ENGLISH_PROCEDURAL_TWO.setText(ENGLISH_TEXT[POSITION_IMAGE[0] - 1]);
                                    ROMAJI_PROCEDURAL_TWO.setText(ROMAJI_TEXT[POSITION_IMAGE[0] -1]);
                                    JAPAN_PROCEDURAL_TWO.setText(JAPAN_TEXT[POSITION_IMAGE[0] -1]);

                                } else{

                                    TOP_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0]]);
                                    BOTTOM_ITEM.setTag(ROMAJI_TEXT[POSITION_IMAGE[0] + 1]);
                                    proceduralDropImage.setImageResource(IMAGE_SCENE_ONE[POSITION_IMAGE[0]]);
                                    //one
                                    ENGLISH_PROCEDURAL_ONE.setText(ENGLISH_TEXT[POSITION_IMAGE[0]]);
                                    ROMAJI_PROCEDURAL_ONE.setText(ROMAJI_TEXT[POSITION_IMAGE[0]]);
                                    JAPAN_PROCEDURAL_ONE.setText(JAPAN_TEXT[POSITION_IMAGE[0]]);

                                    //two
                                    ENGLISH_PROCEDURAL_TWO.setText(ENGLISH_TEXT[POSITION_IMAGE[0] +1]);
                                    ROMAJI_PROCEDURAL_TWO.setText(ROMAJI_TEXT[POSITION_IMAGE[0] +1]);
                                    JAPAN_PROCEDURAL_TWO.setText(JAPAN_TEXT[POSITION_IMAGE[0] +1]);
                                }

                            }
                        } else{
                            //false

                            Toast.makeText(getApplicationContext(),"DROP FAILED",Toast.LENGTH_SHORT).show();
                        }
                }
                return true;
            }
        });
    }

     class ITEM_CHOSE implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == event.ACTION_DOWN){
                ClipData clip_data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow_builder = new View.DragShadowBuilder(v);
                v.startDrag(clip_data,shadow_builder,v,0);
            } else {
                return true;
            }
            return false;
        }
    }
}