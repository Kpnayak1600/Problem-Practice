//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> s = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                str.append(c);
            }else if(c=='('){
                s.push(c);
            }else if(c==')'){
                while(s.peek()!='('){
                    str.append(s.pop());
                }
                s.pop();
            }else{
                while(!s.empty()&&precedence(c)<=precedence(s.peek())){
                    str.append(s.pop());
                }
                s.push(c);
            }
        }
        while(!s.empty()){
            str.append(s.pop());
        }
        return str.toString();
    }
    static int precedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}