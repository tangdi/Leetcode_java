import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: WiggleSortII Function: TODO
 *
 * @Author: dtang
 * @Date: 7/26/16, 5:05 PM
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length ==0) return;
        Arrays.sort(nums);
        List<Integer> history = new ArrayList<>();
        if(nums.length%2 ==0){
            int i=nums.length/2-1,j=nums.length-1;
            while(i>=0){
                history.add(nums[i]);
                history.add(nums[j]);
                i--;
                j--;
            }
        }else{
            int i=nums.length/2,j=nums.length-1;
            while(i>0){
                history.add(nums[i]);
                history.add(nums[j]);
                i--;
                j--;
            }
            history.add(nums[0]);
        }
        for(int i=0; i<history.size(); i++){
            nums[i] = history.get(i);
        }

    }
}
