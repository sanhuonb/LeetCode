/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class getKthFromEnd_22 {
    /**
     * 自己的解法，先遍历统计链表长度n，再设置一个指针走 n - k 步。
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd_1(ListNode head, int k) {
        int length = 0;
        ListNode h = head;
        while (h != null){
            length++;
            h = h.next;
        }
        if (k > length){
            System.out.println("输入长度有误");
            return null;
        }
        for (int i = 0; i < length - k; i++){
            head = head.next;
        }
        return head;
    }

    /**
     * 优秀解法，双指针，第一个指针先走 k 步，然后第二个指针从头开始，两个指针同时走。
     * 当第一个指针遍历完链表，第二个指针就是走了 n - k 步，就是倒数第 K 个结点
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd_2(ListNode head, int k){
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++){
            former = former.next;
        }
        while (former != null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode next){
            this.val = x;
            this.next = next;
        }
    }

}
