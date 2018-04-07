package net.azma.webapp.storage;

import net.azma.webapp.exceptions.WebAppException;
import net.azma.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

public class ArrayStorage extends AbstractStorage {
    private static final int LIMIT = 100;
    private int size = 0;
    private Resume[] arrayR = new Resume[LIMIT];


    @Override
    public void doClear() {
        Arrays.fill(arrayR, null);
        size = 0;
    }

    @Override
    protected void doSave(Resume r) {
        int idx = getIndex(r.getUuid());
        if (idx != -1) throw new WebAppException("Resume " + r.getUuid() + " alredy exist", r);
        arrayR[size++] = r;
    }

    @Override
    public void doUpdate(Resume r) {
        int idx = getIndex(r.getUuid());
        if (idx == -1) throw new WebAppException("Resume " + r.getUuid() + " not exist", r);
        arrayR[idx] = r;
    }

    @Override
    public Resume doLoad(String uuid) {
        int idx = getIndex(uuid);
        if (idx == -1) throw new WebAppException("Resume " + uuid + " not exist");
        return arrayR[idx];
    }

    @Override
    public void doDelete(String uuid) {
        int idx = getIndex(uuid);
        if (idx == -1) throw new WebAppException("Resume " + uuid + " not exist");
        int numMoved = size - idx - 1;
        if (numMoved > 0)
            System.arraycopy(arrayR, idx + 1, arrayR, idx,
                    numMoved);
        arrayR[--size] = null; // clear to let GC do its work

    }

    @Override
    public Collection<Resume> getAllSorted() {
        Arrays.sort(arrayR, 0, size);
        return Arrays.asList(Arrays.copyOf(arrayR, size));
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (arrayR[i] != null) {
                if (arrayR[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
