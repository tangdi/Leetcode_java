public class ValidateParentheses {
	public boolean isValid(String s) {
		Set<Character> start = new HashSet<Character>();
		Set<Character> end = new HashSet<Character>();
		Map<Character, Character> match = new HashMap<Character, Character>();

		start.add('(');
		start.add('[');
		start.add('{');
		end.add(')');
		end.add(']');
		end.add('}');
		match.put('(', ')');
		match.put('[', ']');
		match.put('{', '}');
		Deque<Character> start_stack = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (start.contains(s.charAt(i))) {
				start_stack.push(s.charAt(i));
			} else {
				if (start_stack.isEmpty()) {
					return false;
				}
				Character c = start_stack.poll();
				if (match.get(c) != s.charAt(i)) {
					return false;
				}
			}
		}
		if (start_stack.isEmpty()) {
			return true;
		}
		return false;
		
	}
}
