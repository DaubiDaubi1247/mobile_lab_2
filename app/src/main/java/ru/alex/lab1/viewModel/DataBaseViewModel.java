package ru.alex.lab1.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Room;

import ru.alex.lab1.db.AppDataBase;

public class DataBaseViewModel extends AndroidViewModel {

    private AppDataBase db = Room.databaseBuilder(getApplication(),
                    AppDataBase.class, "database-name")
            .build();

    public AppDataBase getDb() {
        return db;
    }

    public DataBaseViewModel(@NonNull Application application) {
        super(application);
    }
}
