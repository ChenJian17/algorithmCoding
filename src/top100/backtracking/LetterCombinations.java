package top100.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/22 14:28
 */
public class LetterCombinations {


    List<String> res = new ArrayList<>();

    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){


        int[] numbers = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++){
            numbers[i] = digits.charAt(i) - '0';
        }

//        Map<Integer,List<Character>> map = new HashMap<>();
//        char tmp = 'a';
//        for (int i = 2; i<=9; i++){
//            List<Character> characters = new ArrayList<>();
//            int limt = 3;
//            if (i == 7 || i == 9){
//                limt = 4;
//            }
//            int j = 0;
//            while (j < limt){
//                characters.add(tmp);
//                tmp += 1;
//                j++;
//            }
//            map.put(i,characters);
//        }



        if (digits.equals(""))
            return List.of();
        DFS(0, digits, new StringBuilder());
        return res;

    }

    public void DFS(int index, String digits, StringBuilder sb){
        if (index >= digits.length()){
            res.add(sb.toString());
            return;
        }

        char ch = digits.charAt(index);
        int pos = ch - '0';
        String map_String = letter_map[pos];
        for (int i = 0; i<map_String.length(); i++){
            char c = map_String.charAt(i);
            sb.append(c);
            index += 1;
            DFS(index, digits,  sb);
            index -= 1;
            sb.deleteCharAt(sb.length()-1);
        }


    }



    public static void main(String[] args) {
        String dig = "23";
        LetterCombinations ob = new LetterCombinations();
        ob.letterCombinations(dig);

    }

}
