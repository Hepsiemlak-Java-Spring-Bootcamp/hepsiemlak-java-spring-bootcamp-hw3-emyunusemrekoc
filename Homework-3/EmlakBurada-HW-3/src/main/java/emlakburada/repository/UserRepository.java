package main.java.emlakburada.repository;

import emlakburada.dto.response.UserResponse;
import emlakburada.model.Advert;
import emlakburada.model.User;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public User saveUser(User user) {

        userList.add(user);
        System.out.println(user.toString());

        return user;
    }

    public List<User> findAll() {

        return userList;
    }

    public User findByUserId(int userId) {
        return userList.stream().filter(user -> user.getId() == userId).findAny().orElse(new User());
    }


}
