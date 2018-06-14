package ru.job4j.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Return a list of users containing key in any fields.
     *
     * @param key Key for search.
     * @return List users containing key.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i) != null && persons.get(i).getName().contains(key) || persons.get(i).getAddress().contains(key)
                    || persons.get(i).getPhone().contains(key) || persons.get(i).getSurname().contains(key)) {
                result.add(persons.get(i));
            }
        }
        return result;
    }
}
