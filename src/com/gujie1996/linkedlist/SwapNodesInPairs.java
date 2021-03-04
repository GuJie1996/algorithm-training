package com.gujie1996.linkedlist;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode head = null;
        for (int i = 9; i >= 1; i--) {
            ListNode listNode = new ListNode(i, head);
            head = listNode;
        }
        printListNode(head);
        head = swapNodesInPairs.swapPairs2(head);
        printListNode(head);
    }

    // 方法一：自己写的，太傻了
    public ListNode swapPairs(ListNode head) {
        // 动两个节点要3个指针
        ListNode prePre = head.next;
        ListNode pre = head;
        ListNode cur = head.next.next;
        prePre.next = pre;
        pre.next = cur;
        // 记录头节点
        ListNode origin = prePre;
        while (cur != null) {
            // cur率先移动，要用临时变量记录原来的位置参与交换
            ListNode temp = cur;
            cur = cur.next;
            // 偶数时才交换
            if ((temp.val&1) == 0) {
                pre.next = temp.next;
                temp.next = pre;
                prePre.next = temp;
            } else {
                // pre如果没有通过交换移动，就要手动移动
                pre = pre.next;
            }
            // prePre移动
            prePre = prePre.next;
        }
        return origin;
    }

    // 方法二：走2步就不用判断偶数
    public ListNode swapPairs2(ListNode head) {
        // 定义一个初始ListNode，这样就不用手动算第一步
        ListNode origin = new ListNode();
        ListNode pre = origin;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            // pre、a、b三个指针交换2个节点，还需要一个交换的中间变量next
            ListNode a = pre.next;
            ListNode b = a.next;
            ListNode next = b.next;
            pre.next = b;
            b.next = a;
            a.next = next;
            // pre走两步
            pre = a;
        }
        // 因为pre没有参与交换，座位虚拟前驱节点，它的next就是真正的头结点
        return origin.next;
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
