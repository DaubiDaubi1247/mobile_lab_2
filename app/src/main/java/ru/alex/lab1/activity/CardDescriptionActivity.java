package ru.alex.lab1.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import ru.alex.lab1.R;
import ru.alex.lab1.fragment.CardDescriptionFragment;

public class CardDescriptionActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);

        long monsterId = getIntent().getLongExtra("id", 1);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CardDescriptionFragment fragment = new CardDescriptionFragment();

        Bundle bundle = new Bundle();
        bundle.putLong("id", monsterId);
        fragment.setArguments(bundle);

        fragmentTransaction.add(R.id.card_description_body, fragment);
        fragmentTransaction.commit();
    }

}
