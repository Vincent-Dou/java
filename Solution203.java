package LeetCode;

/**
 * Auther:vincent-Dou
 */

import org.w3c.dom.NodeList;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
//            while(head != null && head.val == val ){
//                head = head.next;
//            }
//            if(head == null){
//                return null;
//            }
//            ListNode temp = head;
//            while(temp.next != null ){
//                if(temp.next.val == val){
//                    temp = temp.next.next;
//                }else{
//                    temp = temp.next;
//                }
//            }
//            return head;
        ListNode temp = new ListNode(0);
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
