import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null){
			return node;
		}
		UndirectedGraphNode head = node;
		UndirectedGraphNode newHead = null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		
		Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
		stack.push(node);
		while(stack.empty() == false){
			node = stack.pop();
			if(map.containsKey(node.label)){
				if(map.get(node.label).neighbors.size() == 0){
					for(UndirectedGraphNode n: node.neighbors){
						if(!map.containsKey(n.label)){
							map.put(n.label, new UndirectedGraphNode(n.label));
						}
						map.get(node.label).neighbors.add(map.get(n.label));
						if(n == node){
							continue;
						}
						stack.push(n);
					}
				}
				continue;
			}
			UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
			if(newHead == null){
				newHead = newNode;
			}
			map.put(node.label, newNode);
		
			for(UndirectedGraphNode n: node.neighbors){
				if(!map.containsKey(n.label)){
					map.put(n.label, new UndirectedGraphNode(n.label));
				}
				newNode.neighbors.add(map.get(n.label));
			
				if(n == node){
					continue;
				}
				stack.push(n);
			}
		}
		
	
		return newHead;
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
}
