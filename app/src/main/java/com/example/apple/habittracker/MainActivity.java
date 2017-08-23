package com.example.apple.habittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.apple.habittracker.data.HabitContract.HabitEntry;
import com.example.apple.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper dbHelper = new HabitDbHelper(this);
        dbHelper.insertHabit("Rock music", "Action movie", HabitEntry.SPORT_BASKETBALL);
        dbHelper.readHabit();
        dbHelper.updateSportHabit(HabitEntry.SPORT_SOCCER);
        dbHelper.readHabit();
        dbHelper.deleteHabitDB(this);
    }
}
