import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int boom1 = 0, boom2 = 0, boom3 = 0;
    static int[][] map;
    static Node[] list;
//    static int[] ddx = {1, 1, 0, -1, -1, -1, 0, 1};
//    static int[] ddy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int d,s;

        map = new int[n][n];
        list = new Node[n*n-1];


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        MakeList();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken())-1;
            s = Integer.parseInt(st.nextToken());

            Blizards(s, d);

            while(true) {
                while(true) {
                    if (!isEmpty()) break; // 빈칸이 없으면 이동 반복 종료
                    Move(); // 빈칸 채우기
                }
                if (!Explode()) break; // 폭발할 곳 없으면 전체 반복 종료
            }
            Change(); // 변화
        }

        System.out.println(boom1+2*boom2+3*boom3);
    }

    private static void Change() {
        int nowx = list[0].x;
        int nowy = list[0].y;
        int cnt = 1;
        int pre = map[nowy][nowx];
        int[] newBubbles = new int[list.length];
        int idx = 0;
        for (int i = 1; i < list.length - 1; i++) {
            nowx = list[i].x;
            nowy = list[i].y;
            if (pre == map[nowy][nowx]) {
                cnt++;
            } else {
                if (idx < newBubbles.length) {
                    newBubbles[idx++] = cnt;
                    newBubbles[idx++] = pre;
                }
                cnt = 1;
            }
            pre = map[nowy][nowx];
        }

        for (int i = 0; i < list.length - 1; i++) {
            map[list[i].y][list[i].x] = newBubbles[i];
        }
    }

    private static void Move() {
        for(int j=0;j<list.length-2;j++){
            int nowx = list[j].x;
            int nowy = list[j].y;
            if(map[nowy][nowx] == 0){
                int nextx = list[j +1].x;
                int nexty = list[j +1].y;
                map[nowy][nowx] = map[nexty][nextx];
                map[nexty][nextx] = 0;
            }
        }
    }

    private static boolean Explode() {
        boolean explodeFlag = false;
        int nowx = list[0].x;
        int nowy = list[0].y;
        int cnt = 1;
        int pre = map[nowy][nowx];
        for(int i=1;i<list.length-1;i++){
            nowx = list[i].x;
            nowy = list[i].y;
            if(pre == map[nowy][nowx]){
                cnt++;
            }else {
                if (cnt >= 4) {
                    for (int j = i - cnt; j < i; j++) {
                        int num = map[list[j].y][list[j].x];
                        if (num == 1) boom1++;
                        if (num == 2) boom2++;
                        if (num == 3) boom3++;
                        map[list[j].y][list[j].x] = 0;
                        explodeFlag = true;
                    }
                }
                cnt = 1;
            }
            pre = map[nowy][nowx];
        }
        return explodeFlag;
    }

    private static void Blizards(int s, int d) {
        int nowx = n/2;
        int nowy = n/2;
        for(int j = 0; j< s; j++){
            int x= nowx+dx[d];
            int y= nowy+dy[d];
            map[y][x] = 0;
            nowx = x;
            nowy = y;
        }
    }

    public static boolean isEmpty() {
        boolean empty = false;
        for (int i=0; i<list.length-1; i++) {
            int nowx = list[i].x;
            int nowy = list[i].y;
            if (empty && map[nowy][nowx]!=0) return true;
            if (!empty && map[nowy][nowx]==0) empty = true; // 0을 만났음
        }
        return false; // 종료
    }

    private static void MakeList(){
        int[] y = {1, 0, -1, 0};
        int[] x = {0, 1, 0, -1};

        int idx = 0;
        for (int size=1; size<=n/2; size++) { // N=7 -> 1, 2, 3
            int[] now = {n/2-size, n/2-size};
            for (int dir=0; dir<4; dir++) {
                for (int step=0; step<size*2; step++) {
                    now = new int[] {now[0] + x[dir], now[1] + y[dir]};
                    list[idx] = new Node(now[0], now[1]);
                    idx++;
                }
            }
        }
    }

    public static class Node {
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}

