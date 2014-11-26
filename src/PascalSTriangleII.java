import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalSTriangleII {
	public List<Integer> getRow(int rowIndex) {

		List<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return result;
		}

		result.add(1);

		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> prev_row = result;

			Integer[] thisRow = new Integer[i + 1];
			thisRow[0] = 1;
			thisRow[i] = 1;
			for (int j = 1; j < i; j++) {
				thisRow[j] = prev_row.get(j) + prev_row.get(j - 1);
			}
			result = Arrays.asList(thisRow);
			
		}

		return result;

	}
	
	public static void main(String[] args){
		PascalSTriangleII s1 =new PascalSTriangleII();
		System.out.println(s1.getRow(0));
	}
}
