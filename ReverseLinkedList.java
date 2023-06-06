package practice;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode ans = reverseList(head);
	}
	
	public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
        	ListNode nxt = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = nxt;
        }
		
		return prev;
    }
	
	public static ListNode reverseList1(ListNode head) {
		ListNode newHead = new ListNode();
		if(head != null) return null;
		newHead =head;
		if(head.next != null) {
			newHead = reverseList1(head.next);
			head.next.next = head;
		}
		head.next = null;
		return newHead;
	}

}
