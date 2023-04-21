# MT

https://www.acmicpc.net/problem/10265
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {

    static int n, c, arr[], parent[], result[], group = 0;
    static boolean visited[], finish[];
    static ArrayList<Person> personList;
    static PriorityQueue<Integer> que = new PriorityQueue(Collections.reverseOrder());
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1];
        parent = new int[n+1];
        result = new int[n+1];
        visited = new boolean[n+1];
        finish = new boolean[n+1];
        personList = new ArrayList<>();
        result[0] = 1;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i<n+1; i++){
            if(visited[i]) continue;
            dfs(i);
        }

        // for(int i = 0; i<personList.size(); i++){
        //     que.add(personList.get(i).size);
        // }

        // int max = 0;
        // while(que.size() > 0){
        //     int cur = que.poll();
        //     if(c - max - cur >= 0) max = max + cur;
        // }
        // System.out.println(max);

        int value = 0;
        Iterator<Person> iter = personList.iterator();
        while (iter.hasNext()) {
            Person person = iter.next();
            int flag[] = new int[n + 1];
            for (int i = person.cycle; i <= person.size; i++) {
                for (int k = 0; k + i <= c; k++) {{
                        if (result[k] == 1) flag[k + i] = 1;
                    }
                }
            }
            for (int t = 0; t <= c; t++) {
                if (flag[t] == 1) {
                    result[t] = 1;
                    value = Math.max(value, t);
                }
            }
        }
        System.out.println(value);
    }

    public static void dfs(int i){
        if(visited[i] && !finish[i]){
            int cnt = 0;
            for(int j = arr[i]; j != i; j = arr[j]){
                cnt++;
            }
            Person person = new Person();
            person.cycle = ++cnt;
            person.size = 0;
            personList.add(person);
            parent[i] = group++;
            return;
        }
        
        if(finish[i]) return;
        visited[i] = true;
        dfs(arr[i]);
        parent[i] = parent[arr[i]];
        personList.get(parent[i]).size++;
        finish[i] = true;
    }

    public static class Person{
        int cycle;
        int size;
    }
}
```