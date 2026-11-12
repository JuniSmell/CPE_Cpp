import java.io.*;
import java.util.*;

/**
 * CPE 11946 - Code Number
 *
 * 密文中的數字代表字母：
 *   0:O  1:I  2:Z  3:E  4:A  5:S  6:G  7:T  8:B  9:P
 * 其餘字元（字母、空白、標點）保持不變。
 *
 * 輸入：第一行為篇數 T，之後每篇之間以空行分隔。
 * 輸出：每篇解碼後的明文，篇與篇之間空一行。
 */
public class Main {
    static final String MAP = "OIZEASGTBP";

    static String decode(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') sb.append(MAP.charAt(c - '0'));
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        StringBuilder out = new StringBuilder();
        int printed = 0;
        boolean inCase = false;       // 目前是否正在讀一篇（已讀到非空行）
        StringBuilder cur = new StringBuilder();

        while (printed < t) {
            line = br.readLine();
            boolean blank = (line == null) || line.trim().isEmpty();
            if (!blank) {
                inCase = true;
                cur.append(decode(line)).append('\n');
            } else if (inCase) {      // 一篇結束
                if (printed > 0) out.append('\n');
                out.append(cur);
                printed++;
                cur.setLength(0);
                inCase = false;
            }
            if (line == null) break;
        }
        System.out.print(out);
    }
}
