package strings;

import org.junit.Test;
import strings.utils.OurString;

import static org.junit.Assert.*;

public class TrieTest {

    private Trie trie = new Trie();

    @Test
    public void get(){
        trie.put(new OurString("TEST"), 1);

        Integer test = trie.get(new OurString("TEST"));
        assertEquals(1, test.intValue());
    }

    @Test
    public void delete(){
        trie.put(new OurString("TEST"), 1);
        trie.put(new OurString("TESTS"), 2);
        trie.delete(new OurString("TEST"));

        assertEquals(null, trie.get(new OurString("TEST")));
    }

    @Test
    public void getKeyByIndex_SimpleTest(){
        trie.put(new OurString("TEST"), 1);
        trie.put(new OurString("TESTS"), 2);
        String keyByValue = trie.getKeyByValue(1);
        assertEquals("TEST", keyByValue);
    }

    @Test
    public void getKeyByIndex(){
        trie.put(new OurString("SHE"), 1);
        trie.put(new OurString("SELLS"), 2);
        trie.put(new OurString("SHELL"), 3);
        trie.put(new OurString("SEA"), 4);
        trie.put(new OurString("BY"), 5);
        trie.put(new OurString("THE"), 6);
        assertEquals("SHE", trie.getKeyByValue(1));
        assertEquals("SELLS", trie.getKeyByValue(2));
        assertEquals("SHELL", trie.getKeyByValue(3));
        assertEquals("SEA", trie.getKeyByValue(4));
        assertEquals("BY", trie.getKeyByValue(5));
        assertEquals("THE", trie.getKeyByValue(6));
    }

}