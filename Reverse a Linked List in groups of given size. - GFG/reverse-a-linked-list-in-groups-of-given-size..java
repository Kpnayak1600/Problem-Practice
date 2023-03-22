//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution{
    public static Node reverse(Node head, int k){
        //Your code here
        boolean isFirst = false;
        Node cur = head;
        Node prevFirst = null;
        while(cur!=null){
            Node First = cur;
            Node prev = null;
            int count = 0;
            while(cur!=null&&count<k){
                Node nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;
                count++;
            }
            if(!isFirst){
                head = prev;
                isFirst = true;
            }else{
                prevFirst.next = prev;
            }
            prevFirst = First;
        }
        return head;
    }
}

