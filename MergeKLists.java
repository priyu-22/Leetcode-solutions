package practice;

public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[1,4,5],[1,3,4],[2,6]]
		ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode list3 = new ListNode(2, new ListNode(6));
		ListNode[] lists = {list1, list2, list3};
		System.out.println(mergeKLists(lists));
		//System.out.println(mergeTwoList(list1, list2));
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return new ListNode();
		ListNode mergedList = null;
		for(ListNode l: lists) {
        	mergedList = mergeTwoList(l, mergedList);
        	
        }
		
		return mergedList;
    }
	
	private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
		if(list2 == null) return list1;
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(list1!=null && list2!=null) {
			int val1 = (list1!=null)? list1.val:0;
			int val2 = (list2!=null)? list2.val:0;
			if(val1<val2) {
				tail.next=list1;
				list1 = list1.next;
			}else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}
		if(list1!=null) tail.next = list1;
		if(list2!=null) tail.next = list2;
		return dummy.next;
	}

}
