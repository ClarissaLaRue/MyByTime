package com.example.mybytime.services;

import com.example.mybytime.db.entities.Person;

import java.util.List;

public interface IPersonService {
    void addPerson(Person person);

    Person getPerson(int id);

    List<Person> getPersons();
}
