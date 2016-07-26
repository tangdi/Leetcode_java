import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * ClassName: BinaryTreeRightSideView Function: TODO
 *
 * @Author: dtang
 * @Date: 7/26/16, 11:18 AM
 */
public class BinaryTreeRightSideView {
    Map<Integer, List<Integer>> map = new TreeMap<>();

    public List<Integer> rightSideView(SumRoot2LeafNumbers.TreeNode root) {
        if(root == null) return new ArrayList();
        List<Integer> result = new ArrayList();
        allNodes(root, 0);
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            result.add(entry.getValue().get(entry.getValue().size()-1));
        }
        return result;
    }
    private void allNodes(SumRoot2LeafNumbers.TreeNode root, int height){
        if(map.containsKey(height)){
            map.get(height).add(root.val);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(height, list);
        }
        if(root.left != null){
            allNodes(root.left, height +1);
        }
        if(root.right != null){
            allNodes(root.right, height +1);
        }

    }

    public static void main(String[] args) {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
    }

}
