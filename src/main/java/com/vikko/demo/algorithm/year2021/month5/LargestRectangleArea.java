package com.vikko.demo.algorithm.year2021.month5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: vikko
 * @Date: 2021/5/18 18:01
 * @Description:
 */
public class LargestRectangleArea {

	public static void main(String[] args) {
//		int[] a = {7,6,5,4,3};
//		int[] a = {1,1,1,3,1,1,1,1,5,1,1,1,1,1,1,2,1,1};
		int[] a = {2, 1, 5, 6, 2, 3};
		int i = largestRectangleArea(a);
		System.out.println(i);
	}

	public static int largestRectangleArea(int[] heights) {
		// 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
		int[] tmp = new int[heights.length + 2];
		System.arraycopy(heights, 0, tmp, 1, heights.length);

		Deque<Integer> stack = new ArrayDeque<>();
		int area = 0;
		for (int i = 0; i < tmp.length; i++) {
			// 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
			// 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
			// 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
			//当前高度小于栈顶的高度,while找到左边小于当前高度
			//self,当前值小，就把它pop，并计算，所以这个stack是单调递增的
			while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
				//n取栈顶的高度
				int h = tmp[stack.pop()];
				area = Math.max(area, (i - stack.peek() - 1) * h);
			}
			stack.push(i);
		}
		return area;
	}

}
