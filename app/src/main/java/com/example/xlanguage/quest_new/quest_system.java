package com.example.xlanguage.quest_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xlanguage.R;
import com.example.xlanguage.type_learn.SceneDrag_Two;

public class quest_system extends AppCompatActivity {
    static void single_text(String str){
        String A, B;
        if(str.length() % 2 == 0){
            A = str.substring(0,str.length() / 2);
            B = str.substring(str.length() / 2 , str.length());
        } else{
            A = str.substring(0, str.length()/ 2 + 1);
            B = str.substring(str.length()/ 2 + 1, str.length());
        }
    }
    static String[] multi_text(String str){
        int n = 0;
        String arr[] = str.split(" ");
        return arr;
    }
    static class label{
        int x , y;
        int width , height;
        String text;
        public void setText(String str){
            this.text = str;
        }
        public void getText(){
            System.out.println(this.text);
        }
    }
    TextView part_one , part_two , part_three, quest_text;
    TextView tittle_english;
    ImageView image_quest;
    Bundle bndleIntent;
    SharedPreferences sv;
    Button btnOk;
    TextView labelOne[];
    TextView drag_place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_system);
        Intent getData = getIntent();
        btnOk = findViewById(R.id.btn_ok);
        quest_text = findViewById(R.id.text_quest);
        tittle_english = findViewById(R.id.english_quest);
        image_quest = findViewById(R.id.image_quest);
        bndleIntent = getData.getExtras();
        labelOne = new TextView[2];
        part_one = findViewById(R.id.part_one);
        part_two = findViewById(R.id.part_two);
        labelOne[0] = part_one;
        labelOne[1] = part_two;
        drag_place = findViewById(R.id.drop_quest);
        sv = getSharedPreferences("QUEST_SV",MODE_PRIVATE);
        final int[] post = {sv.getInt("POST_QUEST", 0)};
        String ROMAJI[] = bndleIntent.getStringArray("currentNonAlphabet");
        int imageListSceneOne[] = bndleIntent.getIntArray("currentImage");
        String englishText[] = bndleIntent.getStringArray("currentTittle");
        String japanText[] = bndleIntent.getStringArray("currentAlphabet");
        String romajiText[]  = bndleIntent.getStringArray("currentNonAlphabet");
        String PREF_POST = bndleIntent.getString("PREF_POSITION");

        if(post[0] >= ROMAJI.length){
            post[0] = 0;
        } else if(post[0] >= ROMAJI.length -1){
            post[0] = 0;
        }
        quest_text.setText(ROMAJI[post[0]]);
        tittle_english.setText(englishText[post[0]]);
        image_quest.setImageResource(imageListSceneOne[post[0]]);
        PARSE_TEXT(romajiText,post,labelOne,drag_place);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quest_text.getText().toString().equals(ROMAJI[post[0]]) && quest_text.getText().length() == ROMAJI[post[0]].length()){
                    Toast.makeText(getApplicationContext(),"ERROR" + quest_text.length() + "e:" + ROMAJI[post[0]].length(),Toast.LENGTH_SHORT).show();
                } else if(quest_text.getText().toString().equals(ROMAJI[post[0]]) && quest_text.getText().length() == ROMAJI[post[0]].length() ){
                    Toast.makeText(getApplicationContext(),"SUCCES",Toast.LENGTH_SHORT).show();
                    post[0]++;
                    if(post[0] >= ROMAJI.length) {
                        post[0] = 0;
                        SharedPreferences.Editor SAVE_POSTX = sv.edit();
                        SAVE_POSTX.putInt("POST_QUEST", post[0]);
                        SAVE_POSTX.commit();
                    }
                    SharedPreferences.Editor SAVE_POSTX = sv.edit();
                    SAVE_POSTX.putInt("POST_QUEST", post[0]);
                    SAVE_POSTX.commit();
                    quest_text.setText(ROMAJI[post[0]]);
                    tittle_english.setText(englishText[post[0]]);
                    image_quest.setImageResource(imageListSceneOne[post[0]]);
                    quest_text.setText("");
                    PARSE_TEXT(romajiText,post,labelOne,drag_place);
                    if(post[0] % 3 == 0){

                        Intent ChangeStage = new Intent(getApplicationContext(), SceneDrag_Two.class);
                        ChangeStage.putExtra("currentImage",imageListSceneOne);
                        ChangeStage.putExtra("currentTittle",englishText);
                        ChangeStage.putExtra("currentAlphabet",romajiText);
                        ChangeStage.putExtra("currentNonAlphabet",japanText);
                        ChangeStage.putExtra("PREF_POSITION",PREF_POST);
                        startActivity(ChangeStage);
                    }
                }
                if(post[0] >= ROMAJI.length) {
                    post[0] = 0;
                    SharedPreferences.Editor SAVE_POSTX = sv.edit();
                }
            }
        });
    }
    static void PARSE_TEXT(String[] str, int post[],TextView[] Label,TextView DragQuest){


        if(str[post[0]].length() % 2 == 0){

            DragQuest.setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View v, DragEvent event) {
                    int s = event.getAction();
                    switch (s){
                        case DragEvent.ACTION_DRAG_ENDED:
                            View tvView = (View) event.getLocalState();
                            TextView label = (TextView) tvView;
                            if(event.getResult()){
                                StringBuffer sb = new StringBuffer();
                                sb.append(label.getTag().toString());
                                DragQuest.setText(sb.toString());
                            }
                    }
                    return true;
                }
            });
            String A = str[post[0]].substring(0, str[post[0]].length() / 2 + 1);
            String B = str[post[0]].substring(str[post[0]].length()  / 2 + 1 , str[post[0]].length());
            Label[0].setText(A.toString());
            Label[0].setTag(A.toString());
            Label[1].setText(B.toString());
            Label[1].setText(B.toString());
            Label[0].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData cd=  ClipData.newPlainText("","");
                    View.DragShadowBuilder vd = new View.DragShadowBuilder(v);
                    v.startDrag(cd,vd,v,0);
                    return true;
                }
            });
            Label[1].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData cl = ClipData.newPlainText("","");
                    View.DragShadowBuilder shdow = new View.DragShadowBuilder(v);
                    v.startDrag(cl,shdow,v,0);
                    return true;
                }
            });
        }else{

            DragQuest.setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View v, DragEvent event) {
                    switch (event.getAction()){
                        case DragEvent.ACTION_DRAG_ENDED:
                            View tvView = (View) event.getLocalState();
                            TextView label = (TextView) tvView;
                            if(event.getResult()){
                                StringBuffer sb = new StringBuffer();
                                sb.append(DragQuest.getText() + label.getTag().toString());
                                DragQuest.setText(sb.toString());
                                Toast.makeText(v.getContext(),"Succes" , Toast.LENGTH_SHORT).show();
                            }
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            String A = str[post[0]].substring(0,str[post[0]].length() / 2 + 1);
            String B = str[post[0]].substring(str[post[0]].length()/ 2 + 1 ,str[post[0]].length());
            Label[0].setText(A.toString());
            Label[0].setTag(A.toString());
            Label[1].setText(B.toString());
            Label[1].setTag(B.toString());
            Label[1].setText(B.toString());
            Label[0].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData cd=  ClipData.newPlainText("","");
                    View.DragShadowBuilder vd = new View.DragShadowBuilder(v);
                    v.startDrag(cd,vd,v,0);
                    return true;
                }
            });
            Label[1].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData cl = ClipData.newPlainText("","");
                    View.DragShadowBuilder shdow = new View.DragShadowBuilder(v);
                    v.startDrag(cl,shdow,v,0);
                    return true;
                }
            });

        }

    }
}