public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] resultArray = new int[numCourses];
		int count = 0;
		int[] empty = {};
		if (numCourses == 0) {

			return empty;
		}
		boolean[] finishableCourses = new boolean[numCourses];
		Map<Integer, List<Integer>> relation = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < prerequisites.length; i++) {
			if (relation.containsKey(prerequisites[i][0])) {
				relation.get(prerequisites[i][0]).add(prerequisites[i][1]);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(prerequisites[i][1]);
				relation.put(prerequisites[i][0], list);
			}
		}

		for (int i = 0; i < finishableCourses.length; i++) {
			if (!relation.containsKey(i)) {
				finishableCourses[i] = true;
				numCourses--;
				resultArray[count++] = i;
			}
		}

		while (numCourses > 0) {
			boolean reduce = false;
			Set<Integer> to_be_remove = new HashSet<Integer>();
			for (Map.Entry<Integer, List<Integer>> entry : relation.entrySet()) {
				boolean finishable = true;
				List<Integer> list = entry.getValue();
				for (Integer n : list) {
					if (!finishableCourses[n]) {
						finishable = false;
						break;
					}
				}
				if (finishable) {
					finishableCourses[entry.getKey()] = true;
					numCourses--;
					reduce = true;
					resultArray[count++] = entry.getKey();
					to_be_remove.add(entry.getKey());

				}
			}
			if (!reduce) {

				return empty;
			}
			for (Integer i : to_be_remove) {
				relation.remove(i);
			}
		}

		return resultArray;

	}
}
