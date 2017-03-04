package ua.epam.spring.hometask.service.impl;

import org.junit.Before;
import org.junit.Test;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public class AuditoriumServiceImplTest {

    private AuditoriumServiceImpl auditoriumService;

    @Before
    public void init() {
        auditoriumService = new AuditoriumServiceImpl();
        auditoriumService.setAuditoriums(createAuditoriums());
    }

    @Test
    public void testGetByName() {
        Auditorium found = auditoriumService.getByName("Green");
        assertNotNull(found);
    }

    @Test
    public void testGetByNotExistedName() {
        Auditorium found = auditoriumService.getByName("Black");
        assertNull(found);
    }

    @Test
    public void testGetByEmptyName() {
        Auditorium found = auditoriumService.getByName("");
        assertNull(found);
    }

    private static Set<Auditorium> createAuditoriums() {
        Set<Auditorium> auditoriums = new HashSet<>();
        auditoriums.add(createAuditorium("Red", 50l, 41l, 42l, 43l));
        auditoriums.add(createAuditorium("Green", 10l, 8l, 9l, 10l));
        return auditoriums;
    }

    private static Auditorium createAuditorium(String name, Long numberOfSeats, Long...vipSeats) {
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setNumberOfSeats(numberOfSeats);
        auditorium.setVipSeats(Arrays.stream(vipSeats).collect(Collectors.toSet()));
        return auditorium;
    }
}
