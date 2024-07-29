package layOffDays.BitwiseXOR;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/23 21:47
 */
public class NumberComplement_476 {
    public static int findComplement(int num) {

        int s = -1;
        for (int i = 31; i>=0; i--) {
            if ((num >> i)  != 1) {
                s++;
            }else
                break;
        }

        int ans = 0;
        for (int i = 0; i<s; i++){
            if (((num >> i) & 1) == 0) {
                ans |= 1<<i;
            }
        }
        return ans;

    }

    public static int findComplement2(int num) {
        long tmp = 1;
        while (tmp <= num) {
            tmp = tmp << 1;
        }
        tmp = tmp-1;
        return (int)(num ^ tmp);
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));;
    }
}
