package com.andyfan.sort;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author andyFan
 * @since 2019年03月09日
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer a[] = {3, 5, 1, 6, 8, 0, 11, 2, 3, 1, 9};

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length -1 - i; j++) {
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
}
