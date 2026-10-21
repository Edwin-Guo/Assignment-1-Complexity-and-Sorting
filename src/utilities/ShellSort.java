package utilities;

import java.util.Comparator;

public class ShellSort {

    public static <T extends Comparable<? super T>> void sort(
            T[] array, Comparator<? super T> comparator) {

        int n = array.length;

        // Start with a large gap, then make it smaller
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Compare elements that are gap positions apart
            for (int i = gap; i < n; i++) {

                T temp = array[i];
                int j = i;

                // Move smaller elements to the right
                while (j >= gap &&
                        compare(array[j - gap], temp, comparator) < 0) {

                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }
        }
    }

    private static <T extends Comparable<? super T>> int compare(
            T first, T second, Comparator<? super T> comparator) {

        if (comparator != null) {
            return comparator.compare(first, second);
        }

        return first.compareTo(second);
    }
}
