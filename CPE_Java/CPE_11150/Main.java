import java.util.*;

/**
 * CPE 11150 - Cola
 *
 * 3 個空瓶換 1 瓶新汽水，可以向朋友多借 1 瓶空瓶（最後要還 1 瓶）。
 * 輸入 N，輸出最多能喝到幾瓶。
 *
 * 結論：答案 = N + N/2（整數除法）
 *   每 2 瓶自己的空瓶 + 1 瓶借來的 = 3 瓶，剛好換 1 瓶新的，
 *   喝完後那瓶新的空瓶就能拿去還給朋友。所以最多能多喝 N/2 瓶。
 *   例：N=8 -> 12；N=3 -> 4；N=1 -> 1。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            out.append(n + n / 2).append('\n');
        }
        System.out.print(out);
    }
}
