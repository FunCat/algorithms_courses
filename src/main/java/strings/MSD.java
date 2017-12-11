package strings;

import java.util.Arrays;
import strings.utils.OurString;

public class MSD {

    private static int c = 26;

    public static void msd(OurString[] a, int from, int to, int k, int K){

        int[] count = new int[c + 2];
        String[] temp = new String[to - from];

        for (int i = from; i < to; i++) {
            count[a[i].key(k) + 2]++;
        }

        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] += count[i];
        }

        for (int i = from; i < to; i++) {
            temp[count[a[i].key(k) + 1]++] = a[i].getValue();
        }

        for (int i = 0; i < temp.length; i++) {
            a[i + from].setValue(temp[i]);
        }

        if(k != K){
            for (int i = 0; i < count.length - 1; i++) {
                msd(a, count[i], count[i + 1], k + 1, K);
            }
        }
    }
}
