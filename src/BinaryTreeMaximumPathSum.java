import java.util.Stack;

import SumRoot2LeafNumbers.TreeNode;

public class BinaryTreeMaximumPathSum {
	
	public int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
	    maxPathSumOfEither(root);
		return max;
		
	}
	
	public int maxPathSumOfEither(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = maxPathSumOfEither(root.left);
		int right = maxPathSumOfEither(root.right);
		int total_sum = root.val + left + right;
		int temp = Math.max(root.val, Math.max(left,right) + root.val);
		max = Math.max(max, Math.max(total_sum, temp));
		return temp;
		
	}
	
	public int maxPathSumSlow(TreeNode root) {
		if(root == null){
			return 0;
		}
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		int max = 0;
		while(stack.empty() != true){
			node = stack.pop();
			max = Math.max(max, maxPathSumOfRoot(node));
			if(node.left != null){
				stack.push(node.left);
			}
			if(node.right != null){
				stack.push(node.right);
			}
		}
		return max;
		
		
	}
	
	public int maxPathSumOfRoot(TreeNode root){
		if (root.right == null && root.left == null){
			return root.val;
		}
		
		int max = root.val;
		if(root.left != null){
		    max += maxPathSumFromRootToLeaf(root.left);
		}
		if(root.right != null){
		    max += maxPathSumFromRootToLeaf(root.right);
		}
		return max;
	}
	
	public int maxPathSumFromRootToLeaf(TreeNode root){
		if(root == null){
			return 0;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
	
		int curSum = 0;
		int max = 0;
		while(node != null){
			stack.push(node);
			curSum += node.val;
			if (node.left != null) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		TreeNode last_visited = null;
		while(stack.empty() != true){
			node = stack.peek();
			if(node.left == null && node.right == null ){
				max = Math.max(max, curSum);
				stack.pop();
				curSum -= node.val;
				continue;
			}
			if(node.right == null || node.right == last_visited){
				stack.pop();
				curSum -= node.val;
				last_visited = node;
				continue;
			}
			
			node = node.right;
			while(node != null){
				stack.push(node);
				curSum += node.val;
				if (node.left != null) {
					node = node.left;
				} else {
					node = node.right;
				}
			}
			
		}
		
		return max;
	}
}
