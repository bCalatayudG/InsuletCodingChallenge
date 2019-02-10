package com.aidl.aidlserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {

    private static DataSource instance = null;
    List<Person> personList = new ArrayList<>();

    public DataSource() {
    }

    //We make it a singleton
    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public void initPersonList() {
        personList.clear();
        personList.add(new Person("John" + getRandom(), getRandom(), "male"));
        personList.add(new Person("John" + getRandom(), getRandom(), "male"));
        personList.add(new Person("John" + getRandom(), getRandom(), "male"));
        personList.add(new Person("John" + getRandom(), getRandom(), "male"));
        personList.add(new Person("John" + getRandom(), getRandom(), "male"));

    }

    private String getRandom() {
        Random random = new Random();
        return String.valueOf(random.nextInt(100));
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
