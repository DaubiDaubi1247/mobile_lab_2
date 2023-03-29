package ru.alex.lab1.service;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import ru.alex.lab1.activity.CardDescriptionActivity;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterByIdCallBack;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.urls.monster.MonsterUrls;

public class MonsterService extends BaseService {

    private final Activity context;

    public MonsterService(Activity context) {
        this.context = context;
    }

    public void getMonsterClassList(CardPreviewAdapter monstersAdapter) {
        Request request = new Request.Builder()
                .url(MonsterUrls.GET_ALL_MONSTER_CLASS)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(@NonNull Call call, @NonNull IOException
                    error) {
                error.printStackTrace();
            }
            @Override public void onResponse(@NonNull Call call, @NonNull Response
                    response) throws IOException {
                Type listOfMyClassObject = new TypeToken<ArrayList<MonsterClassDto>>() {}.getType();
                assert response.body() != null;
                List<MonsterClassDto> monsterClassDtoList = gson.fromJson(response.body().string(), listOfMyClassObject);

                context.runOnUiThread(() -> monstersAdapter.updateMonsterCLassList(monsterClassDtoList.stream()
                        .map(MonsterClassDto::toPojo)
                        .collect(Collectors.toList())));
            }
        });

    }

    public void getMonsterListByClassId(CardPreviewAdapter monstersAdapter, Long id) {
        Request request = new Request.Builder()
                .url(MonsterUrls.GET_ALL_MONSTERS + id)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(@NonNull Call call, @NonNull IOException
                    error) {
                error.printStackTrace();
            }
            @Override public void onResponse(@NonNull Call call, @NonNull Response
                    response) throws IOException {
                Type listOfMyClassObject = new TypeToken<ArrayList<MonsterDto>>() {}.getType();
                assert response.body() != null;
                List<MonsterDto> monsterClassDtoList = gson.fromJson(response.body().string(), listOfMyClassObject);

                context.runOnUiThread(() -> monstersAdapter.updateMonsterCLassList(monsterClassDtoList.stream()
                        .map(MonsterDto::toPojo)
                        .collect(Collectors.toList())));
            }
        });

    }

    public void getMonsterById(Long id, MonsterByIdCallBack callBack) {
        Request request = new Request.Builder()
                .url(MonsterUrls.MONSTER + id)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(@NonNull Call call, @NonNull IOException
                    error) {
                error.printStackTrace();
            }
            @Override public void onResponse(@NonNull Call call, @NonNull Response
                    response) throws IOException {

                assert response.body() != null;
                MonsterWithDescriptionDto monsterWithDescriptionDto = gson.fromJson(response.body().string(),
                        MonsterWithDescriptionDto.class);

                context.runOnUiThread(() -> callBack.onSuccess(monsterWithDescriptionDto));
            }
        });

    }
}
