package ru.alex.lab1.service;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

public class BaseService {
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();
}
