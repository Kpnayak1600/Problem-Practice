//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.Solve(n, nums);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> Solve(int n, int[] nums) {
        // code here
        int n1 = -1;
        int n2 = -1;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(count1==0){
                n1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                n2 = nums[i];
                count2 = 1;
            }else if(n1 == nums[i]){
                count1++;
            }else if(n2 == nums[i]){
                count2++;
            }else{
                count1--;count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int i=0;i<n;i++){
            if(n1 == nums[i]){
                count1++;
            }
            if(n2 == nums[i]){
                count2++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(count1>n/3){
            res.add(n1);
        }
        if(n1!=n2&&count2>n/3){
            res.add(n2);
        }
        if(res.isEmpty()){
            res.add(-1);
        }
        return res;
    }
}
        
