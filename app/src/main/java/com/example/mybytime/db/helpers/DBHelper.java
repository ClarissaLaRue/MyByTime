package com.example.mybytime.db.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyByTime";


    public static final String TABLE_Activity = "Activity";

    public static final String KEY_ID = "ID";
    public static final String KEY_Name = "Name";
    public static final String KEY_Description = "Description";
    public static final String KEY_AverageCheck = "AverageCheck";
    public static final String KEY_PartyType = "PartyType";
    public static final String KEY_Gender = "Gender";
    public static final String KEY_ActivityType = "ActivityType";
    public static final String KEY_Lat = "Lat";
    public static final String KEY_Lng = "Lng";
    public static final String KEY_StartDate = "StartDate";
    public static final String KEY_EndDate = "EndDate";


    public static final String TABLE_Person = "Person";
    public static final String KEY_Age = "Age";
    public static final String KEY_Amount = "Amount";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_Activity + " (" + KEY_ID + " integer primary key, " + KEY_Name + " text, " + KEY_Description  + " text, " +
                KEY_AverageCheck  + " real, " + KEY_PartyType  + " text, " + KEY_Gender  + " text, " + KEY_ActivityType  + " text, " + KEY_Lat  + " real, " + KEY_Lng  + " real, "  + KEY_StartDate  + " text, " + KEY_EndDate  + " text " + ");");

        db.execSQL("create table " + TABLE_Person + " (" + KEY_ID + " integer primary key, " + KEY_Age + " integer, " + KEY_PartyType  + " text, " +
                KEY_Gender  + " text, " + KEY_ActivityType  + " text, " + KEY_Amount + " text, " + KEY_StartDate  + " text, " + KEY_EndDate  + " text " + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_Activity);
        db.execSQL("drop table if exists " + TABLE_Person);

        onCreate(db);
    }

    public static Long persistDate(Date date) {
        if (date != null) {
            return date.getTime();
        }
        return null;
    }
}
