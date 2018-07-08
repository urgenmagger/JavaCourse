package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void convertListToMapTest() {
        List<User> list = new ArrayList<User>();
        User user = new User(10, "Basil", "NY");
        User userOne = new User(11, "John", "Moscow");
        User userTwo = new User(13, "Thomas", "London");
        list.add(user);
        list.add(userOne);
        list.add(userTwo);
        UserConvert map = new UserConvert();
        map.process(list);
        HashMap<Integer, User> mapUser = new HashMap<>();
        assertThat(mapUser.containsKey(10), is(mapUser.containsValue(user)));
        assertThat(mapUser.containsKey(11), is(mapUser.containsValue(userOne)));
    }
}
