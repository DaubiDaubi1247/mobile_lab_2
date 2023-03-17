package ru.alex.lab1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.alex.lab1.R;
import ru.alex.lab1.pojo.Monster;
import ru.alex.lab1.recycler.ElementType;

public class MonstersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<ElementType> elements;

    public MonstersAdapter(Context context, List<ElementType> elements) {
        this.elements = elements;
    }

    @Override
    public int getItemViewType(int position) {
        return elements.get(position).getViewType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ElementType.TITLE) {
            return new TitleViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.title, parent, false));
        }

        return new MonsterViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        elements.get(position).onBindHandler(holder);
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public static class MonsterViewHolder extends RecyclerView.ViewHolder {

        public ImageView getMonsterImage() {
            return monsterImage;
        }

        public TextView getMonsterTextView() {
            return monsterTextView;
        }

        private final ImageView monsterImage;
        private final TextView monsterTextView;
        public MonsterViewHolder(View itemView) {
            super(itemView);
            monsterImage = itemView.findViewById(R.id.recycler_view_card_img);
            monsterTextView = itemView.findViewById(R.id.recycler_view_card_title);
        }

    }

    public static class TitleViewHolder extends RecyclerView.ViewHolder {
        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
