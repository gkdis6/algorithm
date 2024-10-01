import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 7..
 */
public class Main {
    static int N, K, input[], group = 0, parent[], result[], value = 0, min[];
    static boolean visit[], finish[];
    static ArrayList<gg> gr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new int[N + 1];
        visit = new boolean[N + 1];
        finish = new boolean[N + 1];
        parent = new int[N + 1];
        result = new int[N + 1];
        result[0] = 1;
        gr = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) input[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                proc(i);
            }
        }
        Iterator<gg> iter = gr.iterator();
        while (iter.hasNext()) {
            gg item = iter.next();
            int flag[] = new int[N + 1];
            for (int i = item.cycle; i <= item.size; i++) {
                for (int k = 0; k + i <= K; k++) {{
                        if (result[k] == 1) flag[k + i] = 1;
                    }
                }
            }
            for (int t = 0; t <= K; t++) {
                if (flag[t] == 1) {
                    result[t] = 1;
                    value = Math.max(value, t);
                }
            }
        }
        System.out.println(value);
    }
    static public void proc(int idx) {
        if (visit[idx] && !finish[idx]) {
            int cnt = 0;
            for (int i = input[idx]; i != idx; i = input[i]) cnt++;
            gg item = new gg();
            item.cycle = ++cnt;
            item.size = 0;
            gr.add(item);
            parent[idx] = group++;
            return;
        }
        if (finish[idx]) return;
        visit[idx] = true;
        proc(input[idx]);
        parent[idx] = parent[input[idx]];
        gr.get(parent[idx]).size++;
        finish[idx] = true;
    }
    public static class gg {
        int cycle;
        int size;
    }

}