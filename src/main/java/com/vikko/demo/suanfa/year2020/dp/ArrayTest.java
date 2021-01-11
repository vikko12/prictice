package com.vikko.demo.suanfa.year2020.dp;

/**
 * @author vikko
 * @date 2020/6/23 14:20
 */
public class ArrayTest {
    public static void main(String[] args) {

//        int[] ints = runningSum(new int[]{1, 2, 3, 4});
//        for (int anInt : ints) {
//            System.out.print(anInt + ",");
//        }

        System.out.println(addBinary("111","101"));
    }
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            result[i] = sum + nums[i];
            sum += nums[i];
        }
        return result;
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int carry = 0;
        while (i>= 0 || j>= 0 ){
            sum = carry;
            if(i>= 0){
                sum += a.charAt(i) - '0';
            }
            if(j>= 0){
                sum += b.charAt(j) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }




}
