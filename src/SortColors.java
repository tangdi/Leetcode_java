
public class SortColors {
	 public void sortColors(int[] A) {
		 int reds = 0;
		 int whites = 0;
		 int blues = 0;
		 for(int i: A ){
			 if (i ==0) {
				 reds++;
				 continue;
			 }
			 if (i ==1) {
				 whites++;
				 continue;
			 }
			 if (i ==2) {
				 blues++;
				 continue;
			 }
		 }
		 
		 for(int i = 0; i< reds; i++){
			 A[i] = 0;
		 }
		 for(int i = reds; i< reds+whites; i++){
			 A[i] = 1;
		 }
		 for(int i = reds+whites; i< A.length; i++){
			 A[i] = 2;
		 }
		 
	        
	    }
}
