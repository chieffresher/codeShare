import java.util.TreeMap;

// Definition for singly-linked list.
  public class ListNode {
      int val;
     ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class LinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = getCountFromEnd(head,n);
        //check edge cases : when item to be jumped is 1st item
        if(count==n-1)
            return head.next;

        return  head;
    }
    public int getCountFromEnd(ListNode node,int n)
    {
        if(node.next==null)
            return  0;
        int count = getCountFromEnd(node.next,n)+1;
        if(count==n)
            node.next = node.next.next;

        return count;
    }
    public int getLength(ListNode node)
    {
        if(node==null)
            return 0;
        return getLength(node.next)+1;
    }
    //same speed as the recursive
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int count = getLength(head);
        //check edge cases : when item to be jumped is 1st item
        if(count==n)
            return head.next;
        int movesfoward = count - (n+1);
        ListNode temp = head;
        while (movesfoward>0)
        {
            temp = temp.next;
            movesfoward--;
        }
        temp.next = temp.next.next;
        return  head;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int count = getLength(head);
        //check edge cases : when item to be jumped is 1st item
        if(count==n)
            return head.next;
        int movesfoward = count - n;
        while (movesfoward>0)
        {
            head = head.next;
            movesfoward--;
        }
        head.next = head.next.next;
        return  head;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int end = nums.length-(k-1);
        int[] output = new int[end];
        int out_i=0,max=0;
        max = getMax(nums,0,k-1);
        for(int i=0;i<end; i++)
        {
            if(i-1>=0 && max==nums[i-1])
                max = getMax(nums,i,i+(k-2));
            if(nums[i+k-1]>max)
                max=nums[i+k-1];
            output[out_i]=max;
            out_i++;
        }
        return output;
    }
    int getMax(int[] arr,int start,int end)
    {
        int max = Integer.MIN_VALUE;
        for(int i=start; i<=end; i++)
            if(arr[i]>max)
                max= arr[i];
        return max;
    }
}

    public  static  void main(String[] args)
    {

    }
}