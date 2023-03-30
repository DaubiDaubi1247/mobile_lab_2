package ru.alex.lab1.service;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.urls.monster.MonsterUrls;

public class MonsterService extends BaseService {

    private final Activity context;
    Gson gson = new Gson();

    public MonsterService(Activity context) {
        this.context = context;
    }

    public void getMonsterClassList(MonsterCallBack callBack) {
        Request request = new Request.Builder()
                .url(MonsterUrls.GET_ALL_MONSTER_CLASS)
                .build();

        makeRequest(callBack, request);
    }

    public void getMonsterListByClassId(Long id, MonsterCallBack callBack) {
        Request request = new Request.Builder()
                .url(MonsterUrls.GET_ALL_MONSTERS + id)
                .build();

        makeRequest(callBack, request);
    }

    public void getMonsterById(Long id, MonsterCallBack callBack) {
        Request request = new Request.Builder()
                .url(MonsterUrls.MONSTER + id)
                .build();

        makeRequest(callBack, request);
    }

    private void makeRequest(MonsterCallBack callBack, Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(@NonNull Call call, @NonNull IOException
                    error) {
                error.printStackTrace();
            }
            @Override public void onResponse(@NonNull Call call, @NonNull Response
                    response) throws IOException {

                assert response.body() != null;
                String responseBody = response.body().string();

                if (!response.isSuccessful()) {
                    try {
                        JSONObject responseError = new JSONObject(responseBody);
                        Log.w("monster service", responseError.getString("message"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    return;
                }

                context.runOnUiThread(() -> callBack.onSuccess(responseBody));
            }
        });
    }
}
