package linkedlist;

public class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Node with data" + data + " deleted ");
	}
	
	
}
