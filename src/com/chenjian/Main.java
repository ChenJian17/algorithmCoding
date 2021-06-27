package com.chenjian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        final ThreadLocal<Main> holder = ThreadLocal.withInitial(Main::new);
        System.out.println(new Main().wonderfulSubstrings("aba"));

    }

    public boolean canBeIncreasing2(int[] nums) {
        if (nums.length == 1)
            return true;
        if (nums.length == 2)
            return true;
        int flag = -1;
        int temp = nums[0];
        int others = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++){
            if (nums[i] > temp){
                temp = nums[i];
            }else {
                //大于等于 nums[i]<nums[i-1]
//                temp = nums[i-1];
//                temp = nums[i];
                if(i>=2)
                    others = nums[i-2];
                flag = i;
                break;
            }
        }
        if (flag == -1)
            return true;
        else
            return judge(nums, flag+1, nums[flag], others) || judge(nums, flag, nums[flag-1], others);

    }

    public boolean judge(int[] nums, int k, int temp, int others){
        if (nums[k] <= others)
            return false;
        for (int j = k; j<nums.length; j++){
            if (nums[j] <= temp)
                return false;
            else
                temp = nums[j];
        }
        return true;

    }

    long count = 0;

    public long wonderfulSubstrings(String word) {
        backtrace(word,"",0);
        return count;

    }

    public void backtrace(String word, String str,int index){
        if (!str.equals("")&& !isBeaut(str))
            count++;
        if (index == word.length())
            return;

        for (int i= index; i<word.length(); i++){
            backtrace(word,str+word.charAt(i),i+1);
        }

    }

    public boolean isBeaut(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        int cnt = 0;
        for (Map.Entry<Character,Integer> tmp: map.entrySet()){
            if (tmp.getValue()%2 != 0)
                cnt ++;
        }
        return cnt>1;

    }






}
