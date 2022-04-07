package com.example.mydictionary.ViewHolder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {

    TextView txt_phonetic;
    ImageButton btnaudio;
    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);
        btnaudio = itemView.findViewById(R.id.btnaudio);
        txt_phonetic = itemView.findViewById(R.id.txt_phonetic);
    }
    public TextView getTxt_phonetic() {
        return txt_phonetic;
    }

    public void setTxt_phonetic(TextView txt_phonetic) {
        this.txt_phonetic = txt_phonetic;
    }

    public ImageButton getBtnaudio() {
        return btnaudio;
    }

    public void setBtnaudio(ImageButton btnaudio) {
        this.btnaudio = btnaudio;
    }

}
