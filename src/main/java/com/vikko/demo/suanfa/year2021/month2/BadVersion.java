package com.vikko.demo.suanfa.year2021.month2;

/**
 * @author: vikko
 * @Date: 2021/2/8 19:32
 * @Description:
 */
public class BadVersion {

	public static int firstBadVersion(int n) {
		int lo = 1;
		int hi = n;

		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (isBadVersion(mid)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return hi;
	}

	public static Boolean isBadVersion(int a){
		return false;
	}
}
