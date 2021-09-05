package com.vikko.demo.algorithm.year2021.month9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    /**
     * 用双端队列。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i< s.length(); i++){
            if(queue.contains(s.charAt(i))){
                while(!queue.isEmpty() && queue.peekFirst() != s.charAt(i)){
                    queue.pollFirst();
                }
                queue.pollFirst();
            }
            queue.offerLast(s.charAt(i));
            res = Math.max(res, queue.size());
        }
        return res;
    }
}
