//Name - Brayden Kim

import java.util.*;

public class GraphQ
{
	private HashMap<String, HashSet<String>> map;
	private boolean found;

	public GraphQ(String line)
	{
		map=new HashMap<>();
		String[] list = line.split(" ");
		for(String piece : list)
		{
			map.putIfAbsent(String.valueOf(piece.charAt(0)),new HashSet<>());
			map.get(String.valueOf(piece.charAt(0))).add(String.valueOf(piece.charAt(1)));
		}
		for(String piece : list)
		{
			map.putIfAbsent(String.valueOf(piece.charAt(1)), new HashSet<>());
			map.get(String.valueOf(piece.charAt(1))).add(String.valueOf(piece.charAt(0)));
		}
		found = false;
	}

	public boolean contains(String letter)
	{
		if(map.get(letter)==null)
	      return false;
	   return true;
	}

	public void check(String first, String second) {
		Queue<String> q = new LinkedList<>();
		Set<String> visit = new HashSet<>();

		q.add(first);
		visit.add(first);

		while (!q.isEmpty()) {
			String temp = q.poll();

			if (temp.equals(second)) {
				found = true;
				return;
			}

			for (String neighbor : map.get(temp)) {
				if (!visit.contains(neighbor)) {
					visit.add(neighbor);
					q.add(neighbor);
				}
			}
		}

		found = false;
	}

	public String toString()
	{
		if(found)
		   return "CONNECTS";
		return "DOES NOT CONNECT";
	}
}