package strings;

import org.junit.Test;
import strings.utils.OurString;

import static org.junit.Assert.*;

public class MSDQuickSortTest {

    OurString[] input = {new OurString("ABC"), new OurString("BCA"), new OurString("DFA"),
            new OurString("FBB"), new OurString("WDSFA"), new OurString("A"),
            new OurString("TABCA"), new OurString("ABA"), new OurString("BAB")};

    OurString[] expected = {new OurString("A"), new OurString("ABA"), new OurString("ABC"),
            new OurString("BAB"), new OurString("BCA"), new OurString("DFA"),
            new OurString("FBB"), new OurString("TABCA"), new OurString("WDSFA")};

    private MSDQuickSort msdQuickSort = new MSDQuickSort(input);

    @Test
    public void sort() {
        msdQuickSort.sort(0, input.length - 1, 0);

        assertArrayEquals(expected, input);
    }
}