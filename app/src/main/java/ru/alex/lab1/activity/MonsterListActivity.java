package ru.alex.lab1.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import ru.alex.lab1.R;
import ru.alex.lab1.fragment.MonsterCardPreviewFragment;

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