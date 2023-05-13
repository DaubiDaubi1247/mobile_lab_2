package ru.alex.lab1.fragment;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import ru.alex.lab1.R;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dao.MonsterDao;
import ru.alex.lab1.dao.MonsterDescriptionDao;
import ru.alex.lab1.db.AppDataBase;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.entity.MonsterDescription;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.urls.BaseUrl;
import ru.alex.lab1.utils.converter.Impl.GsonMonsterConverterImpl;
import ru.alex.lab1.utils.converter.Impl.MonsterDescriptionConverterDbImpl;
import ru.alex.lab1.utils.converter.MonsterConverter;
import ru.alex.lab1.utils.converter.MonsterConverterDb;

public class CardDescriptionFragment extends Fragment implements MonsterCallBack<MonsterWithDescriptionDto> {

    private Long monsterId;

    private View parentView;

    private final MonsterConverterDb<MonsterWithDescriptionDto, MonsterDescription, MonsterWithDescriptionDto> monsterConverterDb;

    public CardDescriptionFragment() {
        monsterConverterDb = new MonsterDescriptionConverterDbImpl();;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        monsterId = getArguments().getLong("id", 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentView = inflater.inflate(R.layout.fragment_card_desctiption, container, false);
        MonsterService monsterService = new MonsterService(getActivity());
        monsterService.getMonsterById(monsterId, this);

        parentView.findViewById(R.id.card_description_scroll).setVerticalScrollBarEnabled(false);
        return parentView;
    }

    @Override
    public void onSuccess(MonsterWithDescriptionDto response) {

        setMonsterDescriptionOnUi(response);

        AsyncTask.execute(() -> {
            AppDataBase db = AppDataBase.getInstance(getContext());
            MonsterDescriptionDao monsterDescriptionDao = db.getMonsterDescDao();
            monsterDescriptionDao.nukeTableByMonsterId(monsterId);

            MonsterDescription monsterDescription = monsterConverterDb.toEntity(response);
            monsterDescription.setMonsterId(monsterId);
            monsterDescriptionDao.insert(monsterDescription);
        });
    }

    @Override
    public void onFail(IOException error) {
        AsyncTask.execute(() -> {
            AppDataBase db = AppDataBase.getInstance(getContext());
            MonsterDescriptionDao monsterDescriptionDao = db.getMonsterDescDao();
            MonsterDao monsterDao = db.getMonsterDao();
            MonsterWithDescriptionDto monsterWithDescriptionDto;
            try {
                monsterWithDescriptionDto  = monsterConverterDb.toDto(monsterDescriptionDao.getMonsterById(monsterId)
                        .orElseThrow(() -> new RuntimeException("not found")));
            } catch (RuntimeException e) {
                Log.e("monster description", e.getMessage());
                return;
            }

            monsterWithDescriptionDto.setSource(monsterDao.getMonsterById(monsterId));

            getActivity().runOnUiThread(() -> setMonsterDescriptionOnUi(monsterWithDescriptionDto));

        });
    }

    private void setMonsterDescriptionOnUi(MonsterWithDescriptionDto monsterDto) {
        ImageView imageView = parentView.findViewById(R.id.card_description_img);
        Glide.with(this)
                .load(BaseUrl.BASE_FOR_IMG + monsterDto.getSource() + monsterDto.getImgName())
                .thumbnail(Glide.with(this).load(R.drawable.preloader))
                .fitCenter()
                .into(imageView);

        TextView textView = parentView.findViewById(R.id.card_description_name);
        textView.setText(monsterDto.getName());
        textView.setTypeface(null, Typeface.BOLD);

        textView = parentView.findViewById(R.id.card_description_quote);
        textView.setText(monsterDto.getQuote());
        textView.setTypeface(null, Typeface.ITALIC);

        textView = parentView.findViewById(R.id.card_description_quote_author);
        textView.setText(monsterDto.getQuoteAuthor());

        textView = parentView.findViewById(R.id.card_description_description);
        textView.setText(monsterDto.getDescription());
    }
}