package layOffDays.BitwiseXOR;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/24 22:00
 */
public class FlippingImage_832 {

    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i<= image.length-1; i++) {
            int low = 0, high = image[i].length-1;
            while (low < high) {
                if (image[i][low] != image[i][high]){
                    low++;
                    high --;
                }else {
//                    image[i][low] = image[i][low] == 0 ? 1: 0;
//                    image[i][high] = image[i][high] == 0 ? 1: 0;
                    image[i][low] ^= 1;
                    image[i][high] ^= 1;
                    low++;
                    high --;
                }
            }
            if (low == high) {
//                image[i][low] = image[i][low] == 0 ? 1: 0;
                image[i][low] ^= 1;
            }
        }
        return image;

    }
}
