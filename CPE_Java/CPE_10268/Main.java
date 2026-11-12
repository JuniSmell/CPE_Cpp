import java.io.*;
import java.util.*;

/**
 * CPE 10268 - 多項式微分求值 (498-bis)
 *
 * 每組測資兩行：
 *   第一行：x 的值
 *   第二行：係數 a0 a1 ... an（由最高次項開始）
 * 輸出多項式微分後在 x 的值。
 *
 * 做法：霍纳法則 (Horner's rule)
 *   f'(x) = [[a0*n*x + a1*(n-1)]*x + a2*(n-2)]*x + ... + a(n-1)*1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;           // 跳過空行
            long x = Long.parseLong(line);

            String coefLine = br.readLine();
            if (coefLine == null) break;
            StringTokenizer st = new StringTokenizer(coefLine);
            int cnt = st.countTokens();
            long[] a = new long[cnt];
            for (int i = 0; i < cnt; i++) a[i] = Long.parseLong(st.nextToken());

            int n = cnt - 1;                        // 多項式次數
            long res = 0;
            for (int i = 0; i < n; i++) {
                res = res * x + a[i] * (n - i);
            }
            out.append(res).append('\n');
        }
        System.out.print(out);
    }
}
