import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
		List<String> stringResult = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		if (words == null || words.length == 0)
			return stringResult;
		helper(result, words, 0, L);
		
		
		for( int i= 0 ; i< result.size()-1; i++){
			int sum = 0;
			List<String> oneLine = result.get(i);
			for(String s: oneLine){
				sum += s.length();
			}
			int spaceNum = L - sum;
			ArrayList<Integer> spaceDist = new ArrayList<Integer>();
			StringBuilder line = new StringBuilder();
			if(oneLine.size() ==1){
				line.append(oneLine.get(0));
				while(spaceNum-- >0){
					line.append(" ");
				}
				stringResult.add(line.toString());
				continue;
			}
			
			int n = oneLine.size()-1;
			while(n >0){
				spaceDist.add(0, spaceNum/n);
				spaceNum-=spaceNum/n;
				n--;
				
			}
			
			line.append(oneLine.get(0));
			for(int j = 1; j<oneLine.size(); j++){
				n = spaceDist.get(j-1);
				while(n-->0){
					line.append(" ");
				}
				line.append(oneLine.get(j));
			}
			stringResult.add(line.toString());
			
		}
		
		List<String> oneLine = result.get(result.size()-1);
		StringBuilder line = new StringBuilder();
		int sum = 0;
		for(String s: oneLine){
			sum += s.length();
		}
		int spaceNum = L - sum;
		line.append(oneLine.get(0));
		if (oneLine.size() ==1 ){
			int n = spaceNum;
			while(n-->0){
				line.append(" ");
			}
			stringResult.add(line.toString());
		}else{
			for(int j = 1; j<oneLine.size(); j++){
				line.append(" ");
				spaceNum--;
				line.append(oneLine.get(j));
			}
			int n = spaceNum;
			while(n-->0){
				line.append(" ");
			}
			stringResult.add(line.toString());
			
		}
		
		return stringResult;
	}

	void helper(List<List<String>> result, String[] words, int iter, int L) {
		if (iter >= words.length)
			return;
		List<String> oneLine = new ArrayList<String>();
		int sum = 0;

		while (iter<words.length && sum + words[iter].length()+ oneLine.size()<= L){
			oneLine.add(words[iter]);
			sum += words[iter].length();
			iter++;
		}
		result.add(oneLine);
		
		helper(result, words, iter, L);
		

	}
	
	public static void main(String[] args){
		TextJustification s1 = new TextJustification();
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."}; 
		String[] words = {""};
		int L = 0;
		System.out.println(s1.fullJustify(words, L));
	}

}
