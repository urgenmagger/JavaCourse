package ru.job4j.comparator;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User nameOne, User nameTwo) {
                return nameOne.getName().length() - nameTwo.getName().length();
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User nameOne, User nameTwo) {
                int firstSort = nameOne.getName().compareTo(nameTwo.getName());
                if (firstSort != 0) {
                    return firstSort;
                }
                return Integer.compare(nameOne.getAge(), nameTwo.getAge());
            }
        });
        return list;
    }

}
