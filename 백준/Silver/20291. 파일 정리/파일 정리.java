import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(),".");
            st.nextToken();
            String extension = st.nextToken();
            if(!map.containsKey(extension)) list.add(extension);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
        Collections.sort(list);
        for(String extension : list){
            sb.append(extension + " " + map.get(extension)+"\n");
        }
        System.out.println(sb.toString());
    }
}

