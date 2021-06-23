package com.vikko.demo.algorithm.year2021.month5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: vikko
 * @Date: 2021/5/26 18:14
 * @Description:
 */
public class WordBreak {

	public static void main(String[] args) {

	}

	/**
	 * offcial
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public boolean wordBreakSelf(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if(dp[j] && set.contains(s.substring(j,i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}



}
