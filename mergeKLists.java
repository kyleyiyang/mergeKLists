/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        if (lists.length==1) return lists[0];
        ListNode ans=merge(lists[0],lists[1]);
        for (int i=2;i<lists.length;i++) {
            ans=merge(ans,lists[i]);
        }
        return ans;
    }
    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode dumy=new ListNode();
        ListNode temp=dumy;
        while (list1!=null && list2!=null) {
            if (list1.val<list2.val) {
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
                
            } else {
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
        }
        temp.next=(list1==null) ? list2:list1;
        return dumy.next;
    }
}
