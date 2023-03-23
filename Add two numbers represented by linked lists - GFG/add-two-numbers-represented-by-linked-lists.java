//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node l1, Node l2){
        // code here
        // return head of sum list
        l1 = reverse(l1);
        l2 = reverse(l2);
        Node dummy = new Node (-1);
        Node temp = dummy;
        int carry = 0;
        while(l1!=null||l2!=null||carry!=0){
            int sum =0;
            if(l1!=null){
                sum += l1.data; l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.data; l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            temp.next = new Node(sum%10);
            temp = temp.next;
        }
        return reverse(dummy.next);
    }
    static Node reverse(Node head){
        Node prev = null;
        while(head!=null){
            Node nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
}