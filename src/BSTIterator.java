public class BSTIterator {
    TreeNode node;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        node = root;
        stack = new Stack<TreeNode>();
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode oldNode = stack.pop();
        node = oldNode.right;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        return oldNode.val;
    }
}