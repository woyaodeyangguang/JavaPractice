package com.test.sort;


/**
 * 直接插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 0, 1, 9};
        new InsertSort().sort2(array);
        System.out.println(array);
    }


    public void sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                int j = i - 2;
                while(j >= 0 && array[j] > temp) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
    }

    public void sort2(int[] array) {
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i - 1]) {
                int temp = array[i];
                int j = i - 1;
                while(j >= 0 && array[j] > temp) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
    }
}
