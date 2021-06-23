package com.vikko.demo.algorithm.year2021.sort;

import java.util.Arrays;

/**
 * @author: vikko
 * @Date: 2021/5/26 14:06
 * @Description:
 */
public class AbSort {

	/**
	 * 冒泡
	 * @param array
	 */
	public static void test1(int[] array) {
		for(int i=1;i<array.length;i++) {
			for(int j=0;j<array.length-i;j++) {
				if(array[j]>array[j+1]) {
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 选择
	 * @param array
	 */
	public static void test2(int[] array) {
		int i,j,index;
		for(i=0;i<array.length;i++) {
			index=i;
			for(j=i+1;j<array.length;j++) {
				if(array[j]<array[index]) {
					index=j;
				}
			}
			int temp=array[i];
			array[i]=array[index];
			array[index]=temp;
		}
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 插入
	 * @param array
	 */
	public static void test3(int[] array) {
		int i,j,temp;
		for(i=1;i<array.length;i++) {
			temp=array[i];
			for(j=i-1;j>=0;j--) {
				if(temp>array[j]) {
					break;
				}else {
					array[j+1]=array[j];
				}
			}
			array[j+1]=temp;
		}
		System.out.println(Arrays.toString(array));
	}

}
