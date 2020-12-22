package com.ticket.movie.service;

import com.ticket.movie.model.User;

import java.util.List;

public interface UserOperationService {

    public User userRegistration(User user);

    public List<User> getRegisteredUser();

    public User updateUser(User user);

    public void deleteUser(User user);

}
