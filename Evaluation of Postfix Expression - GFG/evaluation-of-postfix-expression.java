//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S){
        // Your code here
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(Character.isDigit(c)){
                s.push(c-'0');
            }else{
                s.push(eval(c,s.pop(),s.pop()));
            }
        }
        return s.pop();
    }
    static int eval(char c , int num1,int num2){
        if(c=='+') return num1+num2;
        if(c=='-') return num2-num1;
        if(c=='*') return num1*num2;
        if(c=='/') return num2/num1;
        return -1;
    }
}