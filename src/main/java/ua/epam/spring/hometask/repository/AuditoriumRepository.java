package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

/**
 * Created by Oksana_Moroz on 3/4/2017.
 */
public interface AuditoriumRepository {

    /**
     * Getting all auditoriums from the system
     * 
     * @return set of all auditoriums
     */
    @Nonnull Set<Auditorium> getAll();

    /**
     * Finding auditorium by name
     * 
     * @param name
     *            Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    @Nullable Auditorium getByName(@Nonnull String name);

}
