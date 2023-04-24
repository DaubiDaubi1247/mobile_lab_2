package ru.alex.lab1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.R;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dao.MonsterClassDao;
import ru.alex.lab1.dao.MonsterDao;
import ru.alex.lab1.db.AppDataBase;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.fragment.MonsterCardPreviewFragment;
import ru.alex.lab1.fragment.RecyclerPreviewCardFragment;
import ru.alex.lab1.pojo.MonsterListTitle;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.MonsterConverterDbImpl;
import ru.alex.lab1.utils.converter.MonsterConverterDb;
import ru.alex.lab1.utils.converter.MonsterConverterDbWithList;

public class MonsterListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list_acitvity);

        long classId = getIntent().getLongExtra("id", 1);

        String title = getIntent().getStringExtra("title");

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MonsterCardPreviewFragment fragment = new MonsterCardPreviewFragment();

        Bundle bundle = new Bundle();
        bundle.putLong("id", classId);
        bundle.putString("title", title);
        fragment.setArguments(bundle);

        fragmentTransaction.add(R.id.monster_list_body, fragment);
        fragmentTransaction.commit();
    }

}