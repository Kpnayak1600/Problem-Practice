//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    static class pair{
        int start,end;
        pair(int x,int y){
            this.start = x;
            this.end = y;
        }
    }
    static class MyComparator implements Comparator<pair>{
        public int compare(pair e1,pair e2){
            int a = e1.end;
            int b = e2.end;
            return a-b;
        }
    }
    public static int maxMeetings(int start[], int end[], int n){
        // add your code here
        List<pair> meetingList = new ArrayList<>();
        for(int i=0;i<n;i++){
            meetingList.add(new pair(start[i],end[i]));
        }
        Collections.sort(meetingList,new MyComparator());
        int endTime = meetingList.get(0).end;
        int res = 1;
        for(int i=1;i<n;i++){
            if(meetingList.get(i).start>endTime){
                res++;
                endTime = meetingList.get(i).end;
            }
        }
        return res;
    }
}
