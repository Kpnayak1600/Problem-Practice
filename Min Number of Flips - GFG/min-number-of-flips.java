//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String str) {
        // Code here
     return Math.min(getFlipWithStartingCharcter(str, '0'),
               getFlipWithStartingCharcter(str, '1'));
    }
   int getFlipWithStartingCharcter(String str,
                                    char expected)
    {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++)
        {
            //  if current character is not expected,
            // increase flip count
            if (str.charAt(i) != expected)
                flipCount++;
      
            //  flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }
      
  public static char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }
}