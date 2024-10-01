import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] list;
//    static int[] ddx = {1, 1, 0, -1, -1, -1, 0, 1};
//    static int[] ddy = {0, 1, 1, 1, 0, -1, -1, -1};
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        list = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
//            if(i%20 == 0) st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            boolean isMale = st.nextToken().equals("1");

            int m = Integer.parseInt(st.nextToken());
            if(isMale){
                for(int l = m-1; l<n; l+=m) {
                    Reverse(l);
                }
            }else{
                Reverse(m-1);
                for(int l = 1; m-1+l<n && m-1-l >= 0; l++) {
                    if(list[m-1+l] == list[m-1-l]){
                        Reverse(m-1 + l);
                        Reverse(m-1 - l);
                    }else break;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(i%20 == 0 && i != 0) System.out.println();
            System.out.print(list[i]+" ");
        }
    }

    private static void Reverse(int l) {
        list[l] = (list[l] + 1) % 2;
    }
//    public static class Node {
//        int x, y;
//        Node(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }

}

