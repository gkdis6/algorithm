import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] ropes = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }
        
        Arrays.sort(ropes, Collections.reverseOrder());
        
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            int weight = ropes[i] * (i + 1);
            maxWeight = Math.max(maxWeight, weight);
        }
        
        System.out.println(maxWeight);
        sc.close();
    }
}