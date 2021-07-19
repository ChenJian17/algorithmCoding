package com.chenjian.java;

import java.util.Scanner;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: com.chenjian.java
 * @Author: Joker
 * @CreateTime: 2021-07-18 17:05
 * @Description: 笔试
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();
        String[] strArr = input.split(",");
        int[] number = new int[strArr.length];
        for (int i=0; i<number.length; i++){
            number[i] = Integer.parseInt(strArr[i]);
        }
        int[] res = fun(number);
        for (int i=0; i<res.length; i++){
            System.out.print(res[i]+",");
        }


    }

    public static int[] fun(int[] num){
        if (num[num.length-1] < 9){
            num[num.length-1] += 1;
            return num;
        }
        for (int i=num.length-1; i>=0; i--){
            if (num[i]+1 == 10)
                num[i] = 0;
            else {
                num[i] = num[i]+1;
                break;
            }
        }

        if (num[0] == 0){
            int[] res = new int[num.length+1];
            res[0] = 1;
            for (int i=0; i<num.length; i++)
                res[i+1] = num[i];
            return res;
        }
        return num;

    }
}
