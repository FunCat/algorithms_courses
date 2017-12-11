package strings;

import org.junit.Test;
import strings.utils.OurString;

import static org.junit.Assert.*;

public class MSDTest {

    OurString[] input = {new OurString("ABC"), new OurString("BCA"), new OurString("DFA"),
            new OurString("FBB"), new OurString("WDSFA"), new OurString("A"),
            new OurString("TABCA"), new OurString("ABA"), new OurString("BAB")};

    OurString[] expected = {new OurString("A"), new OurString("ABA"), new OurString("ABC"),
            new OurString("BAB"), new OurString("BCA"), new OurString("DFA"),
            new OurString("FBB"), new OurString("TABCA"), new OurString("WDSFA")};

    @Test
    public void sort(){
        MSD.msd(input, 0, input.length, 0, 4);

        assertArrayEquals(expected, input);
    }
}