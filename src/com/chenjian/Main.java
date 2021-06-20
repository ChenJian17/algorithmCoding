package com.chenjian;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        final ThreadLocal<Main> holder = ThreadLocal.withInitial(Main::new);
        new Main().largestOddNumber("239537672423884969653287101");
    }


    public String largestOddNumber(String num) {
        long sum = Long.valueOf(num);
        if ((sum&1) == 1)
            return num;
        long res = 0;
        for (int i = 0; i<num.length(); i++){
            for (int j=i+1; j<num.length(); j++){
                String str = num.substring(i,j);
                long tmp = Long.valueOf(str);
                if ((tmp&1) == 1){
                    res = Math.max(res, tmp);
                }
            }
        }
        if (res == 0)
            return "";
        else
            return String.valueOf(res);



    }

//    public void backtracking(String num, int index){
//        if (index == num.length()){
//            String str = num.substring(index);
//            int tmp = Integer.valueOf(str);
//            if (((tmp >> 1)&1) == 1){
//                res = Math.max(res, tmp);
//            }
//            return;
//        }
//
//
//        for (int i = index; i<num.length();i++){
//
//        }
//        backtracking(num, index);
//        backtracking(num, index+1);
//
//
//    }
}
