package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Oksana_Moroz on 3/1/2017.
 */
public class UserServiceImpl extends AbstractDomainObjectServiceImpl<User> implements UserService {

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return ((UserRepository) domainObjectRepository).getUserByEmail(email);
    }

}
