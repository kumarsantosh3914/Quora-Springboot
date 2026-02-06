package org.example.quoraspringboot.services;

import org.example.quoraspringboot.dtos.UserDTO;
import org.example.quoraspringboot.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void followTag(Long userId, Long tagId);
    User createUser(UserDTO userDTO);
    void deleteUser(Long id);
}
