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
    static Node addTwoLists(Node list1, Node list2){
        // code here
        // return head of sum list
        list1 = reverse(list1);
        list2 = reverse(list2);
        Node dummy = new Node (-1);
        Node temp = dummy;
        int carry = 0;
        while(list1!=null||list2!=null||carry!=0){
            int sum =0;
            if(list1!=null){
                sum += list1.data; list1 = list1.next;
            }
            if(list2!=null){
                sum+=list2.data; list2 = list2.next;
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