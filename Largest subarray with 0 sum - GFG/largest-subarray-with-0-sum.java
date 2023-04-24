//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int nums[], int n)
    {
        // Your code here
        Map<Integer,Integer>mp = new HashMap<>();
        int res = 0;
        int presum = 0;
        for(int i=0;i<nums.length;i++){
            presum += nums[i];
            if(presum==0){
                res = i+1;
            }
            if(!mp.containsKey(presum)){
                mp.put(presum,i);
            }
            if(mp.containsKey(presum)){
                res = Math.max(res,i-mp.get(presum));
            }
        }
        return res;
    }
}