import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int counter = 0;
		for(int i = 0; i<n; i++) {
			int find = arr[i];
			int point = 0;
			int point2 = n-1;
			while(point<point2) {
				if(arr[point] + arr[point2] == find) {
					if(point != i && point2 != i) {
						counter++;
						break;
					}else if(point == i) point++;
					else if(point2 == i) point2--;
				}else if(arr[point] + arr[point2] < find) point++;
				else point2--;
			}
		}
		System.out.println(counter);
		return;
    }
}