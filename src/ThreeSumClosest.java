import java.util.Arrays;


public class ThreeSumClosest {
public int threeSumClosest(int[] num, int target) {
       	int gap = Integer.MAX_VALUE;
       	int closest = Integer.MAX_VALUE;
       	Arrays.sort(num);
       	for(int i=0; i<num.length-2; i++){
       		int head = i+1;
       		int tail = num.length-1;
       		int left_sum = target - num[i];
       		while(head<tail){
       			if(num[head]+num[tail] == left_sum){
       				return target;
       			}
       			if(Math.abs(left_sum - num[head]-num[tail]) < gap){
       				closest = num[i] + num[head] + num[tail];
       				gap = Math.abs(left_sum - num[head]-num[tail]);
       			}
       			
       			if(num[head]+num[tail] < left_sum){
       				head++;
       			}else{
       				tail--;
       			}
       			
       		}
       	}
       return closest;
    }
}
