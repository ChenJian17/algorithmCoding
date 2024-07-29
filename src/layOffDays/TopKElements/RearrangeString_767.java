package layOffDays.TopKElements;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/27 23:56
 */
public class RearrangeString_767 {
    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();

        int[] alphabetArr = new int[26];
        for (char c : arr) {
            alphabetArr[c-'a'] ++;
        }

        int len = s.length();
        int max = 0, alphabet = 0;

        for (int i = 0; i<alphabetArr.length; i++) {
            if (max < alphabetArr[i]) {
                max = alphabetArr[i];
                alphabet = i;
                if (max > ((len+1)>>1)){
                    return "";
                }
            }
        }

        char[] res = new char[len];
        int index = 0;
        while (alphabetArr[alphabet] -- > 0){
            res[index] = (char) (alphabet+'a');
            index += 2;
        }

        for (int i = 0; i<alphabetArr.length; i++) {
            while (alphabetArr[i] -- > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char)(i+'a');
                index +=2;
            }
        }

        return new String(res);

    }
}
