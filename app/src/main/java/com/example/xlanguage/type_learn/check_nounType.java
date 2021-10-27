package com.example.xlanguage.type_learn;

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

import java.lang.reflect.Field;

public class check_nounType extends AppCompatActivity {
    SharedPreferences sv;
    Bundle bndleIntent;
    ImageView icon_v;
    TextView Field_Drop , English_Word , ObjectDrag_1 , ObjectDrag_2,RomajiField , ObjectDrag_3,ObjectDrag_4,ObjectDrag_5;
    Button verifiedAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkknowledge);
        Intent getIntent = getIntent();
        bndleIntent = getIntent.getExtras();
        sv = getSharedPreferences("QUEST_SV",MODE_PRIVATE);
        final int[] post = {sv.getInt("POST_QUEST", 0)};
        int imageListSceneOne[] = bndleIntent.getIntArray("currentImage");
        String englishText[] = bndleIntent.getStringArray("currentTittle");
        String japanText[] = bndleIntent.getStringArray("currentAlphabet");
        String romajiText[]  = bndleIntent.getStringArray("currentNonAlphabet");
        String PREF_POST = bndleIntent.getString("PREF_POSITION");
        int max = englishText.length;
        icon_v = findViewById(R.id.icon_knowledge);
        Field_Drop = findViewById(R.id.drop_knowledge);
        English_Word = findViewById(R.id.knowledge_english);
        ObjectDrag_1 = findViewById(R.id.item_selectedKnowledge1);
        ObjectDrag_2 = findViewById(R.id.item_selectedKnowledge2);
        ObjectDrag_3 = findViewById(R.id.item_selectedKnowledge3);
        ObjectDrag_4 = findViewById(R.id.item_selectedKnowledge4);
        ObjectDrag_5 = findViewById(R.id.item_selectedKnowledge5);
        RomajiField = findViewById(R.id.romaji_test);
        verifiedAction = findViewById(R.id.buttonCheckKnowledge);
        //set text & image
        icon_v.setImageResource(imageListSceneOne[post[0]]);
        English_Word.setText(englishText[post[0]]);
        RomajiField.setText(romajiText[post[0]]);
     //set zero
        if(post[0] == imageListSceneOne.length - 1){
            post[0] = 0;
        }
        //check
        int nTextViewObj = 5;
        int fla = 3;
        if(romajiText[post[0]].toString().length() % 2 == 0){
            String A = romajiText[post[0]].substring(0,romajiText[post[0]].length()/2);
            String B = romajiText[post[0]].substring(romajiText[post[0]].length() / 2 , romajiText[post[0]].length());
            ObjectDrag_1.setText(A.toString());
            ObjectDrag_2.setText(B.toString());
            ObjectDrag_1.setTag(A.toString());
            ObjectDrag_2.setTag(B.toString());
            for(int d = 0;d< max;d++){
                int n = (int)(Math.random() * max);
                String A1 = romajiText[n].substring(0,romajiText[n].length()/2);
                String B2 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                String B3 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                ObjectDrag_3.setText(A1.toString());
                ObjectDrag_3.setTag(A1.toString());
                ObjectDrag_4.setText(B2.toString());
                ObjectDrag_4.setTag(B2.toString());
                ObjectDrag_5.setText(B3.toString());
                ObjectDrag_5.setTag(B3.toString());
            }
        } else if(romajiText[post[0]].toString().length() % 2 != 0) {
            String A = romajiText[post[0]].substring(0,romajiText[post[0]].length() / 2 + 1);
            String B = romajiText[post[0]].substring(romajiText[post[0]].length()/2 + 1, romajiText[post[0]].length());
            ObjectDrag_1.setText(A.toString());
            ObjectDrag_2.setText(B.toString());
            ObjectDrag_1.setTag(A.toString());
            ObjectDrag_2.setTag(B.toString());

            for(int d = 0;d< max;d++){
                int n = (int)(Math.random() * max);
                String A1 = romajiText[n].substring(0,romajiText[n].length()/2 + 1);
                String B2 = romajiText[n].substring(romajiText[n].length() / 2 + 1, romajiText[n].length());
                String B3 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                ObjectDrag_3.setText(A1.toString());
                ObjectDrag_3.setTag(A1.toString());
                ObjectDrag_4.setText(B2.toString());
                ObjectDrag_4.setTag(B2.toString());
                ObjectDrag_5.setText(B3.toString());
                ObjectDrag_5.setTag(B3.toString());
            }
        } else if(romajiText[post[0]].toString().length() == 3){
            String A = romajiText[post[0]].substring(0,1);
            String B = romajiText[post[0]].substring(1,2);
            ObjectDrag_1.setText(A.toString());
            ObjectDrag_2.setText(B.toString());
            ObjectDrag_1.setTag(A.toString());
            ObjectDrag_2.setTag(B.toString());

            for(int d = 0;d< max;d++){
                int n = (int)(Math.random() * max);
                String A1 = romajiText[n].substring(0,romajiText[n].length()/2 + 1);
                String B2 = romajiText[n].substring(romajiText[n].length() / 2 + 1, romajiText[n].length());
                String B3 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                ObjectDrag_3.setText(A1.toString());
                ObjectDrag_3.setTag(A1.toString());
                ObjectDrag_4.setText(B2.toString());
                ObjectDrag_4.setTag(B2.toString());
                ObjectDrag_5.setText(B3.toString());
                ObjectDrag_5.setTag(B3.toString());
            }
        }
        Field_Drop.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()){
                    case DragEvent.ACTION_DRAG_ENDED:

                        View getLocalItem = (View) event.getLocalState();
                        TextView gt = (TextView) getLocalItem;
                        if(event.getResult()){

                            Toast.makeText(getApplicationContext(),"Drop COmplete",Toast.LENGTH_SHORT).show();;
                            Field_Drop.setText(Field_Drop.getText().toString() + gt.getTag().toString());
                        } else{
                            Toast.makeText(getApplicationContext(),"Drop Not COmplete",Toast.LENGTH_SHORT).show();;
                        }
                }
                return true;
            }
        });
        ObjectDrag_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData cl = ClipData.newPlainText("","");
                View.DragShadowBuilder shdo = new View.DragShadowBuilder(v);
                v.startDrag(cl,shdo,v,0);
                return true;
            }
        });
        ObjectDrag_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData cls = ClipData.newPlainText("","");
                View.DragShadowBuilder shadw = new View.DragShadowBuilder(v);
                v.startDrag(cls,shadw,v,0);
                return true;
            }
        });
        verifiedAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Field_Drop.getText().toString().equals(romajiText[post[0]].toString())){

                    post[0]++;

                    if(post[0] % 2 ==0){
                        Intent ChangeStage = new Intent(getApplicationContext(), SceneDrag_Two.class);
                        ChangeStage.putExtra("currentImage",imageListSceneOne);
                        ChangeStage.putExtra("currentTittle",englishText);
                        ChangeStage.putExtra("currentAlphabet",romajiText);
                        ChangeStage.putExtra("currentNonAlphabet",japanText);
                        ChangeStage.putExtra("PREF_POSITION",PREF_POST);
                        startActivity(ChangeStage);
                    }

                    Toast.makeText(getApplicationContext(),"Succes",Toast.LENGTH_SHORT).show();
                    icon_v.setImageResource(imageListSceneOne[post[0]]);
                    English_Word.setText(englishText[post[0]]);
                    RomajiField.setText(romajiText[post[0]]);
                    //set zero
                    if(post[0] == imageListSceneOne.length - 1){
                        post[0] = 0;
                    }

                    SharedPreferences.Editor SAVE_POSTX = sv.edit();
                    SAVE_POSTX.putInt("POST_QUEST", post[0]);
                    SAVE_POSTX.commit();
                    //check
                    if(romajiText[post[0]].toString().length() % 2 == 0){
                        String A = romajiText[post[0]].substring(0,romajiText[post[0]].length()/2);
                        String B = romajiText[post[0]].substring(romajiText[post[0]].length() / 2 , romajiText[post[0]].length());
                        ObjectDrag_1.setText(A.toString());
                        ObjectDrag_2.setText(B.toString());
                        ObjectDrag_1.setTag(A.toString());
                        ObjectDrag_2.setTag(B.toString());
                        for(int d = 0;d< max;d++){
                            int n = (int)(Math.random() * max);
                            String A1 = romajiText[n].substring(0,romajiText[n].length()/2);
                            String B2 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                            String B3 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                            ObjectDrag_3.setText(A1.toString());
                            ObjectDrag_3.setTag(A1.toString());
                            ObjectDrag_4.setText(B2.toString());
                            ObjectDrag_4.setTag(B2.toString());
                            ObjectDrag_5.setText(B3.toString());
                            ObjectDrag_5.setTag(B3.toString());
                        }
                    } else if(romajiText[post[0]].toString().length() % 2 != 0) {
                        String A = romajiText[post[0]].substring(0,romajiText[post[0]].length() / 2 + 1);
                        String B = romajiText[post[0]].substring(romajiText[post[0]].length()/2 + 1, romajiText[post[0]].length());
                        ObjectDrag_1.setText(A.toString());
                        ObjectDrag_2.setText(B.toString());
                        ObjectDrag_1.setTag(A.toString());
                        ObjectDrag_2.setTag(B.toString());

                        for(int d = 0;d< max;d++){
                            int n = (int)(Math.random() * max);
                            String A1 = romajiText[n].substring(0,romajiText[n].length()/2 + 1);
                            String B2 = romajiText[n].substring(romajiText[n].length() / 2 + 1, romajiText[n].length());
                            String B3 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                            ObjectDrag_3.setText(A1.toString());
                            ObjectDrag_3.setTag(A1.toString());
                            ObjectDrag_4.setText(B2.toString());
                            ObjectDrag_4.setTag(B2.toString());
                            ObjectDrag_5.setText(B3.toString());
                            ObjectDrag_5.setTag(B3.toString());
                        }
                    } else if(romajiText[post[0]].toString().length() == 3){
                        String A = romajiText[post[0]].substring(0,1);
                        String B = romajiText[post[0]].substring(1,2);
                        ObjectDrag_1.setText(A.toString());
                        ObjectDrag_2.setText(B.toString());
                        ObjectDrag_1.setTag(A.toString());
                        ObjectDrag_2.setTag(B.toString());

                        for(int d = 0;d< max;d++){
                            int n = (int)(Math.random() * max);
                            String A1 = romajiText[n].substring(0,romajiText[n].length()/2 + 1);
                            String B2 = romajiText[n].substring(romajiText[n].length() / 2 + 1, romajiText[n].length());
                            String B3 = romajiText[n].substring(romajiText[n].length() / 2 , romajiText[n].length());
                            ObjectDrag_3.setText(A1.toString());
                            ObjectDrag_3.setTag(A1.toString());
                            ObjectDrag_4.setText(B2.toString());
                            ObjectDrag_4.setTag(B2.toString());
                            ObjectDrag_5.setText(B3.toString());
                            ObjectDrag_5.setTag(B3.toString());

                        }
                    }
                    Field_Drop.setText("");
                } else{
                    Toast.makeText(getApplicationContext(),"Error Data Not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}