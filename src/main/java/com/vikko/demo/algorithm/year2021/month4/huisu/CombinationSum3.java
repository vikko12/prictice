package com.vikko.demo.algorithm.year2021.month4.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vikko
 * @date 2021/9/5 13:26
 * @Description:
 */
public class CombinationSum3 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        list.clear();
        backtracking(k, n, 9);
        return res;
    }

    private void backtracking(int k, int n, int maxNum) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 因为不能重复，并且单个数字最大值是maxNum，所以sum最大值为
        // （maxNum + (maxNum - 1) + ... + (maxNum - k + 1)） == k * maxNum - k*(k - 1) / 2
        if (maxNum == 0
                || n > k * maxNum - k * (k - 1) / 2
                || n < (1 + k) * k / 2) {
            return;
        }
        list.add(maxNum);
        backtracking(k - 1, n - maxNum, maxNum - 1);
        list.remove(list.size() - 1);
        backtracking(k, n, maxNum - 1);
    }

}
