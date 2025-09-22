package Interview150.Tree.Binary_Tree;





class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Invert_Binary_Tree_226 {


	public TreeNode invertTree(TreeNode root) {

		traversalInvert(root);
		return root;

	}


	public static void traversalInvert(TreeNode root)
	{

		if(root != null)
		{
			if( root.left != null && root.right != null)
			{
				TreeNode temp = root.right;
				root.right = root.left;
				root.left = temp;
				traversalInvert(root.left);
				traversalInvert(root.right);

			}
			else if(root.left != null)
			{
				root.right = root.left;
				root.left = null;
				traversalInvert(root.right);
			}
			else if(root.right != null)
			{
				root.left = root.right;
				root.right = null;
				traversalInvert(root.left);
			}
		}


	}
}
