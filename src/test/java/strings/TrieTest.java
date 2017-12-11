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
        trie.delete(new OurString("TEXT"));
    }

}