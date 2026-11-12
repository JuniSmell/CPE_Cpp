import java.io.*;
import java.util.*;

/**
 * CPE 11987 - Almost Union-Find
 *
 * 初始集合 {1},{2},...,{n}，支援三種操作：
 *   1 p q : 合併 p 所在集合與 q 所在集合
 *   2 p q : 把 p 移到 q 所在集合（同集合則略過）
 *   3 p   : 輸出 p 所在集合的元素數量與元素總和
 *
 * 做法：並查集 + 「元素 -> 節點」對應表。
 *   "移動" 元素 p 時，不能直接從並查集中刪除節點，
 *   所以幫 p 配一個全新的節點 id，舊節點留在原集合當作「空殼」，
 *   同時把原集合的 count / sum 扣掉 p 的貢獻。
 *   節點總數最多 n + m，所以陣列開 n + m + 1。
 */
public class Main {
    static int[] parent;
    static int[] id;        // id[p] = 元素 p 目前對應的節點編號
    static int[] cnt;       // 以 root 為索引：集合內元素數量
    static long[] sum;      // 以 root 為索引：集合內元素總和

    static int find(int x) {
        int r = x;
        while (parent[r] != r) r = parent[r];
        while (parent[x] != r) {            // 路徑壓縮（迭代版，避免遞迴過深）
            int nx = parent[x];
            parent[x] = r;
            x = nx;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 1 << 16));
        StringBuilder out = new StringBuilder();

        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) st.nval;
            st.nextToken();
            int m = (int) st.nval;

            int size = n + m + 2;
            parent = new int[size];
            id = new int[n + 1];
            cnt = new int[size];
            sum = new long[size];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                id[i] = i;
                cnt[i] = 1;
                sum[i] = i;
            }
            int next = n + 1;               // 下一個可用的新節點編號

            while (m-- > 0) {
                st.nextToken();
                int cmd = (int) st.nval;
                st.nextToken();
                int p = (int) st.nval;
                if (cmd == 1) {
                    st.nextToken();
                    int q = (int) st.nval;
                    int rp = find(id[p]), rq = find(id[q]);
                    if (rp != rq) {
                        parent[rp] = rq;
                        cnt[rq] += cnt[rp];
                        sum[rq] += sum[rp];
                    }
                } else if (cmd == 2) {
                    st.nextToken();
                    int q = (int) st.nval;
                    int rp = find(id[p]), rq = find(id[q]);
                    if (rp != rq) {
                        cnt[rp]--;
                        sum[rp] -= p;
                        int node = next++;  // 為 p 建立新節點並加入 q 的集合
                        parent[node] = rq;
                        id[p] = node;
                        cnt[rq]++;
                        sum[rq] += p;
                    }
                } else {
                    int r = find(id[p]);
                    out.append(cnt[r]).append(' ').append(sum[r]).append('\n');
                }
            }
        }
        System.out.print(out);
    }
}
