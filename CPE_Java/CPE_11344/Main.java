import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * CPE 11344 - The Huge One
 *
 * 給一個超大整數 M (0 <= M <= 10^1000) 與一個集合 S (元素範圍 1~12)，
 * 若 M 可被 S 內「所有」元素整除，輸出 "M - Wonderful."，否則輸出 "M - Simple."
 *
 * 做法：用 BigInteger 取餘數判斷整除。
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder all = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) all.append(line).append(' ');
        StringTokenizer st = new StringTokenizer(all.toString());

        StringBuilder out = new StringBuilder();
        if (!st.hasMoreTokens()) return;
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0 && st.hasMoreTokens()) {
            String m = st.nextToken();
            BigInteger big = new BigInteger(m);
            int k = Integer.parseInt(st.nextToken());
            boolean wonderful = true;
            for (int i = 0; i < k; i++) {
                int d = Integer.parseInt(st.nextToken());
                if (big.mod(BigInteger.valueOf(d)).signum() != 0) wonderful = false;
            }
            out.append(m).append(wonderful ? " - Wonderful." : " - Simple.").append('\n');
        }
        System.out.print(out);
    }
}
