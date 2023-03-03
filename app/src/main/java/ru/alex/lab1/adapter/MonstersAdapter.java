package ru.alex.lab1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.alex.lab1.R;
import ru.alex.lab1.pojo.Monster;

public class MonstersAdapter extends RecyclerView.Adapter<MonstersAdapter.MonsterViewHolder> {
    private List<Monster> monsterList = new ArrayList<>();
    private final LayoutInflater inflater;

    public MonstersAdapter(Context context, List<Monster> states) {
        this.monsterList = states;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_card, parent, false);

        return new MonsterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder holder, int position) {
        Monster monster = monsterList.get(position);
        holder.monsterTextView.setText(monster.getName());
        holder.monsterImage.setImageResource(monster.getImgResource());
    }

    @Override
    public int getItemCount() {
        return monsterList.size();
    }

    class MonsterViewHolder extends RecyclerView.ViewHolder {
        // Ваш ViewHolder должен содержать переменные для всех
        // View-компонентов, которым вы хотите задавать какие-либо свойства
        // в процессе работы пользователя со списком
        private ImageView monsterImage;
        private TextView monsterTextView;

        // Мы также создали конструктор, который принимает на вход View-компонент строкИ
        // и ищет все дочерние компоненты
        public MonsterViewHolder(View itemView) {
            super(itemView);
            monsterImage = itemView.findViewById(R.id.recycler_view_card_img);
            monsterTextView = itemView.findViewById(R.id.recycler_view_card_title);
        }

    }
}
