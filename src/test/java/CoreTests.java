import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import own.nio.core.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CoreTests {

    static HashMap<String, String> database = new HashMap<>();

    @Test
    public void assertAdditionSucceedsTest(){
        Command comm = new ContactCreation();

        String[] contat = new String[]{"add", "aaa aaa", "555-222"};
        String[] contat1 = new String[]{"add", "kkk kkk", "777-666"};
        String[] contat2 = new String[]{"add", "sss hhh", "555-222"};

        comm.fulfill(contat, database);
        comm.fulfill(contat1, database);
        comm.fulfill(contat2, database);

        assertAll(
                () -> assertEquals(3, database.size()),
                () -> assertTrue(database.containsKey("aaa aaa")),
                () -> assertTrue(database.containsKey("kkk kkk")),
                () -> assertTrue(database.containsKey("sss hhh"))
        );
    }

    @Test
    public void assertUpdateSucceedsTest(){
        Command comm = new ContactUpdate();

        String[] contat = new String[]{"upd", "aaa aaa", "666-222"};
        String[] contat1 = new String[]{"upd", "kkk kkk", "888-666"};
        comm.fulfill(contat, database);
        comm.fulfill(contat1, database);

        assertAll(
                () -> assertEquals(3, database.size()),
                () -> assertTrue(database.containsKey("aaa aaa")),
                () -> assertTrue(database.containsKey("kkk kkk")),
                () -> assertTrue(database.containsKey("sss hhh")),
                () -> assertTrue(database.get("aaa aaa").equals("666-222")),
                () -> assertTrue(database.get("kkk kkk").equals("888-666")),
                () -> assertTrue(database.get("sss hhh").equals("555-222"))
        );
    }

    @Test
    public void assertDeletionSucceedsTest(){
        Command comm = new ContactRemoval();

        String[] contat = new String[]{"del", " aaa aaa"};
        String[] contat1 = new String[]{"del", "kkk kkk "};
        comm.fulfill(contat, database);
        comm.fulfill(contat1, database);

        assertAll(
                () -> assertEquals(1, database.size()),
                () -> assertFalse(database.containsKey(" aaa aaa")),
                () -> assertFalse(database.containsKey("kkk kkk ")),
                () -> assertTrue(database.containsKey("sss hhh"))
        );
    }
}
