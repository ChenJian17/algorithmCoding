package layOffDays.tesla;

import netscape.security.UserTarget;
import sun.tools.jar.resources.jar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays.tesla
 * @Author: Joker
 * @CreateTime: 2023-04-03 21:50
 * @Description:
 */
public class Solution {
    public int solution(int[] A) {
        // Implement your solution here

        Arrays.sort(A);
        if (A[0] != 1)
            return 1;
        int count = A[0];
        for (int i = 1; i<A.length; i++){
            int gap = A[i]-A[i-1];
            if (gap > 1){
                return A[i-1]+1;
            }
        }
        return A[A.length-1]+1;
    }

    public int solution1(int[] A) {
        // Implement your solution here
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i<A.length; i++){
            sum += A[i];
            ans += map.getOrDefault(sum-0,0);
            int num = map.getOrDefault(sum, 0);
            map.put(sum, num+1);
        }
        return ans > 100000 ? -1 :ans;
    }

    public int solution(String S) {
        // Implement your solution here
        int count = 0, res = 0;
        for (int i = 0; i<S.length(); i++){
            if (S.charAt(i) == 'a'){
                if (++count > 3){
                    return -1;
                }
            }else {
                if (count > 0){
                    res += 2-count;
                }
                if (count == 0){
                    res += 2;
                }
                count = 0;
            }
        }

        return S.charAt(S.length()-1) != 'a' ? res+2 : res;
    }

    static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行");
//                try {
//                    while (flag) {
//                        Thread.sleep(10000);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    System.out.println(flag);
//                    System.out.println("子线程退出啦");
//                }

                while (flag) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();

        flag = false;
        Thread.sleep(5000);
        thread.join();
        System.out.println("正常退出");
        }

    }


