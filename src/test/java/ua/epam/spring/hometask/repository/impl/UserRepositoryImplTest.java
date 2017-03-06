package ua.epam.spring.hometask.repository.impl;

import org.junit.Before;
import org.junit.Test;
import ua.epam.spring.hometask.domain.User;

import static org.junit.Assert.*;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public class UserRepositoryImplTest {

    private UserRepositoryImpl userRepository;

    @Before
    public void init() {
        userRepository = new UserRepositoryImpl();
        userRepository.save(createUser(1l, "Ivan", "Ivanov", "ivanov@mail.com"));
        userRepository.save(createUser(2l, "Petro", "Petrov", "petrov@bigmir.net"));
    }

    @Test
    public void testGetById() {
        User found = userRepository.getById(2l);
        assertNotNull(found);
    }

    @Test
    public void testGetByNotExistedId() {
        User found = userRepository.getById(3l);
        assertNull(found);
    }

    @Test
    public void testGetByEmptyId() {
        User found = userRepository.getById(null);
        assertNull(found);
    }

    @Test
    public void testGetByEmail() {
        User found = userRepository.getUserByEmail("petrov@bigmir.net");
        assertNotNull(found);
    }

    @Test
    public void testGetByNotExistedEmail() {
        User found = userRepository.getUserByEmail("sidorov@mail.net");
        assertNull(found);
    }

    @Test
    public void testGetByEmptyEmail() {
        User found = userRepository.getUserByEmail(null);
        assertNull(found);
    }

    private static User createUser(Long id, String firstName, String lastName, String email) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return user;
    }
}
