package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/27 18:08
 * @Description:
 */
public class FindUnsortedSubarray {

	/**
	 * 题目目标是求得可以满足排序一个子数组, 使得全数组为升序的最短子数组的长度;
	 * 解析题目要求, 我们可以知道, 要求的子数组需要满足的特征值:
	 * 子数组左边的所有元素, 值都要比子数组的最小元素要小;
	 * 子数组右边的所有元素, 值都要比子数组的最大元素要大;
	 * 根据步骤2中的分析, 我们可以把问题转化为一下模型: 分别求左右两个边界点, 使得右边界点右侧的所有元素值, 比边界内的最大值要大; 左边界点左侧的所有元素, 比边界内的最小值要小;
	 * 因此可以套用双指针的模型:
	 * 从左到右遍历, 只要碰到比已经遍历过路径内的最大值要小的元素, 则说明该元素需要被纳入到重排序的子数组中;
	 * 同理, 再从右往左遍历, 只要碰到比已经遍历过的路径内的最小值还要大的元素, 说明该元素也需要被纳入到重排序的子数组中;
	 * 此方法的时间复杂度为O(2n)
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray(int[] nums) {
		//双指针: 需要分别确认左右边界:
		int left= 0, right = 0;

		int max = Integer.MIN_VALUE;
		for(int i = 0; i<nums.length; i++){
			if(nums[i] >= max){
				max = nums[i];
			}else if(nums[i] < max){
				right = i;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = right; i>=0;i--){
			if(nums[i] <= min){
				min = nums[i];
			}else if(nums[i] > min){
				left = i;
			}
		}
		return right==left ? 0: right-left+1;
	}



}
