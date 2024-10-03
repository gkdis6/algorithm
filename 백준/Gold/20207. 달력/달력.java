import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, start, end;
    static int[] list;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        list = new int[366];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for(int j = start; j <= end; j++) {
                list[j]++;
            }
        }

        int sum = 0;
        int maxHeight = 0;
        int width = 0;
        for(int i = 0; i <= 365; i++) {
            if (list[i] == 0) {
                sum+=maxHeight*width;
                maxHeight = width = 0;
                continue;
            }
            width++;
            maxHeight = Math.max(maxHeight, list[i]);
        }
        sum += maxHeight*width;
        System.out.println(sum);


    }
}

