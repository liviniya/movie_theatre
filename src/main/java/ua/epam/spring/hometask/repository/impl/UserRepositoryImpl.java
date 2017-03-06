package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public class UserRepositoryImpl extends AbstractDomainObjectRepositoryImpl<User> implements UserRepository {

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return objects.stream()
                .filter(u -> Objects.equals(u.getEmail(), email))
                .findAny()
                .orElse(null);
    }

    @Override
    protected void updateExistedObject(User existed, User object) {
        existed.setFirstName(object.getFirstName());
        existed.setLastName(object.getLastName());
        existed.setEmail(object.getEmail());
    }
}
