import java.util.ArrayList;
import java.util.List;

import SumRoot2LeafNumbers.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode node = root;
		int cumSum = 0;
		while(node != null){
			list.add(node);
			cumSum += node.val;
			if(node.left != null){
				node = node.left;
			}else{
				node = node.right;
			}
		}
		TreeNode last_visited = null;
		while(list.size() > 0){
			node = list.get(list.size()-1);
			if(node.left == null && node.right == null){
				last_visited = node;
				if(cumSum == sum){
					List<Integer> vals = new ArrayList<Integer>();
					for(TreeNode n: list){
						vals.add(n.val);
					}
					result.add(vals);
				}
				cumSum -= node.val;
				list.remove(list.size()-1);
			}else{
				if(node.right == null || node.right == last_visited){
					cumSum -= node.val;
					list.remove(list.size()-1);
					last_visited = node;
				} else{
					node = node.right;
					while(node != null){
						cumSum += node.val;
						list.add(node);
						if(node.left != null){
							node = node.left;
						}else{
							node = node.right;
						}
					}
				}
			}
		}
		return result;
		
		
	}
}
