package net.azma.webapp.storage;

import net.azma.webapp.model.Resume;

import java.util.Collection;
import java.util.logging.Logger;

public abstract class AbstractStorage implements IStorage {
    protected Logger logger = Logger.getLogger(getClass().getName());


    @Override
    public void clear() {
        logger.info("Delete all resumes.");
        doClear();
    }

    protected abstract void doClear();

    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid=" + r.getUuid());
        // TODO try to move here exception treatment
        doSave(r);
    }

    protected abstract void doSave(Resume r);

    @Override
    public void update(Resume r) {
        logger.info("Update resume with uuid=" + r.getUuid());
        // TODO try to move here exception treatment
        doUpdate(r);
    }

    protected abstract void doUpdate(Resume r);

    @Override
    public Resume load(String uuid) {
        logger.info("Load resume with uuid=" + uuid + ".");
        // TODO try to move here exception treatment
        return doLoad(uuid);
    }

    protected abstract Resume doLoad(String uuid);


    @Override
    public void delete(String uuid) {
        logger.info("Delete resume with uuid=" + uuid + ".");
        // TODO try to move here exception treatment
        doDelete(uuid);
    }

    protected abstract void doDelete(String uuid);


    public abstract Collection<Resume> getAllSorted();

}
