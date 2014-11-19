import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderII {
	List<List<String>> result;
	boolean[] visited;
	String[] dict_list;
	int minimum_len = Integer.MAX_VALUE;
	
	
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		result = new ArrayList<List<String>>();
		dict.add(end);
		
		
		Set<String> layer = new HashSet<String>();
		List<Set<String>> layers = new ArrayList<Set<String>>();
		
		layer.add(start);
		layers.add(layer);
		boolean exist = false;;
		while(true){
			layer = new HashSet<String>();
			for(String word: layers.get(layers.size()-1)){
				
				for(int i=0; i<word.length();i++){
					char[] charArray = word.toCharArray();
					for(char c='a'; c<'z'; c++){
						charArray[i] = c;
						String newString = new String(charArray);
						if(dict.contains(newString)){
							layer.add(newString);
						}
					}	
				}
				
			}
			layers.add(layer);
			if(layer.contains(end)){
				exist=true;
				break;
			}
			if(layer.isEmpty()){
				break;
			}
			
			for(String word: layer){
				dict.remove(word);
			}
			
		}
		if(!exist){
			return result;
		}
		layers.remove(layers.size()-1);
		layer = new HashSet<String>();
		layer.add(end);
		layers.add(layer);
		
		List<String> pathArray = new ArrayList<String>();
		pathArray.add(start);
		DFSHelper(layers, pathArray);
		
		return result;

	}
	
	public void DFSHelper(List<Set<String>> layers, List<String> pathArray){
		
		if (pathArray.size() == layers.size()){
			result.add(new ArrayList<String>(pathArray));
			return;
		}
		
		String word =pathArray.get(pathArray.size()-1);

			for(int i=0; i<word.length();i++){
				char[] charArray = word.toCharArray();
				for(char c='a'; c<'z'; c++){
					charArray[i] = c;
					String newString = new String(charArray);
					if(layers.get(pathArray.size()).contains(newString)){
						pathArray.add(newString);
						DFSHelper(layers, pathArray);
						pathArray.remove(pathArray.size()-1);
						
					}
				}	
			}
			
		
		
		
	}

	public List<List<String>> findLaddersBFS(String start, String end,
			Set<String> dict) {
		result = new ArrayList<List<String>>();
		dict.add(end);
		
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<List<String>> pathQueue = new LinkedList<List<String>>();
		List<String> path = new ArrayList<String>();
		Set<String> layer = new HashSet<String>();
		Integer layer_num = null;
		path.add(start);
		wordQueue.add(start);
		pathQueue.add(path);
		//as delimiter
		wordQueue.add(null);
		
		
		while(!wordQueue.isEmpty()){
			String word = wordQueue.pop();
			if(word == null){
				if (!wordQueue.isEmpty()){
					wordQueue.add(null);
					for(String str: layer){
						dict.remove(str);
					}
					layer.clear();
				}
				continue;
			}
			layer.add(word);
			
			List<String> prev_path = pathQueue.pop();
			if(layer_num != null && layer_num<prev_path.size()){
				break;
			}
			
			if(word.equals(end)){
				if(layer_num == null){
					layer_num=prev_path.size();
				}
				result.add(prev_path);
				continue;
			}
			
			for(int i=0; i<word.length();i++){
				char[] charArray = word.toCharArray();
				for(char c='a'; c<'z'; c++){
					charArray[i] = c;
					String newString = new String(charArray);
					if(dict.contains(newString)){
						wordQueue.add(newString);
						List<String> newPath = new ArrayList<String>(prev_path);
						newPath.add(newString);
						pathQueue.add(newPath);
					}
				}	
			}
		}
		
		
		return result;

	}

	public List<List<String>> findLaddersDFS(String start, String end,
			Set<String> dict) {
		result = new ArrayList<List<String>>();
		dict_list = dict.toArray(new String[dict.size()]);

		visited = new boolean[dict_list.length];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		List<String> currentResult = new ArrayList<String>();
		currentResult.add(start);
		helper(start, end, currentResult);
		return result;

	}

	public boolean isOneCharDiff(String word1, String word2) {
		if(word1.equals(word2)){
			return false;
		}
		int diff = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				if ((++diff) > 1) {
					return false;
				}
			}
		}
		return true;

	}

	public void helper(String start, String end, List<String> currentResult) {
		for (int i = 0; i < dict_list.length; i++) {
			if (visited[i] == false
					&& isOneCharDiff(dict_list[i], start)
					&& (currentResult.size() == 1 || currentResult.size() <= minimum_len - 2)) {
				currentResult.add(dict_list[i]);

				if (isOneCharDiff(dict_list[i], end)) {
					currentResult.add(end);

					result.add(new ArrayList<String>(currentResult));
					minimum_len = currentResult.size();
					currentResult.remove(currentResult.size() - 1);
				} else {
					visited[i] = true;
					helper(dict_list[i], end, currentResult);
					visited[i] = false;
				}
				currentResult.remove(currentResult.size() - 1);

			}
		}
	}

	public static void main(String[] args) {
		WordLadderII s1 = new WordLadderII();
		String start = "hit";
		String end = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log" };
		HashSet<String> dict = new HashSet<String>(Arrays.asList(words));
		System.out.println(s1.findLadders(start, end, dict));
	}
}
