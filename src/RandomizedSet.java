import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {
    Map<Integer, Integer> indexToVal = new HashMap<>();
    int total = 0;
    Map<Integer, Integer> valToIndex = new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)){
            return false;
        }
        valToIndex.put(val, total);
        indexToVal.put(total, val);
        total ++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(valToIndex.containsKey(val)){
            Integer index = valToIndex.remove(val);
            indexToVal.remove(index);
            if(index != total-1){
                int change = indexToVal.get(total-1);
                indexToVal.put(index, change);
                valToIndex.put(change, index);
                indexToVal.remove(total-1);
            }
            total --;
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int i = (int) Math.random() * total;
        return indexToVal.get(i);
    }
}
