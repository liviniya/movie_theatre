package ua.epam.spring.hometask.domain;

import java.util.Random;

/**
 * @author Yuriy_Tkach
 */
public class DomainObject {

    private Long id;

    private static Long idCounter = 0l;

    public DomainObject() {
        id = ++idCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
