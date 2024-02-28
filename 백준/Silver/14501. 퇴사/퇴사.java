import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] time, pay, did;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        time = new int[n+1];
        pay = new int[n+1];
        did = new int[n+2];

        for(int i = 1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n; i>0; i--){
            if(i + time[i] > n+1){
                did[i] = did[i+1];
            }else{
                did[i] = Math.max(did[i+1], pay[i] + did[i + time[i]]);
            }
        }

        System.out.println(did[1]);
    }
}