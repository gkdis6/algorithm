import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] arr = new String[a];
        for(int i = 0; i < a; i++) {
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	int d = sc.nextInt();
        	
        	int sec = d/b + 1;
        	int fir = d%b;
        	if(fir == 0) {
        		fir = b;
        		sec--;
        	}
        	if(sec > 9) {
        		arr[i] = fir+""+sec;
        	}else {
        		arr[i] = fir+"0"+sec;
        	}	
        }
        for(int i = 0; i< a; i++){
            System.out.println(arr[i]);
        }
	}

}