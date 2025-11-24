package model.dao;

import java.util.List;
import model.entities.User;

public interface UserDao {
    void insert(User obj);
    void update(User obj);
    void deleteById(String id);   // <-- ALTERADO!
    User findById(String id);     // <-- ALTERADO!
    List<User> findAll();
}
