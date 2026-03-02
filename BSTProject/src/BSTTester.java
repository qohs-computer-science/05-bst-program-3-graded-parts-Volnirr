/*
 * TODO: Liam Gillaspy
 * TODO: 3/2/26
 * TODO: 6
 * TODO: implements and tests a Binary Search Tree & methods
 */

import java.lang.Comparable;

public class BSTTester {
	public static void main(String[] args) {

		BST tree = new BST();

		// test isEmpty on empyty tree
		System.out.println("=== Test isEmpty (empty tree) ===");
		System.out.println("isEmpty: " + tree.isEmpty());  // true
		System.out.println("size: " + tree.size());          // 0

		// add elements in specified order
		System.out.println("\n=== Adding elements: O R C H A R D Q U I N C E ===");
		String[] elements = {"O", "R", "C", "H", "A", "R", "D", "Q", "U", "I", "N", "C", "E"};
		for (String s : elements)
		{
			tree.add(s);
		} // end adding loop

		// test size and isEmpty after adding
		System.out.println("size: " + tree.size());          // 13
		System.out.println("isEmpty: " + tree.isEmpty());    // false

		// test all three traversals
		System.out.println("\n=== In Order Traversal ===");
		tree.printInOrder();

		System.out.println("\n=== Pre Order Traversal ===");
		tree.printPreOrder();

		System.out.println("\n=== Post Order Traversal ===");
		tree.printPostOrder();

		// test find
		System.out.println("\n=== Test find ===");
		System.out.println("find 'H': " + tree.find("H"));   // true
		System.out.println("find 'Z': " + tree.find("Z"));   // false
		System.out.println("find 'A': " + tree.find("A"));   // true
		System.out.println("find 'O': " + tree.find("O"));   // true (root)
		System.out.println("find 'X': " + tree.find("X"));   // false

		// test delete - leaf node
		System.out.println("\n=== Test delete (leaf node 'A') ===");
		System.out.println("delete 'A': " + tree.delete("A"));  // true
		System.out.println("size after delete: " + tree.size()); // 12
		System.out.println("find 'A' after delete: " + tree.find("A")); // false
		System.out.print("In Order after deleting 'A': ");
		tree.printInOrder();

		// test delete - node with one child
		System.out.println("\n=== Test delete (node with children 'D') ===");
		System.out.println("delete 'D': " + tree.delete("D"));  // true
		System.out.println("size after delete: " + tree.size()); // 11
		System.out.print("In Order after deleting 'D': ");
		tree.printInOrder();

		// test delete - node with two children
		System.out.println("\n=== Test delete (node with two children 'R') ===");
		System.out.println("delete 'R': " + tree.delete("R"));  // true
		System.out.println("size after delete: " + tree.size()); // 10
		System.out.print("In Order after deleting 'R': ");
		tree.printInOrder();

		// test delete - element not in tree
		System.out.println("\n=== Test delete (element not in tree 'Z') ===");
		System.out.println("delete 'Z': " + tree.delete("Z"));  // false
		System.out.println("size unchanged: " + tree.size());    // 10

		// test delete - root node
		System.out.println("\n=== Test delete (root node 'O') ===");
		System.out.println("delete 'O': " + tree.delete("O"));  // true
		System.out.println("size after delete: " + tree.size()); // 9
		System.out.print("In Order after deleting root: ");
		tree.printInOrder();

		// test replace - element exists
		System.out.println("\n=== Test replace (existing 'H' with 'M') ===");
		System.out.println("replace 'H' with 'M': " + tree.replace("H", "M"));  // true
		System.out.println("find 'H' after replace: " + tree.find("H"));         // false
		System.out.println("find 'M' after replace: " + tree.find("M"));         // true
		System.out.println("size after replace: " + tree.size());                 // 9
		System.out.print("In Order after replace: ");
		tree.printInOrder();

		// test replace - element does not existt
		System.out.println("\n=== Test replace (non-existing 'Z' with 'B') ===");
		System.out.println("replace 'Z' with 'B': " + tree.replace("Z", "B"));  // false
		System.out.println("find 'B' after replace: " + tree.find("B"));         // true
		System.out.println("size after replace: " + tree.size());                 // 10
		System.out.print("In Order after replace: ");
		tree.printInOrder();

		// final state
		System.out.println("\n=== Final Tree State ===");
		System.out.println("size: " + tree.size());
		System.out.println("isEmpty: " + tree.isEmpty());
		System.out.print("Final In Order: ");
		tree.printInOrder();

	} // end main
} // end BSTTester class
