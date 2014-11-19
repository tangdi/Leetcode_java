import java.util.ArrayList;

public class SumRoot2LeafNumbers {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	ArrayList<Integer> sums = new ArrayList<Integer>();
	StringBuilder sum = new StringBuilder();

	public int sumNumbers(TreeNode root) {
		
		iterateNode(root);
		int sum = 0;
		for (Integer oneSum: sums){
			sum += oneSum;
		}
		return sum;

	}

	public void iterateNode(TreeNode node) {
		if (node == null)
			return;
		sum.append(node.val);
		
		if (node.left != null){
			iterateNode(node.left);
		}
		
		if (node.right != null){
			iterateNode(node.right);
		}
		
		if (node.right == null && node.left == null){
			sums.add(Integer.parseInt(sum.toString()));
		}
		sum.deleteCharAt(sum.length()-1);

	}

}
