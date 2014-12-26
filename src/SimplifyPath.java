public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] dirs = path.split("/");
		Deque<String> queue = new LinkedList<String>();

		for (String dir : dirs) {
			if (dir == null || dir.length() == 0) {
				continue;
			}
			if (dir.equals(".")) {
				continue;
			}
			if (dir.equals("..")) {
				queue.pollLast();
				continue;
			}

			queue.add(dir);
		}

		StringBuilder sb = new StringBuilder();
		for (String s : queue) {
			sb.append('/');
			sb.append(s);
		}
		String s = sb.toString();

		if (s.length() == 0) {
			return "/";
		}
		return s;
	}
}
