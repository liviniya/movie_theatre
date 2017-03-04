package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public interface UserRepository extends AbstractDomainObjectRepository<User> {

    /**
     * Finding user by email
     * 
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    @Nullable User getUserByEmail(@Nonnull String email);

}
