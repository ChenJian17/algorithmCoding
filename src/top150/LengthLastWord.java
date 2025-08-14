package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/11 17:54
 */
public class LengthLastWord {

    public int lengthOfLastWord(String s){
        int res = 0;
        int last = s.length()-1;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) != ' '){
                res ++;
            }else {
                if(i != last){

                    break;
                }
                last --;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "   fly me   to   the moon  ";
        LengthLastWord word = new LengthLastWord();
        word.lengthOfLastWord(str);

    }
}
