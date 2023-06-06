package practice;

public class PopulatingNextRightPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(connect(root));

	}
	
	public static Node connect(Node root) {
		if(root == null) return null;
        Node dummy = new Node(0);
        Node cur = dummy;
        cur.next = root;
        cur = cur.next;
        Node nxt = cur.left;
        while(cur != null && nxt != null) {
        	cur.left.next = cur.right;
        	if(cur.next != null) {
        		cur.right.next = cur.next.left;
        	}
        	cur = cur.next;
        	if(cur == null) {
        		cur = nxt;
        		nxt = cur.left;
        	}
        }
        return dummy.next;
    }
	

}
