import java.util.List;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		List<TreeLinkNode> layer1 = new ArrayList<TreeLinkNode>();
		layer1.add(root);
		while (layer1.size() > 0) {
			List<TreeLinkNode> newLayer = new ArrayList<TreeLinkNode>();
			for (TreeLinkNode node : layer1) {
				if(node.left == null && node.right == null){
					continue;
				}
				if (newLayer.size() > 0) {
					newLayer.get(newLayer.size() - 1).next = node.left != null? node.left: node.right ;
				}
				if(node.left != null){
					newLayer.add(node.left);
					node.left.next = node.right;
				}
				
				if(node.right != null){
					newLayer.add(node.right);
				}
				
			}
			layer1 = newLayer;
		}
	}
}
