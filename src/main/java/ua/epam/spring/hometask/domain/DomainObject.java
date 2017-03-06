package ua.epam.spring.hometask.domain;

import java.util.Random;

/**
 * @author Yuriy_Tkach
 */
public class DomainObject {

    private Long id;

    private static final Random idGenerator = new Random();

    public DomainObject() {
        id = idGenerator.nextLong();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
