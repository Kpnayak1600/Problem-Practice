//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends




class Solution {
    void permute(String s,Set<String>st,String res){
        if(s.length()==0){
            st.add(res);
            return;
        }
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            String sl = s.substring(0,j);
            String sr = s.substring(j+1);
            permute(sl+sr,st,res+c);
        }
        return;
    }
    public List<String> find_permutation(String S) {
        // Code here
        Set<String> st = new HashSet<>();
        permute(S,st,"");
        List<String> a = new ArrayList<>(st);
        Collections.sort(a);
        return a;
    }
}