import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, line;
    static char[] list, result;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        line = Integer.parseInt(st.nextToken());

        result = br.readLine().toCharArray();
        list = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, n).toCharArray();

        Stack<String> stack = new Stack<>();
        boolean flag = false;
        for(int i=0;i<line;i++){
            if(!flag) {
                int index = 0;
                char[] curLine = br.readLine().toCharArray();
                for (char cur : curLine) {
                    if (cur == '-') {
                        char ptr = list[index];
                        list[index] = list[index + 1];
                        list[index + 1] = ptr;
                    } else if (cur == '?') {
                        flag = true;
                        break;
                    }
                    index++;
                }
            }else{
                stack.add(br.readLine());
            }
        }
        while(!stack.isEmpty()){
            int index = 0;
            char[] curLine = stack.pop().toCharArray();
            for (char cur : curLine) {
                if (cur == '-') {
                    char ptr = result[index];
                    result[index] = result[index + 1];
                    result[index + 1] = ptr;
                }
                index++;
            }
        }

        for(int i=0;i<list.length-1;i++){
            if(list[i] == result[i]) sb.append("*");
            else if(list[i] == result[i+1] || list[i+1] == result[i]) {
                sb.append("-");
                char tmp = list[i];
                list[i] = list[i+1];
                list[i+1] = tmp;
            }
            else {
                sb = new StringBuilder();
                for(int j=0;j<list.length-1;j++){
                    sb.append("x");
                }
                System.out.println(sb);
                return;
            }
        }
        System.out.println(sb);
    }

}

