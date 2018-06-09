package com.test.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 0, 1, 9};
        new SelectSort().sort(array);
        System.out.println(array);
    }


    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = getMin(array, i);
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public int getMin(int[] array, int start) {
        int min = start;
        for (int i = start; i < array.length; i++) {
            if(array[i] < array[min]) {
                min =  i;
            }
        }
        return min;
    }
}
