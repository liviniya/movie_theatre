package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Oksana_Moroz on 3/1/2017.
 */
public class AuditoriumServiceImpl implements AuditoriumService {

    private Properties properties;

    private Set<Auditorium> auditoriums;

    private void init() {
        auditoriums = new HashSet<>();

        int quantity = Integer.valueOf(properties.getProperty("quantity"));
        for (int i = 1; i <= quantity; i++) {
            Auditorium auditorium = new Auditorium();
            auditorium.setName(properties.getProperty("name" + i));
            auditorium.setNumberOfSeats(Long.valueOf(properties.getProperty("numberOfSeats" + i)));
            auditorium.setVipSeats(parseVipSeats(properties.getProperty("vipSeats" + i)));
            auditoriums.add(auditorium);
        }
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriums.stream()
                .filter(a -> Objects.equals(a.getName(), name))
                .findAny()
                .orElse(null);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Set<Long> parseVipSeats(String vipSeatsStr) {
        Set<Long> vipSeats = new HashSet<>();
        Arrays.stream(vipSeatsStr.split(","))
                .filter(s -> !s.isEmpty())
                .map(s -> Long.valueOf(s))
                .forEach(s -> vipSeats.add(s));
        return vipSeats;
    }

    void setAuditoriums(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }
}
