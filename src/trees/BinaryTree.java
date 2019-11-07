package trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}
}

class DistNode {
	Node node;
	int distance;

	public DistNode(Node node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "" + node.data;
	}
}

class BinaryTree {

	Node root;

	public BinaryTree(int rootData) {
		root = new Node(rootData);
	}

	public void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}

	public void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}

	public void preOrderTraversalIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		while (true) {
			if (root != null) {
				System.out.println(root.data);
				stack.push(root);
				root = root.left;
			} else if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			} else {
				break;
			}
		}
	}

	public void inOrderTraversalIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else if (!stack.isEmpty()) {
				root = stack.pop();
				System.out.println(root.data);
				root = root.right;
			} else {
				break;
			}
		}
	}

	public void postOrderTraversalIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		Stack<Integer> reverseStack = new Stack<>();
		while (true) {
			if (root != null) {
				reverseStack.push(root.data);
				stack.push(root);
				root = root.right;
			} else if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.left;
			} else {
				break;
			}
		}

		while (!reverseStack.isEmpty()) {
			System.out.println(reverseStack.pop());
		}
	}

	public void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			System.out.println(poll.data);
			if (poll.left != null)
				queue.offer(poll.left);
			if (poll.right != null)
				queue.offer(poll.right);
		}
	}

	public void reverseLevelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			stack.push(poll.data);
			if (poll.right != null)
				queue.offer(poll.right);
			if (poll.left != null)
				queue.offer(poll.left);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public void verticalOrderTraversal(Node root, Comparator comparator) {
		if (root == null)
			return;
		Queue<DistNode> queue = new LinkedList<>();
		Map<Integer, List<DistNode>> map = null;
		if (comparator == null)
			map = new TreeMap<>();
		else
			map = new TreeMap<Integer, List<DistNode>>(comparator);
		queue.offer(new DistNode(root, 0));
		List<DistNode> list = null;
		while (!queue.isEmpty()) {
			DistNode distNode = queue.poll();
			list = map.getOrDefault(distNode.distance, new ArrayList<>());
			list.add(distNode);

			map.put(distNode.distance, list);
			if (distNode.node.left != null)
				queue.offer(new DistNode(distNode.node.left, distNode.distance - 1));
			if (distNode.node.right != null)
				queue.offer(new DistNode(distNode.node.right, distNode.distance + 1));
		}
		map.forEach((key, value) -> value.forEach(System.out::println));
	}

	public void diagonalTraversal(Node root) {
		if (root == null)
			return;
		Queue<DistNode> queue = new LinkedList<>();
		Map<Integer, List<Node>> map = new HashMap<>();
		queue.offer(new DistNode(root, 0));
		List<Node> list = null;
		while (!queue.isEmpty()) {
			DistNode distNode = queue.poll();
			list = map.getOrDefault(distNode.distance, new ArrayList<>());
			list.add(distNode.node);
			map.put(distNode.distance, list);
			if (distNode.node.left != null)
				queue.offer(new DistNode(distNode.node.left, distNode.distance + 1));
			if (distNode.node.right != null)
				queue.offer(new DistNode(distNode.node.right, distNode.distance));
		}
		map.forEach((key, value) -> System.out.println(value));
	}

	public void topView(Node root) {
		if (root == null)
			return;
		Queue<DistNode> queue = new LinkedList<>();
		Map<Integer, Node> map = new TreeMap<>();
		queue.offer(new DistNode(root, 0));
		while (!queue.isEmpty()) {
			DistNode distNode = queue.poll();
			if (map.get(distNode.distance) == null)
				map.put(distNode.distance, distNode.node);
			if (distNode.node.left != null)
				queue.offer(new DistNode(distNode.node.left, distNode.distance - 1));
			if (distNode.node.right != null)
				queue.offer(new DistNode(distNode.node.right, distNode.distance + 1));
		}
		map.values().forEach(System.out::println);
	}

	public void bottomView(Node root) {
		if (root == null)
			return;
		Queue<DistNode> queue = new LinkedList<>();
		Map<Integer, Node> map = new TreeMap<>();
		queue.offer(new DistNode(root, 0));
		while (!queue.isEmpty()) {
			DistNode distNode = queue.poll();
			map.put(distNode.distance, distNode.node);
			if (distNode.node.left != null)
				queue.offer(new DistNode(distNode.node.left, distNode.distance - 1));
			if (distNode.node.right != null)
				queue.offer(new DistNode(distNode.node.right, distNode.distance + 1));
		}
		map.values().forEach(System.out::println);
	}

	public void rightView(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 1; i <= n; i++) {
				Node node = queue.poll();
				if (i == n)
					System.out.println(node.data);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
		}

	}

	public void leftView(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 1; i <= n; i++) {
				Node node = queue.poll();
				if (i == 1)
					System.out.println(node.data);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);

			}
		}
	}

	public void spiralView(Node root) {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.add(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node node = s1.pop();
				System.out.println(node.data);
				if (node.left != null)
					s2.push(node.left);
				if (node.right != null)
					s2.push(node.right);
			}

			while (!s2.isEmpty()) {
				Node node = s2.pop();
				System.out.println(node.data);
				if (node.right != null)
					s1.push(node.right);
				if (node.left != null)
					s1.push(node.left);
			}
		}

	}

	public int getMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		if (root.left == null && root.right == null)
			return root.data;
		int leftMax = getMax(root.left);
		int rightMax = getMax(root.right);
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}

	public int getMin(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return root.data;
		int leftMin = getMin(root.left);
		int rightMin = getMin(root.right);
		return Math.min(root.data, Math.min(leftMin, rightMin));

	}

	public void printLeafNodes(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			System.out.println(root.data);
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

	public boolean search(Node root, int data) {
		if (root == null)
			return false;
		if (root.data == data)
			return true;
		boolean search = search(root.left, data);
		boolean search2 = search(root.right, data);
		return search || search2;
	}

	public int size(Node root) {
		if (root == null)
			return -1;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			count++;
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return count;
	}

	public int height(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static boolean isMirror(Node root1, Node root2) {
		if (root1 == null || root2 == null)
			return false;
		if (root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left))
			return true;
		return false;
	}

	public static boolean isSimilar(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 != null)
			return (root1.data == root2.data && isSimilar(root1.left, root2.left)
					&& isSimilar(root1.right, root2.right));
		return false;
	}

	public void printAllPathsFromRoot(Node root, Stack<Node> stack) {
		if (root == null)
			return;
		stack.push(root);
		printAllPathsFromRoot(root.left, stack);
		if (root.left == null && root.right == null)
			System.out.println(stack);
		printAllPathsFromRoot(root.right, stack);
		stack.pop();
	}

	public boolean printRootToLeafWithGivenSum(Node root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.data == sum)
			return true;
		if (printRootToLeafWithGivenSum(root.left, sum - root.data))
			return true;
		if (printRootToLeafWithGivenSum(root.right, sum - root.data))
			return true;
		return false;
	}

	public int sumOfAllNodes(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		int leftSum = sumOfAllNodes(root.left);
		int rightSum = sumOfAllNodes(root.right);
		return root.data + leftSum + rightSum;
	}

	public boolean isChild(Node root, Node node1, Node node2) {
		if (root == null)
			return false;
		if ((node1.left.data == node2.data) || (node1.right.data == node2.data))
			return true;
		if (isChild(root.left, node1, node2))
			return true;
		if (isChild(root.right, node1, node2))
			return true;
		return false;
	}

	public boolean isSibling(Node root, Node node1, Node node2) {
		if (root == null)
			return false;
		if (root.left.data == node1.data && root.right.data == node2.data)
			return true;
		if (isSibling(root.left, node1, node2))
			return true;
		if (isSibling(root.right, node1, node2))
			return true;
		return false;

	}

	public void printNodesAtGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.println(root.data);
		printNodesAtGivenLevel(root.left, level - 1);
		printNodesAtGivenLevel(root.right, level - 1);
	}

	public int getLevel(Node root, Node node, int level) {
		if (root == null)
			return -1;
		if (root.data == node.data)
			return level;
		int leftLevel = getLevel(root.left, node, level + 1);
		if (leftLevel != -1)
			return leftLevel;
		int rightLevel = getLevel(root.right, node, level + 1);
		return rightLevel;

	}

	public boolean findIfPathToNode(Node root, Node node, Stack<Node> stack) {
		if (root == null)
			return false;

		stack.push(root);
		if (root.data == node.data)
			return true;
		if (findIfPathToNode(root.left, node, stack) || findIfPathToNode(root.right, node, stack))
			return true;
		stack.pop();
		return false;

	}

	public int lowestCommonAncestor(Node root, Node node1, Node node2) {
		if (root == null)
			return -1;
		Stack<Node> stack1 = new Stack<>();
		findIfPathToNode(root, node1, stack1);
		Stack<Node> stack2 = new Stack<>();
		findIfPathToNode(root, node2, stack2);
		int lCA = 0;
		for (int i = 0, j = 0; i < stack1.size() && j < stack2.size(); i++, j++) {
			if (stack1.get(i).data != stack2.get(j).data)
				break;
			lCA = stack1.get(i).data;
		}
		return lCA;
//		to return the distance between the nodes
//		return stack1.size() + stack2.size() - 1;
	}

	public Node LCARecursive(Node root, Node node1, Node node2) {
		if (root == null)
			return null;
		if (root.data == node1.data || root.data == node2.data)
			return root;
		Node leftRecursive = LCARecursive(root.left, node1, node2);
		Node rightRecursive = LCARecursive(root.right, node1, node2);
		if (leftRecursive != null && rightRecursive != null)
			return root;
		return (leftRecursive != null) ? leftRecursive : rightRecursive;
	}

	public void deleteNode(Node root, Node node) {
		if (root == null)
			return;
		if (root.left != null && root.left.data == node.data)
			root.left = null;
		if (root.right != null && root.right.data == node.data)
			root.right = null;
		deleteNode(root.left, node);
		deleteNode(root.right, node);
	}

	@Override
	public String toString() {
		preOrderTraversal(root);
		return "";
	}
}

class BinarySearchTree {
	Node root;

	public BinarySearchTree(int value) {
		root = new Node(value);
	}

	public void insert(int value) {
		Node newNode = new Node(value);
		if (root == null)
			root = newNode;
		else
			insert(root, newNode);
	}

	private void insert(Node root, Node node) {
		if (node.data < root.data) {
			if (root.left == null)
				root.left = node;
			else
				insert(root.left, node);
		} else if (node.data > root.data) {
			if (root.right == null)
				root.right = node;
			else
				insert(root.right, node);
		} else {
			System.out.println("Data already exists in tree");
		}
	}

	public boolean find(int value) {
		if (root == null)
			return false;
		return find(root, value);
	}

	private boolean find(Node root, int value) {
		if (root.data == value)
			return true;
		if (root.left != null && value < root.data)
			return find(root.left, value);
		if (root.right != null && value > root.data)
			return find(root.right, value);
		return false;
	}

	public void preOrderTraversal(Node root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public int min() {
		if (root == null)
			return 0;
		Node temp = root;
		while (temp.left != null)
			temp = temp.left;
		return temp.data;
	}

	public int max() {
		if (root == null)
			return 0;
		Node temp = root;
		while (temp.right != null)
			temp = temp.right;
		return temp.data;
	}

	@Override
	public String toString() {
		preOrderTraversal(root);
		return "";
	}
}

class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree(2);
		binarySearchTree.insert(3);
		binarySearchTree.insert(1);
		binarySearchTree.insert(4);
		System.out.println(binarySearchTree.min());
		System.out.println(binarySearchTree.max());
//		System.out.println(binarySearchTree.find(4));
//		System.out.println(binarySearchTree);
	}

}

class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(1);
		binaryTree.root.left = new Node(2);
		binaryTree.root.right = new Node(3);
		binaryTree.root.left.left = new Node(4);
		binaryTree.root.left.right = new Node(5);
		binaryTree.root.right.left = new Node(6);
		binaryTree.root.right.right = new Node(7);
		System.out.println(binaryTree);
		binaryTree.deleteNode(binaryTree.root, binaryTree.root.right);
		System.out.println(binaryTree);
//		int lcaRecursive = binaryTree.lowestCommonAncestor(binaryTree.root, binaryTree.root.left.left, binaryTree.root.right.right);
//		System.out.println(lcaRecursive);

//		int lowestCommonAncestor = binaryTree.lowestCommonAncestor(binaryTree.root, binaryTree.root.right,
//				binaryTree.root.right.left);
//		System.out.println(lowestCommonAncestor);
//		Stack<Node> stack = new Stack<>();
//		System.out.println(binaryTree.findIfPathToNode(binaryTree.root, binaryTree.root.left.right,
//				stack));
//		binaryTree.diagonalTraversal(binaryTree.root);
//		System.out.println(binaryTree.getLevel(binaryTree.root, binaryTree.root.right.right, 0));
//		binaryTree.printNodesAtGivenLevel(binaryTree.root, 1);
//		System.out.println(binaryTree.isChild(binaryTree.root, binaryTree.root, binaryTree.root.right));
//		binaryTree.spiralView(binaryTree.root);
//		System.out.println(binaryTree.sumOfAllNodes(binaryTree.root));
//		System.out.println(binaryTree.printRootToLeafWithGivenSum(binaryTree.root, 11));
//		binaryTree.printAllPathsFromRoot(binaryTree.root, new Stack<>());
//		System.out.println(BinaryTree.isSimilar(binaryTree.root, binaryTree2.root));
//		System.out.println(binaryTree.height(binaryTree.root));
//		System.out.println(binaryTree.search(binaryTree.root, 5));
//		binaryTree.printLeafNodes(binaryTree.root);
//		System.out.println(binaryTree.getMin(binaryTree.root));
//		System.out.println(binaryTree.getMax(binaryTree.root));
//		binaryTree.leftView(binaryTree.root);
//		binaryTree.rightView(binaryTree.root);
//		binaryTree.bottomView(binaryTree.root);
//		binaryTree.topView(binaryTree.root);
//		binaryTree.verticalOrderTraversal(binaryTree.root, Comparator.reverseOrder());
//		binaryTree.reverseLevelOrderTraversal(binaryTree.root);
//		binaryTree.levelOrderTraversal(binaryTree.root);
//		binaryTree.postOrderTraversalIterative(binaryTree.root);
//		binaryTree.preOrderTraversal(binaryTree.root);
//		System.out.println("===========================");
//		binaryTree.preOrderTraversalIterative(binaryTree.root);
//		binaryTree.postOrderTraversal(binaryTree.root);
//		binaryTree.inOrderTraversalIterative(binaryTree.root);
	}
}