
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
	public int minDistanceSlow(String word1, String word2) {
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
	
	public int minDistance(String word1, String word2) {
		
		int[][] D = new int[word1.length() +1][word2.length()+1];// plus 1 because  D[i][j] means distance bwt first i characters of word1 and first j characters of word2.
		
		for(int i=0; i<=word1.length(); i++){
			for(int j=0; j<= word2.length(); j++){
				if(i == 0){
					D[i][j] = j;
					continue;
				}
				if(j == 0){
					D[i][j] = i;
					continue;
				}
				
				D[i][j] = Math.min(D[i-1][j] + 1, Math.min(D[i][j-1] + 1, D[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)? 0: 1)));
			}
		}
		
		return D[word1.length()][word2.length()];
		
		
    }
	
	public static void main(String[] args) {
		EditDistance s1 = new EditDistance();
		String word1 = "trinitrophenylmethylnitramine";
		String word2 = "dinitrophenylhydrazine";
		System.out.println(s1.minDistance(word1, word2));
	}
}
