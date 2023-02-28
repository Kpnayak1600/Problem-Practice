//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int temp[] = new int[2];
        int i=0;
        while(i<n){
            if(arr[i]!=arr[arr[i]-1]){
                int temp1 = arr[i];
                arr[i] = arr[temp1-1];
                arr[temp1-1] = temp1;
            }else{
                i++;
            }
        }
        for(i=0;i<n;i++){
            if(arr[i]!=(i+1)){
                temp[0]=arr[i];
                temp[1] = (i+1);
            }
        }
        //System.out.println(Arrays.toString(arr));
        return temp;
    }
}

// 47
// 13 33 43 16 25 19 23 31 29 35 10 2 32 11 47 15 34 46 30 26 41 18 5 17 37 39 6
// 4 20 27 9 3 8 40 24 44 14 36 7 38 12 1 42 12 28 22 45