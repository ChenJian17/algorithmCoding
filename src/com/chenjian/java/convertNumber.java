package com.chenjian.java;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: com.chenjian.java
 * @Author: Joker
 * @CreateTime: 2021-07-18 16:24
 * @Description: 进制转换
 */
public class convertNumber {
    public String solve (int M, int N){
        if (M == 0) return "0";
        boolean flag = true;
        if (M < 0){
            M = -M;
            flag = false;
        }
        String con = "0123456789ABCDEF";
        StringBuilder res = new StringBuilder();
        while (M != 0){
            res.append(con.charAt(M%N));
            M = M/N;
        }
        if (!flag)
            res.append("-");
        return res.reverse().toString();

    }
}
