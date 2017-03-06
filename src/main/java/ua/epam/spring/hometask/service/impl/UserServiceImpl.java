package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by Oksana_Moroz on 3/1/2017.
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User save(@Nonnull User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public void remove(@Nonnull User user) {
        userRepository.remove(user);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userRepository.getById(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
