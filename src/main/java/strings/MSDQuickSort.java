package strings;

import strings.utils.OurString;

import java.util.Arrays;
import java.util.Comparator;

public class MSDQuickSort {

    private static int c = 26;

    private OurString[] a;
    private int maxLength = 0;

    public MSDQuickSort(OurString[] a) {
        this.a = a;
        for (OurString anA : a) {
            if (maxLength < anA.getValue().length()) {
                maxLength = anA.getValue().length();
            }
        }
    }

    public void sort(int from, int to, int d) {
        if (to - from < 1 || d > maxLength) return;
        int low = from;
        int high = to;

        int index = a[from].key(d);

        for (int i = low; i <= high; ) {
            if (index < a[i].key(d)) {
                swap(i, high);
                high--;
            } else if (index > a[i].key(d)) {
                swap(i, low);
                low++;
                i++;
            } else {
                i++;
            }
        }
        sort(from, low - 1, d);
        if (index != -1) {
            sort(low, high, d + 1);
        }
        sort(high + 1, to, d);
    }

    private void swap(int from, int to) {
        OurString buf = a[from];
        a[from] = a[to];
        a[to] = buf;
    }
}
