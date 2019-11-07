/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultHead = result;
        ArrayList<Integer> p = new ArrayList<Integer>();
        ArrayList<Integer> q = new ArrayList<Integer>();
        
        while (l1!= null){
            p.add(l1.val);
            l1 = l1.next;
        }
  
        while (l2 != null){
            q.add(l2.val);
           l2 = l2.next;
        }
        
        int length = Math.max(p.size(), q.size());
        int total = 0;
        int carryOver = 0;
        int pv, qv;
        for (int i = 0; i<length; i++){
            total = carryOver;
            carryOver = 0;
            if (i> p.size()-1){
                pv = 0;
            }
            else {
                pv = p.get(i);
            }
            if (i> q.size()-1){
                qv = 0;
            }
            else {
                qv = q.get(i);
            }
            
            //find total of values
            total = total + pv+qv;
            if (total>9){
                total = total - 10;
                carryOver = 1;
            }

            result.next = new ListNode(total);
            result = result.next;
        }
        //check for outstanding carryOver
        if (carryOver!=0){
            result.next = new ListNode(carryOver);
        }
        
        return resultHead.next;
         
    }
}