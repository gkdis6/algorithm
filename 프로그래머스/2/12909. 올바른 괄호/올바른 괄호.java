import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] c = s.toCharArray();
    	
    	Stack stack = new Stack();
    	for(int i = 0; i<c.length; i++) {
    		if(c[i] == '(') stack.add('(');
    		else {
    			if(stack.size()>0) stack.pop();
    			else return false;
    		}
    	}
        if(stack.size()>0) return false;
    	return true;
    }
}