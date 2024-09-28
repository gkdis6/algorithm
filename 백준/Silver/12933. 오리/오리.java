import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    private static final char[] QUACK = {'q','u','a','c','k'};

    public static void main(String[] args) throws IOException{
        char[] arr = br.readLine().toCharArray();
        if (arr.length%5 != 0) {
            System.out.println(-1);
            return;
        }
        int remain = arr.length;
        int cnt = 0;
        while (remain != 0) {
            int pt = 0;
            int idx = 0;
            boolean chk = false;
            int[] tmp = new int[5];
            while (idx < arr.length) {
                if (arr[idx]==QUACK[pt]) {
                    tmp[pt++] = idx;
                    if (pt==5) {
                        chk = true;
                        remain-=5;
                        pt=0;
                        for (int i = 0; i < 5; i++) arr[tmp[i]] = '\0';
                    }
                }
                idx++;
            }
            if (chk) cnt++;
            else break;
        }
        System.out.println(remain==0 ? cnt : -1);
    }

}