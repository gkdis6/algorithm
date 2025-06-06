import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        int max = 0;
        int total = 0;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            total += arr[i];
        }

        int left = max;
        int right = total;
        int result = total;

        while(left <= right){
            int mid = (left+right)/2;
            if(canCover(mid)){
                result = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }

        System.out.println(result);
    }

    static boolean canCover(int amount){
        int count = 1;
        int sum = 0;
        for(int item: arr){
            if(sum + item > amount){
                count++;
                sum = 0;
            }
            sum += item;
        }
        return count <= M;
    }
}