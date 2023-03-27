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
import ru.alex.lab1.adapter.MonsterClassAdapter;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.urls.monster.MonsterUrls;

public class MonsterService extends BaseService {

    private final Activity context;

    public MonsterService(Activity context) {
        this.context = context;
    }

    public void getMonsterClassList(MonsterClassAdapter monstersAdapter) {
        Request request = new Request.Builder()
                .url(MonsterUrls.GET_ALL_MONSTERS)
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

    private RecyclerCardPreview toPojo(MonsterClassDto monsterClassDto) {
        return new RecyclerCardPreview(monsterClassDto.getId(), monsterClassDto.getName(), monsterClassDto.getSource(), monsterClassDto.getImgName());
    }
}
