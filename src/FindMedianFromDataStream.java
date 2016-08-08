/**
 * ClassName: FindMedianFromDataStream Function: TODO
 *
 * @Author: dtang
 * @Date: 8/8/16, 11:07 AM
 */
public class FindMedianFromDataStream {
    public class MedianFinder {
        PriorityQueue<Integer> small = new PriorityQueue();
        PriorityQueue<Integer> large = new PriorityQueue();
        // Adds a number into the data structure.
        public void addNum(int num) {
            Integer median = small.peek();
            if(median == null || median >= num){
                large.add(-num);
            }else{
                small.add(num);
            }
            rebalanceQueue();
        }
        private void rebalanceQueue(){
            while(Math.abs(small.size() - large.size()) >1){
                boolean smallHasMore = small.size() > large.size();
                if(smallHasMore){
                    large.add(-small.poll());
                }else{
                    small.add(-large.poll());
                }
            }
            return;
        }

        // Returns the median of current data stream
        public double findMedian() {
            if(small.size() == large.size()){
                return ((double) (small.peek() - large.peek()))/2;
            }
            return small.size() > large.size()? small.peek(): -large.peek();
        }
    };
}
