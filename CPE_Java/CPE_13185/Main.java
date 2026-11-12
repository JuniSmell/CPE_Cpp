import java.util.*;

/**
 * CPE 13185 - Perfect, Deficient, Abundant
 *
 * 正整數 n 的「真因數和」(不含自己)：
 *   < n  -> deficient
 *   = n  -> perfect
 *   > n  -> abundant
 *
 * 輸入：先輸入測資組數，再依序輸入 n。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0 && sc.hasNextInt()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) sum += i;
            }
            if (sum < n) out.append("deficient\n");
            else if (sum == n) out.append("perfect\n");
            else out.append("abundant\n");
        }
        System.out.print(out);
    }
}
