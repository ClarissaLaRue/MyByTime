package com.example.mybytime.services;

import android.content.Context;

import com.example.mybytime.db.adapter.DatabaseAdapter;
import com.example.mybytime.db.adapter.IPersonAdapter;
import com.example.mybytime.db.entities.Person;

import java.text.ParseException;
import java.util.List;

public class PersonService implements IPersonService {

    private IPersonAdapter personAdapter;

    public PersonService(Context context) {
        personAdapter = new DatabaseAdapter(context);
    }

    @Override
    public void addPerson(Person person) {
        if(person == null){
            return;
        }
        try {
            personAdapter.open();
            if (person.getId() > 0) {
                personAdapter.update(person);
            } else {
                personAdapter.insert(person);
            }
            personAdapter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Person getPerson(int id) {
        Person person = null;
        try {
            person = personAdapter.getPerson(id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> getPersons() {
        personAdapter.open();
        List<Person> petList = personAdapter.getPersons();
        personAdapter.close();
        return petList;
    }
}
