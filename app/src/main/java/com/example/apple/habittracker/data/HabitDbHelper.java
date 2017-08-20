package com.example.apple.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.apple.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by justin on 2017/8/20.
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = HabitDbHelper.class.getSimpleName();
    public static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABIT_TABLE =  "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_MUSIC + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_MOVIE + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_SPORT + " INTEGER NOT NULL);";

        Log.i(LOG_TAG, "create db : " + SQL_CREATE_HABIT_TABLE);
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    public void insertHabit(String music, String movie, int sport){
        Log.i(LOG_TAG, "insertHabit");

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_MUSIC, music);
        values.put(HabitEntry.COLUMN_MOVIE, movie);
        values.put(HabitEntry.COLUMN_SPORT, sport);
        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    public void readHabit(){
        Log.i(LOG_TAG, "readHabit");

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_MUSIC,
                HabitEntry.COLUMN_MOVIE,
                HabitEntry.COLUMN_SPORT
        };

        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        try {
            if(cursor.getCount()>0){
                while (cursor.moveToNext()){
                    Log.i(LOG_TAG, "my habit: " + cursor.getInt(0) + ", " + cursor.getString(1) +
                    ", " + cursor.getString(2) + ", " + cursor.getInt(3));
                }
            }
        } finally {
            cursor.close();
        }
    }

    public void updateSportHabit(int sport){
        Log.i(LOG_TAG, "updateHabit");
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_SPORT, sport);

        db.update(HabitEntry.TABLE_NAME, values, null, null);
    }

    public void deleteHabitDB(Context context){
        Log.i(LOG_TAG, "deleteHabitDB");
        context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
