package com.test.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] dks = {5, 2, 1};
        int[] array = {3, 4, 5, 6, 7, 0, 1, 9};
        new ShellSort().shellSort(array, dks);
        System.out.println(array);
    }

    public void shellSort(int[] array, int[] dks) {
        for (int i = 0; i < dks.length; i++) {
            sort(array, dks[i]);
        }
    }

    public void sort(int[] array, int dk) {
        for (int i = dk; i < array.length; i++) {
            if(array[i] < array[i - dk]) {
                int temp = array[i];
                int j = i - dk;
                while(j >= 0 && array[j] > temp) {
                    array[j + dk] = array[j];
                    j = j - dk;
                }
                array[j + dk] = temp;
            }
        }

    }
}
