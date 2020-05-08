import java.util.*;
import java.io.*;
import java.util.Scanner;


class Solution2 {


      class SinglyLinkedListNode{
          int data;
         SinglyLinkedListNode next;
         public SinglyLinkedListNode(SinglyLinkedListNode node)
         {
             data = node.data;
             next = node.next;
         }
      }

      //hashed approached : works fine
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
          //hashing list 1
        HashMap<SinglyLinkedListNode,Integer> hashedLink = new HashMap<SinglyLinkedListNode,Integer>();
        while(head1!=null)
        {
            hashedLink.put(head1,head1.data);
            head1 = head1.next;
        }
        while(head2!=null)
        {
            if(hashedLink.get(head2)!=null)
                return head2.data;
            head2 = head2.next;
        }
        return -1;
    }

    //non-hash approach
     int findMergeNode2(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

         //find the length of both list and use longer list of iteration
        int lenH1 = 0, lenH2 = 0;
        SinglyLinkedListNode tempHead1 = new SinglyLinkedListNode(head1);
        SinglyLinkedListNode tempHead2 = new SinglyLinkedListNode(head2);
        while(tempHead1!=null)
        {
            lenH1++;
            tempHead1 = tempHead1.next;
        }
        while(tempHead2!=null)
        {
            lenH2++;
            tempHead2 = tempHead2.next;
        }
        if(lenH1 >= lenH2)
        {
            while(lenH1>0)
            {
                lenH1--;
                if(head1==head2)
                    return  head1.data;
                head1 = head1.next;
                head2 = head2.next;
                if(head2==null)
                    break;
            }
        }
        else
        {
            while (lenH2>0)
            {
                lenH2--;
                if(head1==head2)
                    return head1.data;
                head1 = head1.next;
                head2 = head2.next;
                if(head1==null)
                    break;
            }
        }


        return -1;
    }

    public static void main(String[] args) {



    }
}
