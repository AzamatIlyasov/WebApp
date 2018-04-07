package net.azma.webapp.storage;

import net.azma.webapp.exceptions.WebAppException;
import net.azma.webapp.model.Contact;
import net.azma.webapp.model.ContactType;
import net.azma.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayStorageTest {
    private Resume R1, R2, R3;
    private ArrayStorage storage = new ArrayStorage();

    @Before
    public void setUp() throws Exception {
        R1 = new Resume("Полное имя1", "location1");
        R1.addContact(new Contact(ContactType.PHONE, "1234656"));
        R2 = new Resume("Полное имя2", null);
        R2.addContact(new Contact(ContactType.MOBILE, "7891011"));
        R3 = new Resume("Полное имя3", null);
        R3.addContact(new Contact(ContactType.SKYPE, "Skype3"));

        storage.clear();
        storage.save(R2);
        storage.save(R1);
        storage.save(R3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        storage.clear();
        storage.save(R1);
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(1, storage.size());
    }

    @Test
    public void update() {
        R2.setFullName("UPDATED №2");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    public void load() {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @Test(expected = WebAppException.class)
    public void delete() {
        storage.delete(R1.getUuid());
        assertEquals(2, storage.size());
        assertEquals(null, storage.load(R1.getUuid()));
    }

    @Test
    public void getAllSorted() {
        Resume[] src = new Resume[] {R1, R2, R3};
        Arrays.sort(src);
        assertArrayEquals(src, storage.getAllSorted().toArray());
    }

    @Test
    public void size() {
        storage.clear();
        assertEquals(0, storage.size());
        storage.save(R2);
        assertEquals(1, storage.size());
    }
}