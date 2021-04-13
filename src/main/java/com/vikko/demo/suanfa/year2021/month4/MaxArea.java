package com.vikko.demo.suanfa.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/12 11:35
 * @Description:
 */
public class MaxArea {

	public static void main(String[] args) {
		int[] arr = {1,2,4,3};
		System.out.println(maxArea2(arr));
	}

	public static int maxArea(int[] height){

		int l =0, r = height.length-1,max = 0;
		while (l < r){
			max = Math.max(max, Math.min(height[l],height[r]) * (r - l));
			//todo 这里其实可以记录下height[l],height[r]的值，用while循环体里去移动指针,空间换时间
			if(height[l] < height[r]){
				l++;
			}else {
				r--;
			}
		}
		return max;
	}


	public static int maxArea2(int[] height){

		int l =0, r = height.length-1,max = 0;
		while (l < r){
			int lVal= height[l];
			int rVal = height[r];
			max = Math.max(max, Math.min(lVal, rVal) * (r - l));
			//todo 这里其实可以记录下height[l],height[r]的值，用while循环体里去移动指针
			if(lVal <= rVal){
				while (l < r && height[l] <= lVal){
					l++;
				}
			}else {
				while (l < r && height[r] <= rVal){
					r--;
				}
			}
		}
		return max;
	}

}
