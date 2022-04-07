package com.example.mydictionary.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Meanings;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolder.MeaningViewHolder;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {

    private Context context;
    private List<Meanings> list;

    public MeaningAdapter(Context context, List<Meanings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.meaning_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.getPartOfSpeech().setText("Part of speech: "+ list.get(position).getPartOfSpeech());
        holder.getRcdef().setHasFixedSize(true);

        LinearLayoutManager layout = new LinearLayoutManager(context);
        layout.setOrientation(RecyclerView.HORIZONTAL);

        holder.getRcdef().setLayoutManager(layout);
        DefinitionAdapter adapter = new DefinitionAdapter(context,list.get(position).getDefinitions());
        holder.getRcdef().setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
