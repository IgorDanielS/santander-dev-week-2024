package me.dio.service;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    List<User> findAll();
}
