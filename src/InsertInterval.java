import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class InsertInterval {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			List<Interval> result = new ArrayList<Interval>();
			result.add(newInterval);
			return result;
		}
		if (newInterval == null)
			return intervals;
		List<Interval> result = new ArrayList<Interval>();
		if (newInterval.end < intervals.get(0).start) {
			result.add(newInterval);
			for (Interval i : intervals) {
				result.add(i);
			}
			return result;
		} 
		
		if(newInterval.start > intervals.get(intervals.size()-1).end){
			for (Interval i : intervals) {
				result.add(i);
			}
			result.add(newInterval);
			return result;
		}
		
		
		int head = newInterval.start;
		int tail = newInterval.end;
		boolean contact = false;
		int i;
		for (i = 0; i < intervals.size(); i++) {

			if (intervals.get(i).end >= head && intervals.get(i).start <= tail) {
				Interval one = intervals.get(i);
				head = Math.min(head, one.start);
				tail = Math.max(tail, one.end);
				contact = true;

			} else {

				
				if (contact) {
					break;
				}
				result.add(intervals.get(i));
			}
		}
		result.add(new Interval(head, tail));
		for(; i<intervals.size();i++){
			result.add(intervals.get(i));
		}
		Collections.sort(result, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				if(i1.start<i2.start){
					return -1;
				}
				return 0;
				
			}
		});

		return result;
	}

}
