package net.azma.webapp.storage;

import net.azma.webapp.model.Resume;

import java.util.Collection;

public interface IStorage {
    void clear();

    void save(Resume r);

    void update(Resume r);

    void delete(String uuid);

    Resume load(String uuid);

    Collection<Resume> getAllSorted();

    int size();
}
