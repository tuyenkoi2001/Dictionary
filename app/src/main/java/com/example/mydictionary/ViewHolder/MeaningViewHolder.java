package com.example.mydictionary.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {

    public TextView partOfSpeech;
    public RecyclerView rcdef;
    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);
        partOfSpeech = itemView.findViewById(R.id.txtpos);
        rcdef = itemView.findViewById(R.id.rcdef);
    }

    public TextView getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(TextView partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public RecyclerView getRcdef() {
        return rcdef;
    }

    public void setRcdef(RecyclerView rcdef) {
        this.rcdef = rcdef;
    }
}
