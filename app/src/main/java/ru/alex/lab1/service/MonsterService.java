package ru.alex.lab1.service;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.urls.monster.MonsterUrls;

public class MonsterService extends BaseService {

    List<MonsterClassDto> getMonsterClassList() {
        Request request = new Request.Builder()
                .url(MonsterUrls.GET_ALL_MONSTERS)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            Type listOfMyClassObject = new TypeToken<ArrayList<MonsterClassDto>>() {}.getType();
            return gson.fromJson(response.body().string(), listOfMyClassObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
