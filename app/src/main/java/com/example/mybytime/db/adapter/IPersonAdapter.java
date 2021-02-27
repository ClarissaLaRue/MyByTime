package com.example.mybytime.db.adapter;

import com.example.mybytime.db.entities.Activity;
import com.example.mybytime.db.entities.Person;

import java.text.ParseException;
import java.util.List;

public interface IPersonAdapter {
    DatabaseAdapter open();

    void close();

    Person getPerson(int id) throws ParseException;

    List<Person> getPersons();

    long getCount();

    long insert(Person person);

    long delete(int userId);

    long update(Person person);
}
