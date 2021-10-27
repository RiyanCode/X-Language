package com.example.xlanguage.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xlanguage.R;

public class AdapterStatic extends RecyclerView.Adapter<AdapterStatic.ViewHolder> {
    private int images[];
    private String tittle[], alphabet[] , nonAlphabet[];
    private Context context;
    private int p_LayoutName = R.layout.newaadapterlayout;
    private int p_ImageField = R.id.iconCard;
    private int p_TittleField = R.id.tittleCard;
    private int p_Alphabet = R.id.alphabetText;
    private int p_NonAlphabetField = R.id.textJapanCard;
    private int pLevel = R.id.levelId;
    private adapterListener listener;
    int level;
    String levels[];
    String namePrefences[];

    public AdapterStatic(Context ctx,int images[] ,String tittle[] , String alphabet[] , String nonAlphabet[],adapterListener Listener, String[] sharedName ,String[] data_level){
        this.context = ctx;
        this.images = images;
        this.tittle = tittle;
        this.alphabet = alphabet;
        this.nonAlphabet = nonAlphabet;
        this.listener = Listener;
        this.namePrefences = sharedName;
        this.levels = data_level;

    }

    @NonNull
    @Override
    public AdapterStatic.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(p_LayoutName,parent,false);

        return new AdapterStatic.ViewHolder(view);
    }


    @Override

    public void onBindViewHolder(@NonNull AdapterStatic.ViewHolder holder, int position) {
        holder.setImageAdapter.setImageResource(images[position]);
        holder.setTittleAdapter.setText(tittle[position]);
            holder.setAlphabetAdapter.setText(alphabet[position]);
        holder.setNonAlphabetAdapter.setText(nonAlphabet[position]);
        holder.ctx.getApplicationContext();
        SharedPreferences getData = holder.ctx.getSharedPreferences(namePrefences[position],Context.MODE_PRIVATE);

        int s = getData.getInt(namePrefences[position],0);
        holder.levelText.setText(String.valueOf(s));
        holder.progress.setProgress(s);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView setImageAdapter;
        TextView setTittleAdapter , setAlphabetAdapter, setNonAlphabetAdapter,levelText;
        ProgressBar progress;
        ConstraintLayout layoutitems;
        SharedPreferences setPref;
        Context ctx;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            setImageAdapter = itemView.findViewById(p_ImageField);
            setTittleAdapter = itemView.findViewById(p_TittleField);
            setAlphabetAdapter = itemView.findViewById(p_Alphabet);
            setNonAlphabetAdapter = itemView.findViewById(p_NonAlphabetField);
            layoutitems = itemView.findViewById(R.id.layoutItem);
            levelText = itemView.findViewById(pLevel);
            ctx = itemView.getContext();
            itemView.setOnClickListener(this);
            progress = itemView.findViewById(R.id.levelBar);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }
    public interface adapterListener{
        void onClick(View v , int position);
    }
}
