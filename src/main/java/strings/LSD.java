package strings;

import java.util.Arrays;
import strings.utils.OurString;

public class LSD {

    private static int c = 26;

    public static void lsd(OurString[] a, int K) {

        for (int k = 0; k < K; k++) {
            int[] count = new int[c + 2];
            String[] temp = new String[a.length];

            for (int i = 0; i < a.length; i++) {
                count[a[i].key(a[i].getValue().length() - k - 1) + 2]++;
            }

            for (int i = 0; i < count.length - 1; i++) {
                count[i + 1] += count[i];
            }

            for (int i = 0; i < a.length; i++) {
                temp[count[a[i].key(a[i].getValue().length() - k - 1) + 1]++] = a[i].getValue();
            }

            for (int i = 0; i < a.length; i++) {
                a[i].setValue(temp[i]);
            }
        }

    }

    public static void main(String[] args) {
        OurString[] a = {new OurString("ABC"), new OurString("BCA"), new OurString("DFA"),
            new OurString("FBB"), new OurString("WDSFA"), new OurString("A"),
            new OurString("TABCA"), new OurString("ABA"), new OurString("BAB")};

        lsd(a, 4);

        System.out.println(Arrays.toString(a));
    }

}
