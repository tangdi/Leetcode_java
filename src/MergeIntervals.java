import java.util.List;

public class MergeIntervals {
	public static class Interval {
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

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		for (int i = 0; i < intervals.size(); i++) {
			for (int j = i + 1; j < intervals.size(); j++) {
				Interval result = merge(intervals.get(i), intervals.get(j));
				if (result != null) {
					intervals.remove(i);
					intervals.remove(j-1);
					intervals.add(0, result);
					return merge(intervals);
				}
			}
		}
		return intervals;
	}

	public Interval merge(Interval interval1, Interval interval2) {
		if (interval1.end < interval2.start || interval1.start > interval2.end) {
			return null;
		}
		return new Interval(Math.min(interval1.start, interval2.start),
				Math.max(interval1.end, interval2.end));

	}
}
