import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a <= 0) lowList.add(a);
            else highList.add(a);
        }
        
        Collections.sort(lowList);
        Collections.sort(highList);

        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k <= N; k++) {
            int actualLier = 0;
			actualLier += count(lowList, -k);
			actualLier += count(highList, k);

			if (k == actualLier) {
                answer++;
                sb.append(k).append(" ");
			}
        }

        System.out.println(answer);
        System.out.println(sb.toString());
    }

    static int count(List<Integer> list, int k) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > k) r = m;
            else l = m + 1;
        }
        return list.size() - l;
    }
}