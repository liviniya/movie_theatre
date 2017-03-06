package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public class UserRepositoryImpl implements UserRepository {

    private Set<User> users = new HashSet<>();

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return users.stream()
                .filter(u -> Objects.equals(u.getEmail(), email))
                .findAny()
                .orElse(null);
    }

    @Override
    public User save(@Nonnull User newUser) {
        User existed = getById(newUser.getId());

        if (existed == null) {
            users.add(newUser);
            return newUser;
        } else {
            existed.setId(newUser.getId());
            existed.setFirstName(newUser.getFirstName());
            existed.setLastName(newUser.getLastName());
            existed.setEmail(newUser.getEmail());
            return existed;
        }
    }

    @Override
    public void remove(@Nonnull User user) {
        users.remove(user);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return users.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findAny()
                .orElse(null);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return users;
    }
}
