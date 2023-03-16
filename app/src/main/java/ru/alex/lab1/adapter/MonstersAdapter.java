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
        if (elements.get(position) instanceof Monster) {
            return ElementType.CARDS;
        }

        return ElementType.TITLE;
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

        if (holder instanceof MonsterViewHolder) {
            Monster monster = (Monster) elements.get(position);
             ((MonsterViewHolder) holder).monsterTextView.setText(monster.getName());
             ((MonsterViewHolder) holder).monsterImage.setImageResource(monster.getImgResource());
        }

    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    static class MonsterViewHolder extends RecyclerView.ViewHolder {
        // Ваш ViewHolder должен содержать переменные для всех
        // View-компонентов, которым вы хотите задавать какие-либо свойства
        // в процессе работы пользователя со списком
        private final ImageView monsterImage;
        private final TextView monsterTextView;

        // Мы также создали конструктор, который принимает на вход View-компонент строкИ
        // и ищет все дочерние компоненты
        public MonsterViewHolder(View itemView) {
            super(itemView);
            monsterImage = itemView.findViewById(R.id.recycler_view_card_img);
            monsterTextView = itemView.findViewById(R.id.recycler_view_card_title);
        }

    }

    static class TitleViewHolder extends RecyclerView.ViewHolder {
        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
