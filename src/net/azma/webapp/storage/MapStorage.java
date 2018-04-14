package net.azma.webapp.storage;

import net.azma.webapp.model.Resume;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<String, Resume>();

    @Override
    protected void doClear() {
        mapResume.clear();
    }

    @Override
    protected void doSave(Resume r) {
        mapResume.put("uuid",r);
    }

    @Override
    protected void doUpdate(Resume r) {
        mapResume.replace(r.getUuid(), r);
    }

    @Override
    protected Resume doLoad(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        mapResume.remove(uuid);
    }

    @Override
    public Collection<Resume> getAllSorted() {
        return mapResume.values();
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
