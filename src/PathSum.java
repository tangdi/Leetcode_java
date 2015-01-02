import java.util.Stack;


public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		int memory = 0;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null) {
			memory += node.val;
			stack.push(node);
			if (node.left != null) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		TreeNode last_visited = null;
		while (!stack.empty()) {
			node = stack.peek();
			if (node.left == null && node.right == null) {
				last_visited = node;
				if (memory == sum) {
					return true;
				} else {
					stack.pop();
					memory -= node.val;
				}
			} else {
				if(node.right == null || last_visited == node.right ){
					last_visited = node;
					stack.pop();
					memory -= node.val;
					continue;
				} 
				node = node.right;
				while (node != null) {
					
					memory += node.val;
					stack.push(node);
					if (node.left != null) {
						node = node.left;
					} else {
						node = node.right;
					}
				}
			}

		}

		return false;

	}
}
