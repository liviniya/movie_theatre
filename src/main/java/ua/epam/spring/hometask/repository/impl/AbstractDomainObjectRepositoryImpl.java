package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.DomainObject;
import ua.epam.spring.hometask.repository.AbstractDomainObjectRepository;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Oksana_Moroz on 3/6/2017.
 */
abstract public class AbstractDomainObjectRepositoryImpl<T extends DomainObject>
        implements AbstractDomainObjectRepository<T> {

    protected Set<T> objects = new HashSet<>();

    @Override
    public T save(@Nonnull T object) {
        T existed = (T) getById(object.getId());

        if (existed == null) {
            objects.add(object);
            return object;
        } else {
            updateExistedObject(existed, object);
            return existed;
        }
    }

    @Override
    public void remove(@Nonnull T object) {
        objects.remove(object);
    }

    @Override
    public T getById(@Nonnull Long id) {
        return objects.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findAny()
                .orElse(null);
    }

    @Nonnull
    @Override
    public Collection<T> getAll() {
        return objects;
    }

    abstract protected void updateExistedObject(T existed, T object);
}
