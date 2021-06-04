package com.chenjian.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chenjian on 2021/3/27 15:58
 */
class Solution01 {
    public static void main(String[] args) throws IOException {
        // 初始化输入 参考 weiwei 哥提供的代码
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // w 背包能承担的最大负担
        int w = Integer.parseInt(bufferedReader.readLine());
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();
        String[] line1Array = line1.split(" ");
        String[] line2Array = line2.split(" ");
        // n 所有物品数量
        int n = line1Array.length;
        // weight 第 i 个物品的重量； value 第 i 个物品的价值
        int[] weight = new int[n];
        int[] value = new int[n];

    }

}
