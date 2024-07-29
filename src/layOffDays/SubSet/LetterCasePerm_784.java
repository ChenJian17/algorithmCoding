package layOffDays.SubSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/4 22:49
 */
public class LetterCasePerm_784 {

    List<String> res = new ArrayList<>();
    String path = "";
    public List<String> letterCasePermutation(String s) {
        char[] input = s.toCharArray();
        dfs(0,input,path);
        return res;

    }

    private void dfs(int start, char[] input, String path) {
        if (path.length() == input.length){
            res.add(path);
            return;
        }
//        if (Character.isDigit(input[start])) {
//            path = path+input[start];
//            dfs(start+1,input,path);
//        } else if (Character.isLetter(input[start])) {
//            char low = Character.toLowerCase(input[start]);
//            char up = Character.toUpperCase(input[start]);
//
//            dfs(start+1, input, path+low);
//            dfs(start+1, input, path+up);
//        }

        dfs(start+1, input,path+input[start]);
        if (Character.isLetter(input[start])) {
            input[start] ^= 1 << 5;
            dfs(start+1,input,path+input[start]);
        }
    }


    public List<String> letterCasePermutation1(String s) {
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs1(charArray, 0, res);
        return res;
    }

    private void dfs1(char[] charArray, int index, List<String> res) {
        if (index == charArray.length){
            res.add(new String(charArray));
            return;
        }

        dfs1(charArray,index+1,res);
        if (Character.isLetter(charArray[index])){
            charArray[index] ^= 1<<5;
            dfs1(charArray,index+1,res);
        }
    }


    public static void main(String[] args) {
        String s = "a1b2";
        LetterCasePerm_784 letterCasePerm = new LetterCasePerm_784();
        List<String> fin = letterCasePerm.letterCasePermutation(s);
        for (String tmp: fin)
            System.out.println(tmp);
    }
}
