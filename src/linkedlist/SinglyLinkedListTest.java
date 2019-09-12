package linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class SinglyLinkedList {

	Node head = null;

	public Node getHead() {
		return head;
	}

	public void append(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	public void prepend(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void addAfter(int element, int data) {
		Node newNode = new Node(data);
		Node temp = head;
		while (temp != null && temp.data != element) {
			temp = temp.next;
		}
		Node temp1 = temp.next;
		temp.next = newNode;
		newNode.next = temp1;
	}

	public void addBefore(int element, int data) {
		Node newNode = new Node(data);
		Node temp = head;
		Node prev = null;
		while (temp != null && temp.data != element) {
			prev = temp;
			temp = temp.next;
		}
		if (prev == null) {
			newNode.next = head;
			head = newNode;
		} else {
			newNode.next = prev.next;
			prev.next = newNode;

		}

	}

	public void reverse() {
		Node prev = null;
		Node temp = head;
		Node next = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void removeFirst() {
		Node temp = head;
		if (temp != null) {
			head = temp.next;
		}
		temp = null;
	}

	public void removeLast() {
		Node temp = head;
		Node prev = null;
		while (temp != null && temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		if (prev != null)
			prev.next = null;

	}

	public void remove(int data) {
		Node temp = head;
		Node prev = null;
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}
		if (prev == null) {
			head = temp.next;
		} else {
			prev.next = temp.next;
		}
		temp = null;
	}

	public void removeDuplicates() {
		Node curr = head;
		Node prev = null;
		Set<Integer> set = new HashSet<>();
		while (curr != null) {
			if (set.contains(curr.data)) {
				prev.next = curr.next;
			} else {
				prev = curr;
				set.add(curr.data);
			}
			curr = curr.next;
		}
	}

	public boolean isPalindrome() {
		Node curr = head;
		Stack<Integer> stack = new Stack<>();
		while (curr != null) {
			stack.push(curr.data);
			curr = curr.next;
		}

		curr = head;
		while (stack.peek() != null) {
			if (stack.pop() != curr.data) {
				return false;
			}
			if (stack.isEmpty())
				break;
			curr = curr.next;
		}
		return true;

	}

	public void printNthFromLast(int position) {
		Node p = head;
		Node q = head;
		int count = 0;
		while (q != null && count < position) {
			q = q.next;
			count++;
		}
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next;
		}
		if (p != null)
			System.out.println(p.data);
	}

	public void printNthFromBeginning(int position) {
		Node p = head;
		int count = 0;
		while (p != null && count < position) {
			p = p.next;
			count++;
		}
		if (p != null)
			System.out.println(p.data);
	}

	public void leftRotateBy(int count) {
		Node p = head;
		Node q = head;
		int position = 1;

		while (p != null && position < count) {
			p = p.next;
			position++;
		}
		while (q != null && q.next != null) {
			q = q.next;
		}

		q.next = head;
		head = p.next;
		p.next = null;
	}

	public void rightRotateBy(int count) {
		Node p = head;
		Node q = head;
		int position = 0;
		while (q != null && position < count) {
			q = q.next;
			position++;
		}
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next;
		}
		q.next = head;
		head = p.next;
		p.next = null;
	}

	public void moveTailToHead() {
		Node curr = head;
		Node prev = null;
		while (curr != null && curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		curr.next = head;
		head = curr;
		prev.next = null;
	}

	public void moveHeadToTail() {
		Node curr = head;
		Node temp = head.next;
		while (curr != null && curr.next != null) {
			curr = curr.next;
		}
		curr.next = head;
		head.next = null;
		head = temp;
	}

	public void merge(Node anotherlistHead) {
		Node p = head;
		Node q = anotherlistHead;
		int pData = 0;
		int qData = 0;
		SinglyLinkedList linkedList = new SinglyLinkedList();
		while (p != null && q != null) {
			pData = p.data;
			qData = q.data;
			if (pData <= qData) {
				linkedList.append(p.data);
				p = p.next;
			} else {
				linkedList.append(q.data);
				q = q.next;
			}
		}

		while (p != null) {
			linkedList.append(p.data);
			p = p.next;
		}

		while (q != null) {
			linkedList.append(q.data);
			q = q.next;
		}
		head = linkedList.head;

//		while (p != null && p.next != null) {
//			p = p.next;
//		}
//		p.next = anotherlistHead;
	}

	public void swap(int x, int y) {
		Node currx = head;
		Node prevx = head;
		while (currx != null && currx.data != x) {
			prevx = currx;
			currx = currx.next;
		}
		Node curry = head;
		Node prevy = null;
		while (curry != null && curry.data != y) {
			prevy = curry;
			curry = curry.next;
		}

		prevx.next = curry;
		prevy.next = currx;

		Node temp = currx.next;
		currx.next = curry.next;
		curry.next = temp;

	}

	public void pairWiseSwap() {
		Node p = head;
		int tempData = 0;
		while (p != null && p.next != null) {
			tempData = p.data;
			p.data = p.next.data;
			p.next.data = tempData;
			p = p.next.next;
		}
	}

	public boolean checkIfLoop() {
		Node p = head;
		Node q = head;
		while (p != null && q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q)
				removeLoop(q);
			System.out.println("Loop found");
			return true;
		}
		System.out.println("No loop found");
		return false;
	}

	public void removeLoop(Node q) {
		Node curr = head;
		while (curr.next != q.next) {
			curr = curr.next;
			q = q.next;
		}
		q.next = null;
	}

}

public class SinglyLinkedListTest {
	public static void main(String[] args) throws InterruptedException {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);
//		linkedList.swap(2, 5);
		linkedList.pairWiseSwap();

//		SinglyLinkedList linkedList2 = new SinglyLinkedList();
//		linkedList2.append(2);
//		linkedList2.append(6);
//		linkedList2.append(8);
//		linkedList2.append(7);
//		linkedList2.append(3);

//		linkedList.merge(linkedList2.head);
//		linkedList.leftRotateBy(2);
//		linkedList.rightRotateBy(2);
//		linkedList.removeDuplicates();
//		linkedList.moveTailToHead();
//		linkedList.moveHeadToTail();
		linkedList.printList();
//		linkedList.removeFirst();
//		linkedList.removeLast();
//		linkedList.printList();
//		linkedList.printNthFromLast(1);
//		linkedList.printNthFromBeginning(2);
	}
}