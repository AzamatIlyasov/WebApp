package net.azma.webapp.storage;

import net.azma.webapp.model.Resume;

import java.util.Collection;

public class ListStorage extends AbstractStorage {



    @Override
    protected void doClear() {

    }

    @Override
    protected void doSave(Resume r) {

    }

    @Override
    protected void doUpdate(Resume r) {

    }

    @Override
    protected Resume doLoad(String uuid) {
        return null;
    }

    @Override
    protected void doDelete(String uuid) {

    }

    @Override
    public Collection<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
