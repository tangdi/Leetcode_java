
public class EditDistance {
	
	public int findMin(String word1, String word2){
		if(word2.length() ==0 ){
			return 0;
		}
/*		if(word1.length() == word2.length()){
			int count =0;
			for (int i = 0; i < word1.length())
		}*/
		
		int min = word2.length();
		for(int i =0; i<=word1.length() - word2.length(); i++){
			
			int currentMin = word1.charAt(i) == word2.charAt(0)? findMin(word1.substring(i+1), word2.substring(1)) :  1 + findMin(word1.substring(i+1), word2.substring(1)); 
			if(currentMin ==0){
				return 0;
			}
			min = Math.min(min, currentMin);
			
		}
		return min;
	}
	public int minDistance(String word1, String word2) {
		if(word1.equals(word2)){
			return 0;
		}
		int necessary_step = word1.length() > word2.length()? word1.length() - word2.length(): word2.length() - word1.length();
		if(word1.length() > word2.length()){
			return necessary_step + findMin(word1, word2);
		}
		System.out.println("here");
		return necessary_step + findMin(word2, word1);
		
		
    }
	
	public static void main(String[] args) {
		EditDistance s1 = new EditDistance();
		String word1 = "trinitrophenylmethylnitramine";
		String word2 = "dinitrophenylhydrazine";
		System.out.println(s1.minDistance(word1, word2));
	}
}
