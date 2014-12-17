import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MaximumGap {
	public int maximumGapUseNonLinearMemory(int[] num) {
        if(num == null || num.length <2){
            return 0;
        }
        
        int max = 0;
       
        for(int i: num){
        	max = Math.max(max, i);
        }
        
        boolean[] array = new boolean[max];
        for(int i=0; i<array.length; i++){
        	array[i] =false;
        }
        for(int i:num){
        	array[i-1] = true;
        }
        
        int gap = 0;
        int maxGap = 0;
        for(int i=array.length-1; i>=0 ; i--){
        	if(array[i]){
        		if (gap > 0){
        			gap ++;
        			maxGap = Math.max(gap, maxGap);
        			gap = 0;
        		}
        		continue;
        	}
        	gap ++;
        }
        
        return maxGap;
    }
	public int maximumGap(int[] num) {
		if(num == null || num.length <2){
            return 0;
        }
		int n = num.length;
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		int max = Integer.MIN_VALUE;
		int max_index = -1;
		
		for(int i = 0 ;i <n; i++){
        	if( num[i] > max){
        		max = num[i];
        		max_index = i;
        	}
        	
        	if(num[i] < min){
        		min = num[i];
        		min_index = i;
        	}
        }
		System.out.println(max);
		System.out.println(min);
		
		double d = ((double)(max - min)) / (n-1);
		
		List<Set<Integer>> buckets = new ArrayList<Set<Integer>>();
		
		for(int i=1; i<= n-1; i++ ){
			buckets.add(new HashSet<Integer>());
		}
		
		for(int i = 0 ;i <n; i++){
			if( i!= max_index && i != min_index){
				buckets.get( (int) ((num[i] - min)/d)).add(num[i]);
			}
		}
		
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		for(Set<Integer> set: buckets){
			if (set.isEmpty()){
				pairs.add(null);
				continue;
			}
			
			int bucket_min = Integer.MAX_VALUE;
			int bucket_max = Integer.MIN_VALUE;
			for (Integer i: set){
				bucket_min = Math.min(bucket_min, i);
				bucket_max = Math.max(bucket_max, i);
			}
			List<Integer> pair = new ArrayList<Integer>();
			pair.add(bucket_min);
			pair.add(bucket_max);
			pairs.add(pair);
		}
		int maxGap = 0;
		int prevMax = min;
		for(List<Integer> pair: pairs){
			if(pair == null){
				continue;
			}
			int gap = pair.get(0) - prevMax;
			maxGap = Math.max(maxGap, gap);
			prevMax = pair.get(1);
		}
		maxGap = Math.max(maxGap, max - prevMax);
		
		return maxGap;
		
	}
	
	public static void main(String[] args) {
		MaximumGap s1 = new MaximumGap();
		int[] num ={1,3, 9};
		System.out.println(s1.maximumGap(num));
	}
}
