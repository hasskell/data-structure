package org.alg;

import java.util.Arrays;

public class QuickSort {

    private int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public void quickSort() {
        int right = arr.length - 1;
        int left = 0;
        quickSort(left, right);
        System.out.println(Arrays.toString(arr));
    }

    private int partition(int left, int right) {
        int pivot = arr[right]; // element as pivot
        int i = left - 1; // point for smaller element

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, right);
        return i + 1;
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort(new int[]{3, 2, 1, 5, 6, 4, 6, 2, 1, 5});
        quickSort.quickSort();
    }
}
