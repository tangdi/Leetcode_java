import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		final int LEN = 10;
		Set<String> set = new HashSet<String>();
		Set<String> resultSet = new HashSet<String>();
		
		
		for(int i = 0; i + LEN <= s.length(); i++){
			String sub = s.substring(i, i+LEN);
			if(set.contains(sub)){
				resultSet.add(sub);
				continue;
			}
			
			set.add(sub);
		}
		List<String> result = new ArrayList<String>(resultSet);
		return result;
	}
	
	public static void main(String[] args) {
		RepeatedDNASequences s1 = new  RepeatedDNASequences();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(s1.findRepeatedDnaSequences(s));
	}
}
