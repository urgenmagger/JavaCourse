package ru.job4j.comparator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void convert() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        User user = new User("Basil", 99);
        User userOne = new User("Thomas", 98);
        User userTwo = new User("John", 97);
        list.add(user);
        list.add(userOne);
        list.add(userTwo);
        Set<User> result = sort.sort(list);
        assertThat(result.iterator().next(), is(userTwo));
    }
}

