package com.example.mydictionary.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {

    TextView txtdef,txtexample,txtsyn,txt_antony;
    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);
        txtdef = itemView.findViewById(R.id.txtdef);
        txtexample = itemView.findViewById(R.id.txtexample);
        txtsyn = itemView.findViewById(R.id.txtsyn);
        txt_antony = itemView.findViewById(R.id.txt_antony);
    }

    public TextView getTxtdef() {
        return txtdef;
    }

    public void setTxtdef(TextView txtdef) {
        this.txtdef = txtdef;
    }

    public TextView getTxtexample() {
        return txtexample;
    }

    public void setTxtexample(TextView txtexample) {
        this.txtexample = txtexample;
    }

    public TextView getTxtsyn() {
        return txtsyn;
    }

    public void setTxtsyn(TextView txtsyn) {
        this.txtsyn = txtsyn;
    }

    public TextView getTxt_antony() {
        return txt_antony;
    }

    public void setTxt_antony(TextView txt_antony) {
        this.txt_antony = txt_antony;
    }
}
