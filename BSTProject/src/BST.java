import java.lang.Comparable;

public class BST implements BSTInterface
{
	private TreeNode root;
	private int nodeCount;

	public BST()
	{
		root = null;
		nodeCount = 0;
	} // end constructor

	public int size()
	{
		return nodeCount;
	} // end size

	public boolean isEmpty()
	{
		return root == null;
	} // end isEmpty

	/*
	 * Pre: newVal is not null
	 * Post: a new node containing newVal is added to the correct position in the BST,
	 *       nodeCount is incremented by 1
	 */
	public void add(Comparable newVal)
	{
		TreeNode newNode = new TreeNode(newVal);
		root = addHelper(root, newNode);
		nodeCount++;
	} // end add

	/*
	 * Pre: newNode is not null, current may be null (base case)
	 * Post: newNode is inserted into the subtree rooted at current,
	 *       returns the updated root of the subtree
	 */
	private TreeNode addHelper(TreeNode current, TreeNode newNode)
	{
		if (current == null)
		{
			return newNode;
		} // end base case

		if (newNode.getValue().compareTo(current.getValue()) <= 0)
		{
			current.setLeft(addHelper(current.getLeft(), newNode));
		}
		else
		{
			current.setRight(addHelper(current.getRight(), newNode));
		} // end compare

		return current;
	} // end addHelper

	/*
	 * Pre: toFind is not null
	 * Post: returns true if toFind exists in the tree, false otherwise
	 */
	public boolean find(Comparable toFind)
	{
		return findHelper(root, toFind);
	} // end find

	/*
	 * Pre: target is not null, current may be null (base case)
	 * Post: returns true if target is found in the subtree, false otherwise
	 */
	private boolean findHelper(TreeNode current, Comparable target)
	{
		if (current == null)
		{
			return false;
		} // end base case

		int cmp = target.compareTo(current.getValue());

		if (cmp == 0)
		{
			return true;
		}
		else if (cmp < 0)
		{
			return findHelper(current.getLeft(), target);
		}
		else
		{
			return findHelper(current.getRight(), target);
		} // end compare
	} // end findHelper

	/*
	 * Pre: old and toAdd are not null
	 * Post: if old exists it is removed and toAdd is added, returns true.
	 *       if old does not exist, toAdd is still added, returns false.
	 */
	public boolean replace(Comparable old, Comparable toAdd)
	{
		boolean found = find(old);
		if (found)
		{
			delete(old);
		} // end if found
		add(toAdd);
		return found;
	} // end replace

	/*
	 * Pre: old is not null
	 * Post: if old exists it is removed and tree is restructured,
	 *       nodeCount decremented, returns true. If not found returns false.
	 */
	public boolean delete(Comparable old)
	{
		if (!find(old))
		{
			return false;
		} // end not found check

		root = deleteHelper(root, old);
		nodeCount--;
		return true;
	} // end delete

	/*
	 * Pre: target exists somewhere in this subtree, current may be null
	 * Post: the first occurrence of target is removed from the subtree,
	 *       tree is restructured, returns the updated root of subtree
	 */
	private TreeNode deleteHelper(TreeNode current, Comparable target)
	{
		if (current == null)
		{
			return null;
		} // end base case

		int cmp = target.compareTo(current.getValue());

		if (cmp < 0)
		{
			current.setLeft(deleteHelper(current.getLeft(), target));
		}
		else if (cmp > 0)
		{
			current.setRight(deleteHelper(current.getRight(), target));
		}
		else
		{
			// found the node to delete

			// leaf node
			if (current.getLeft() == null && current.getRight() == null)
			{
				return null;
			} // end leaf case

			// one child only
			if (current.getLeft() == null)
			{
				return current.getRight();
			} // end no left child
			if (current.getRight() == null)
			{
				return current.getLeft();
			} // end no right child

			// two children: use in-order successor
			TreeNode successor = findMin(current.getRight());
			current.setValue(successor.getValue());
			current.setRight(deleteHelper(current.getRight(), successor.getValue()));
		} // end found node

		return current;
	} // end deleteHelper

	/*
	 * Pre: node is not null
	 * Post: returns the leftmost (minimum) node in the subtree
	 */
	private TreeNode findMin(TreeNode node)
	{
		while (node.getLeft() != null)
		{
			node = node.getLeft();
		} // end while
		return node;
	} // end findMin

	public void printInOrder()
	{
		inOrderHelper(root);
		System.out.println();
	} // end printInOrder

	/*
	 * Pre: current may be null (base case)
	 * Post: prints values in the subtree in order
	 */
	private void inOrderHelper(TreeNode current)
	{
		if (current != null)
		{
			inOrderHelper(current.getLeft());
			System.out.print(current.getValue() + " ");
			inOrderHelper(current.getRight());
		}
	} // end inOrderHelper

	public void printPreOrder()
	{
		preOrderHelper(root);
		System.out.println();
	} // end printPreOrder

	private void preOrderHelper(TreeNode current)
	{
		if (current != null)
		{
			System.out.print(current.getValue() + " ");
			preOrderHelper(current.getLeft());
			preOrderHelper(current.getRight());
		} // end if not null
	} // end preOrderHelper

	/*
	 * Pre: none
	 * Post: prints all values using Post Order traversal (Left, Right, Root)
	 */
	public void printPostOrder()
	{
		postOrderHelper(root);
		System.out.println();
	} // end printPostOrder

	/*
	 * Pre: current may be null (base case)
	 * Post: prints values in the subtree in post order
	 */
	private void postOrderHelper(TreeNode current)
	{
		if (current != null)
		{
			postOrderHelper(current.getLeft());
			postOrderHelper(current.getRight());
			System.out.print(current.getValue() + " ");
		} // end if not null
	} // end postOrderHelper
} // end BST class
