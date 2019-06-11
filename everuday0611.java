import java.util.Arrays;

/**
 * Date: 2019/6/11
 * Time: 19:49
 * Author: vincent-Dou
 * Description：
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class everuday0611 {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode small = new ListNode(-1);
        ListNode big   = new ListNode(-1);
        ListNode cur1 = small;
        ListNode cur2 = big;
        while (pHead != null){
            if(pHead.val < x){
                cur1.next = pHead;
                cur1 = cur1.next;
                pHead = pHead.next;
                cur1.next = null;
            }else{
                cur2.next = pHead;
                cur2 = cur2.next;
                pHead = pHead.next;
                cur2.next = null;
            }
        }
        cur1.next = big.next;
        return small.next;
    }
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int len = 0;
        int temp = gifts[0];
        for(int i = 0; i < gifts.length; i++){
            if(gifts[i] == temp){
                len++;
            }
            if(gifts[i] != temp){
                temp = gifts[i];
            }
            if (len > n / 2){
                return temp;
            }
        }
        return 0;
    }
}
