import java.util.*;

/**
 * CPE 305 - Joseph
 *
 * 有 k 個好人（編號 0~k-1）與 k 個壞人（編號 k~2k-1）圍成一圈，
 * 每次報數到 m 的人被殺掉。求最小的 m，使得所有壞人都比好人先死光。
 * 輸入 k (0 < k < 14)，k = 0 結束。
 *
 * 做法：對每個 k 從 m = k 開始往上試。
 *   第 i 次(i 從 0 開始)死的人，在「剩下 2k - i 人」中的位置為
 *       dead = (dead + m - 1) % (2k - i)
 *   若前 k 次內有人的位置 < k（即好人），這個 m 就失敗。
 *   先對 1~13 預先建表，之後查表輸出。
 */
public class Main {
    static boolean ok(int m, int k) {
        int dead = 0;
        for (int i = 0; i < k; i++) {
            dead = (dead + m - 1) % (2 * k - i);
            if (dead < k) return false;     // 好人先死了
        }
        return true;
    }

    public static void main(String[] args) {
        int[] table = new int[14];
        for (int k = 1; k < 14; k++) {
            for (int m = k; ; m++) {
                if (ok(m, k)) {
                    table[k] = m;
                    break;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            if (k == 0) break;
            out.append(table[k]).append('\n');
        }
        System.out.print(out);
    }
}
