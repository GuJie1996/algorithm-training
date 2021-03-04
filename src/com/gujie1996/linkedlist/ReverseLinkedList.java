package com.gujie1996.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = null;
        for (int i = 5; i >= 1; i--) {
            ListNode listNode = new ListNode(i, head);
            head = listNode;
        }
        printListNode(head);
        printListNode(reverseLinkedList.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        // 前驱节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // cur后移
            ListNode temp = cur;
            cur = cur.next;
            // 之前cur的next指向前驱节点
            temp.next = pre;
            // 前驱结点后移
            pre = temp;
        }
        return pre;
    }

    private static void printListNode(ListNode head) {
        ListNode currentNode = head;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(currentNode.val));
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            stringBuilder.append(String.format("->%d", currentNode.val));
        }
        System.out.println(stringBuilder);
    }

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
}
