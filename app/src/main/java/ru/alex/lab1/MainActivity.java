package ru.alex.lab1;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dao.MonsterClassDao;
import ru.alex.lab1.db.AppDataBase;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.fragment.RecyclerPreviewCardFragment;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.pojo.Title;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.MonsterClassConverterDbImpl;
import ru.alex.lab1.utils.converter.MonsterConverterDb;
import ru.alex.lab1.utils.converter.MonsterConverterDbWithList;

public class MainActivity extends FragmentActivity {

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RecyclerPreviewCardFragment fragment = new RecyclerPreviewCardFragment();
        fragmentTransaction.add(R.id.body, fragment);
        fragmentTransaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.footer);
        bottomNavigationView.setSelectedItemId(R.id.page_2);

    }


}