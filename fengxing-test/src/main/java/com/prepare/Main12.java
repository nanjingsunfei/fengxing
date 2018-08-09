package com.prepare;

/**
 * Created by sunfei on 2018/7/1.
 */
public class Main12 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Main12 main12 = new Main12();
        ListNode r = main12.deleteDuplication(node1);
        System.out.println(r);

    }
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode index = new ListNode(1);
        index.next = pHead;

        ListNode p = pHead;
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                ListNode q = p.next;
                while (q.next != null && p.val == q.next.val) {
                    q = q.next;
                }
                if (q.next != null) {
                    p.val = q.next.val;
                    p.next = q.next.next;
                } else {
                    p = q.next;
                }
            } else {
                p = p.next;
            }
        }

        return index.next;
    }

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode newNode = new ListNode(0);
        newNode.next = pHead;

        ListNode p = newNode;
        ListNode q = p.next;
        while (q != null) {
            if (q.val == 5) {
                p.next = q.next;
                q = q.next;
            } else {
                q = q.next;
                p = p.next;
            }

        }
        return newNode.next;

    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

