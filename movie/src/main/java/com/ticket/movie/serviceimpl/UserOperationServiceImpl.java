package com.ticket.movie.serviceimpl;

import com.ticket.movie.model.User;
import com.ticket.movie.repository.UserInfoRepository;
import com.ticket.movie.service.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserOperationServiceImpl implements UserOperationService {


    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public User userRegistration(User user) {
        return userInfoRepository.insert(user);
    }

    @Override
    public List<User> getRegisteredUser() {
        return userInfoRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userInfoRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userInfoRepository.delete(user);
    }


}
