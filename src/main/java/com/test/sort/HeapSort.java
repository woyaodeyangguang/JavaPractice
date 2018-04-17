package com.test.sort;

import java.util.Arrays;

/**
 * 堆排序.
 */
public class HeapSort {
  public static void main(String[] args) {
    int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    new HeapSort().sort(array);
    System.out.println(Arrays.toString(array));
  }


  public void sort(int[] array) {
    // 从第一个非叶子结点开始,从下往上,从右往左
    for (int i = array.length / 2 - 1; i >= 0 ; i--) {
      adjust(array, i, array.length);
    }
    for (int j = array.length - 1; j > 0 ; j--) {
      // 将堆顶元素与末尾元素进行交换
      swap(array, 0, j);
      // 重新调整堆
      adjust(array, 0, j);
    }
  }


  /**
   * 调整大顶堆.
   * @param array 数组.
   * @param i 最后一个非叶子结点.
   * @param length 长度.
   */
  public void adjust(int[] array, int i, int length) {
    int temp = array[i];
    for(int k = i * 2 + 1; k < length; k = 2 * k + 1) {
      // 找到左右孩子中较大的那个结点
      if(k + 1 < length && array[k + 1] > array[k]) {
        k++;
      }
      // 大于父亲结点时,将子结点的值付给父亲结点
      if(array[k] > temp) {
        array[i] = array[k];
        i = k;
      } else {
        break;
      }
    }
    // 将temp放到最终的位置
    array[i] = temp;
  }

  /**
   * 交换元素
   * @param array
   * @param i
   * @param j
   */
  public void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
