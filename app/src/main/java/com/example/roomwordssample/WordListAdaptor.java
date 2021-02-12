package com.example.roomwordssample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class WordListAdaptor extends RecyclerView.Adapter<WordListAdaptor.WordViewHolder> {
    private final LayoutInflater inflater;
    private List<Word> words;

    WordListAdaptor(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemview = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if(words != null){
            Word current = words.get(position);
            holder.wordItemView.setText(current.getWord());
        }
    }

    void setWords(List<Word> words){
        this.words = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(words != null){
            return words.size();
        }
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder{
        private final TextView wordItemView;

        private WordViewHolder(View itemView){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}
