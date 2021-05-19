package com.vikko.demo.suanfa.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/19 14:10
 * @Description:
 */
public class FindPoisonedDuration {

	public static void main(String[] args) {
		int[] a = {1,5};
		int poisonedDuration = findPoisonedDuration2(a, 10);
		System.out.println(poisonedDuration);
	}

	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		int i = 0,  len = timeSeries.length, res = 0;
		if(len ==0 || duration == 0){
			return 0;
		}
		while (i < len-1){
			res += Math.min(timeSeries[i+1]- timeSeries[i], duration);
			i++;
		}
		return res + duration;
	}

	public static int findPoisonedDuration2(int[] timeSeries, int duration) {
		int i = 0,  len = timeSeries.length, res = len * duration;
		if(len ==0 || duration == 0){
			return 0;
		}
		while (i<len-1){
			int diff = timeSeries[i + 1] - timeSeries[i] - duration;
			if(diff < 0){
				res += diff;
			}
			i++;
		}
		return res;
	}

}
