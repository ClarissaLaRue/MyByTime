package com.example.mybytime.db.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.mybytime.db.entities.ActivityType;
import com.example.mybytime.db.entities.Gender;
import com.example.mybytime.db.entities.PartyType;
import com.example.mybytime.db.entities.Person;
import com.example.mybytime.db.helpers.DBHelper;

import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.mybytime.db.helpers.DBHelper.persistDate;

public class DatabaseAdapter implements IPersonAdapter {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context) {
        dbHelper = new DBHelper(context.getApplicationContext());
    }

    public DatabaseAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private Cursor getAllEntries() {
        String[] columns = new String[]{DBHelper.KEY_ID, DBHelper.KEY_Age, DBHelper.KEY_PartyType, DBHelper.KEY_Gender, DBHelper.KEY_ActivityType, DBHelper.KEY_Amount, DBHelper.KEY_StartDate,DBHelper.KEY_EndDate};
        return database.query(DBHelper.TABLE_Person, columns, null, null, null, null, null);
    }


    public Person getPerson(int id) throws ParseException {
        Person person = null;
        String query = String.format("SELECT * FROM %s WHERE %s=?", DBHelper.TABLE_Person, DBHelper.KEY_ID);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});

        if(cursor.moveToFirst()){
            int age = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_Age));
            String gender = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_Gender));
            Date startDate = new Date(cursor.getLong(cursor.getColumnIndex(DBHelper.KEY_StartDate)));
            Date endDate = new Date(cursor.getLong(cursor.getColumnIndex(DBHelper.KEY_EndDate)));
            String activityType = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_ActivityType));
            int amount = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_Amount));
            String partyType = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PartyType));
            person = new Person(id, age, Gender.valueOf(gender), startDate, endDate, ActivityType.valueOf(activityType), amount, PartyType.valueOf(partyType));
        }
        cursor.close();
        return  person;
    }

    @Override
    public List<Person> getPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        Cursor cursor = getAllEntries();
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_ID));
                int age = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_Age));
                String gender = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_Gender));
                Date startDate = new Date(cursor.getLong(cursor.getColumnIndex(DBHelper.KEY_StartDate)));
                Date endDate = new Date(cursor.getLong(cursor.getColumnIndex(DBHelper.KEY_EndDate)));
                String activityType = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_ActivityType));
                int amount = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_Amount));
                String partyType = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PartyType));
                persons.add(new Person(id, age, Gender.valueOf(gender), startDate, endDate, ActivityType.valueOf(activityType), amount, PartyType.valueOf(partyType)));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return  persons;
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DBHelper.TABLE_Person);
    }

    public long insert(Person person){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.KEY_Age, person.getAge());
        cv.put(DBHelper.KEY_Gender, person.getGender().toString());
        cv.put(DBHelper.KEY_StartDate, persistDate(person.getStartDateTime()));
        cv.put(DBHelper.KEY_EndDate, persistDate(person.getEndDateTime()));
        cv.put(DBHelper.KEY_ActivityType, person.getActivityType().toString());
        cv.put(DBHelper.KEY_Amount, person.getAmount());
        cv.put(DBHelper.KEY_PartyType, person.getPartyType().toString());

        return  database.insert(DBHelper.TABLE_Person, null, cv);
    }

    public long delete(int userId){

        String whereClause = "_id = ?";
        String[] whereArgs = new String[]{String.valueOf(userId)};
        return database.delete(DBHelper.TABLE_Person, whereClause, whereArgs);
    }

    public long update(Person person){

        String whereClause = DBHelper.KEY_ID + "=" + String.valueOf(person.getId());
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.KEY_Age, person.getAge());
        cv.put(DBHelper.KEY_Gender, person.getGender().toString());
        cv.put(DBHelper.KEY_StartDate, persistDate(person.getStartDateTime()));
        cv.put(DBHelper.KEY_EndDate, persistDate(person.getEndDateTime()));
        cv.put(DBHelper.KEY_ActivityType, person.getActivityType().toString());
        cv.put(DBHelper.KEY_Amount, person.getAmount());
        cv.put(DBHelper.KEY_PartyType, person.getPartyType().toString());
        return database.update(DBHelper.TABLE_Person, cv, whereClause, null);
    }
}
