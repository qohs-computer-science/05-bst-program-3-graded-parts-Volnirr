/*
 * Represents a single node in a Binary Search Tree.
 * Each node stores a Comparable value and references to left and right children.
 */
public class TreeNode
{
	private TreeNode left;
	private TreeNode right;
	private Comparable value;

	/*
	 * Pre: initValue is not null
	 * Post: A TreeNode is created with the given value and null children
	 */
	public TreeNode(Comparable initValue)
	{
		value = initValue;
		left = null;
		right = null;
	} // single-arg constructor

	/*
	 * Pre: initValue is not null, initLeft and initRight may be null
	 * Post: A TreeNode is created with the given value and specified children
	 */
	public TreeNode(Comparable initValue, TreeNode initLeft, TreeNode initRight)
	{
		value = initValue;
		left = initLeft;
		right = initRight;

	public Comparable getValue()
	{
		return value;
	} // end getValue

	public TreeNode getLeft()
	{
		return left;
	} // end getLeft

	public TreeNode getRight()
	{
		return right;
	} // end getRight

	/*
	 * Pre: newValue is not null
	 * Post: the value of this node is set to newValue
	 */
	public void setValue(Comparable newValue)
	{
		value = newValue;
	} // end setValue

	public void setLeft(TreeNode newLeft)
	{
		left = newLeft;
	} // end setLeft

	public void setRight(TreeNode newRight)
	{
		right = newRight;
	} // end setRight

}
