package ru.alex.lab1.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.R;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dao.MonsterDao;
import ru.alex.lab1.db.AppDataBase;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.pojo.MonsterListTitle;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.MonsterConverterDbImpl;
import ru.alex.lab1.utils.converter.MonsterConverterDbWithList;

public class MonsterCardPreviewFragment extends android.app.Fragment implements MonsterCallBack<List<RecyclerCardPreview>> {
    private Long classId;

    private MonsterService monsterService;
    private final MonsterConverterDbWithList<RecyclerCardPreview, Monster, MonsterDto> monsterConverterDb;

    List<RecyclerViewElement> recyclerViewElementList;

    private CardPreviewAdapter cardPreviewAdapter;

    private Activity activity;

    public MonsterCardPreviewFragment() {
        this.activity = new Activity();
        this.monsterConverterDb = new MonsterConverterDbImpl();
        recyclerViewElementList = new ArrayList<>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        classId = getArguments().getLong("id", 1);

        String title = getArguments().getString("title");
        recyclerViewElementList.add(new MonsterListTitle(title));
        cardPreviewAdapter = new CardPreviewAdapter(recyclerViewElementList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monster_card_preview1, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.monster_list_recycler);

        monsterService = new MonsterService(getActivity());
        setInitialData(classId);

        recyclerView.setAdapter(cardPreviewAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (cardPreviewAdapter.getItemViewType(position) == RecyclerViewElement.MONSTER_LIST_TITLE) {
                    return 2;
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        return view;
    }

    private void setInitialData(long id) {
        monsterService.getMonsterListByClassId(id, this);
    }

    @Override
    public void onSuccess(List<RecyclerCardPreview> response) {
        cardPreviewAdapter.updateCardPreviewRecycler(response);

        AsyncTask.execute(() -> {
            AppDataBase db = AppDataBase.getInstance(getContext());
            MonsterDao monsterDao = db.getMonsterDao();
            monsterDao.nukeTableByClassId(classId);

            List<Monster> monsterList = monsterConverterDb.toEntityList(response);
            monsterList.forEach(el -> el.setClassId(classId));
            monsterDao.insertAll(monsterList);
        });
    }

    @Override
    public void onFail(IOException error){
        AsyncTask.execute(() -> {
            AppDataBase db = AppDataBase.getInstance(getContext());
            MonsterDao monsterDao = db.getMonsterDao();
            List<MonsterDto> monsterClassDtoList = monsterConverterDb.toDtoList(monsterDao.getAllByClassId(classId));

            getActivity().runOnUiThread(() -> cardPreviewAdapter.updateCardPreviewRecycler(monsterClassDtoList.stream()
                    .map(MonsterDto::toPojo).collect(Collectors.toList())));

        });
    }
}