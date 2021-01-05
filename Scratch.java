//https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3593/
class Scratch {


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        //creating test case data
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(listNode);
    }

    // delete duplicates
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode ls = new ListNode(0);
        ListNode ans = ls;
        if(head == null){
            return null;
        }
        int value = head.val;
        if(head.next != null && head.val != head.next.val){
            ls.next = new ListNode(head.val);
            ls = ls.next;
            head = head.next;
        } else if(head.next == null){
            return new ListNode(head.val);
        }
        while(head != null){
            // if the next node is null and the previous value is different than current node than include that node
            if(head.val != value && head.next == null){
                ls.next = new ListNode(head.val);
                ls = ls.next;
            }
            // for the present node if the current value is not equal to both previous node value and next node value then add that to answer
            else if(head.next != null && head.val != value && head.next.val != head.val){
                ls.next = new ListNode(head.val);
                ls = ls.next;
            }
            //previous value
            value = head.val;
            head = head.next;

        }

        return ans.next;

    }
}
