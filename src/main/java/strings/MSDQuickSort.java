package strings;

import strings.utils.OurString;

import java.util.Arrays;

public class MSDQuickSort {

    private static int c = 26;

    private OurString[] a;

    public MSDQuickSort(OurString[] a) {
        this.a = a;
    }

    public void sort(int from, int to, int d) {
        if (to - from < 1 || d > 5) return;
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

    public static void main(String[] args) {
        OurString[] a = {new OurString("ABC"), new OurString("BCA"), new OurString("DFA"),
                new OurString("FBB"), new OurString("WDSFA"), new OurString("A"),
                new OurString("TABCA"), new OurString("ABA"), new OurString("BAB")};

        MSDQuickSort msdQuickSort = new MSDQuickSort(a);
        msdQuickSort.sort(0, a.length - 1, 0);

        System.out.println(Arrays.toString(a));
    }
}
