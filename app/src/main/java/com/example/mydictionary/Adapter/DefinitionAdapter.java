package com.example.mydictionary.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Definitions;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolder.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    Context context;
    List<Definitions> list;

    public DefinitionAdapter(Context context, List<Definitions> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.def_list_item,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.getTxtdef().setText("Definition: "+list.get(position).getDefinitions());
        holder.getTxtexample().setText("Example: "+list.get(position).getExample());
        StringBuilder sync = new StringBuilder();
        StringBuilder ano = new StringBuilder();
        sync.append(list.get(position).getSynonyms());
        ano.append(list.get(position).getAntonyms());

        holder.getTxtsyn().setText(sync);
        holder.getTxt_antony().setText(ano);

        holder.getTxtsyn().setSelected(true);
        holder.getTxt_antony().setSelected(true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
