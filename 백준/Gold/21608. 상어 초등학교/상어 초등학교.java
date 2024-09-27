import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int[][] square;
    static HashMap<Integer, Set<Integer>> map = new HashMap<>();
    static int n;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        square = new int[n][n];

        for(int i = 0; i<n*n; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            HashSet set = new HashSet<>();
            for(int j = 0; j<4; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            map.put(key, set);
            putStudentMap(key);
        }

        int sum = 0;
        for(int i=0;i<square.length;i++) {
            for(int j=0;j<square.length;j++) {

                int count = 0;
                Integer friends[] = map.get(square[i][j]).toArray(new Integer[0]);
                for(int k=0;k<4;k++) {
                    int nextY=i+dy[k];
                    int nextX=j+dx[k];
                    if(nextY<0||nextX<0||nextY>=square.length||nextX>=square.length)
                        continue;
                    int now = square[nextY][nextX];

                    //상,하,좌,우가 친구면 count 증가
                    for(int p=0;p<4;p++)
                        if(now == friends[p]) count++;

                }
                //count 개수에 따라 sum 증가
                switch(count) {
                    case 1: sum += 1; break;
                    case 2: sum += 10; break;
                    case 3: sum += 100; break;
                    case 4: sum += 1000; break;
                }


            }
        }

        System.out.println(sum);

    }

    private static void putStudentMap(int key) {
        Set<Integer> friends = map.get(key);

        ArrayList<Integer[]> list = new ArrayList<>();
        for(int i=0;i<square.length;i++) {
            for(int j=0;j<square.length;j++) {
                int friendsCount = 0;
                int emptyCount = 0;
                for(int k=0;k<4;k++) {
                    int nextY=i+dy[k];
                    int nextX=j+dx[k];
                    if(nextY<0||nextX<0||nextY>=square.length||nextX>=square.length)
                        continue;
                    int now = square[nextY][nextX];
                    if(friends.contains(now))
                        friendsCount++;
                    if(now==0)
                        emptyCount++;

                }
                list.add(new Integer[]{friendsCount, emptyCount, i, j});

            }
        }

        Collections.sort(list, (n1, n2) -> {
            if(n1[0]<n2[0]) return 1;
            else if(n1[0]==n2[0]) {
                if(n1[1]<n2[1]) return 1;
                else if(n1[1]==n2[1]) {
                    if(n1[2]>n2[2]) return 1;
                    else if(n1[2]==n2[2]) {
                        if(n1[3]>n2[3]) return 1;
                    }

                }
            }
            return -1;
        });

        for(int i=0;i<list.size();i++) {
            int y = list.get(i)[2];
            int x = list.get(i)[3];
            if(square[y][x]==0) {
                square[y][x] = key;
                return;
            }

        }
    }
}