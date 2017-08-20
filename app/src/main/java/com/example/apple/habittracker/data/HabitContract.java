package com.example.apple.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by justin on 2017/8/20.
 */

public class HabitContract {
    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns{
        public final static String TABLE_NAME = "myHabit";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_MUSIC = "music";
        public final static String COLUMN_MOVIE = "movie";
        public final static String COLUMN_SPORT = "sport";

        public final static int SPORT_BASEBALL = 0;
        public final static int SPORT_BASKETBALL = 1;
        public final static int SPORT_SOCCOER = 2;
    }
}
