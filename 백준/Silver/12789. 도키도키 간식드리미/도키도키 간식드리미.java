import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Character[][] arr;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine()); 
        int[] lineStack = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            lineStack[i] = Integer.parseInt(st.nextToken());
        }

        result(lineStack);
    }

    private static void result(int[] stack){
        int orderValue = 1; 

        Stack<Integer> tmpStack = new Stack<>();

        for(int i = 0; i < stack.length; i++){
            if(stack[i] != orderValue){ 
                if(!tmpStack.isEmpty() && tmpStack.peek() == orderValue){
                    tmpStack.pop();
                    i--; 
                    orderValue++;
                }else{ 
                    tmpStack.push(stack[i]);
                }
            }else{
                orderValue++;
            }
        }

        boolean result = true; 

        for(int i = 0; i < tmpStack.size(); i++){
            int tValue = tmpStack.pop(); 

            if(tValue == orderValue){
                orderValue++;
            }else{
                result = false;
                break;
            }
        }

        if(result) System.out.println("Nice");
        else System.out.println("Sad");
    }
}