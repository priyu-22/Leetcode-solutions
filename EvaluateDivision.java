package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> equations = new ArrayList<>();
		List<String> eqn = new ArrayList<>();
		eqn.add("a");
		eqn.add("b");
		equations.add(eqn);
		eqn = new ArrayList<>();
		eqn.add("b");
		eqn.add("c");
		equations.add(eqn);
		double[] values = {2.0,3.0};
		List<List<String>> queries = new ArrayList<>();
		List<String> qry = new ArrayList<>();
		qry.add("a");
		qry.add("c");
		queries.add(qry);
		qry = new ArrayList<>();
		qry.add("b");
		qry.add("a");
		queries.add(qry);
		qry = new ArrayList<>();
		qry.add("a");
		qry.add("e");
		queries.add(qry);
		qry = new ArrayList<>();
		qry.add("a");
		qry.add("a");
		queries.add(qry);
		qry = new ArrayList<>();
		qry.add("x");
		qry.add("x");
		queries.add(qry);
		double[] ans = calcEquation(equations, values, queries);
		System.out.println(ans);

	}
	
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i=0; i<equations.size(); i++) {
        	List<String> eqn = equations.get(i);
        	String val1 = eqn.get(0);
        	String val2 = eqn.get(1);
        	double res = values[i];
        	if(!map.containsKey(val1)) {
        		map.put(val1, new HashMap<>());
        	}
        	if(!map.containsKey(val2)) {
        		map.put(val2, new HashMap<>());
        	}
        	map.get(val1).put(val2, res);
        	map.get(val2).put(val1, 1/res);
        }
        
        for(int j =0; j< queries.size(); j++) {
        	List<String> qry = queries.get(j);
        	String val1 = qry.get(0);
        	String val2 = qry.get(1);
        	if(map.containsKey(val1) && map.containsKey(val2)) {
        		double res = getValues(map, val1, val2, 1, new ArrayList<String>());
        		//double res = dfs(map, val1, val2, 1, new HashSet<String>());
        		ans[j] = res;
        	}else {
        		ans[j] = -1;
        	}
        }
		
		return ans;
    }
	
	/*
	 * My method
	 * Logic: recurssion to calculate values
	 * param: map= map of all variables and their values
	 * 		  startNode= from variable
	 * 		  endNode= to variable
	 * 		  res= previous and current result
	 * 		  alreadyVisited= list of nodes variables already visited till startNode != endNode
	 */
	
	private static double getValues( Map<String, Map<String, Double>> map, String startNode, String endNode, double res, List<String> alreadyVisited) {
		if(startNode.equals(endNode)) return res;
		Map<String, Double> subMap = map.get(startNode);
		for(String s: subMap.keySet()) {
			if(alreadyVisited.contains(s)) continue;
			alreadyVisited.add(startNode);
			res *= subMap.get(s);
			if(s.equals(endNode)) {
				res = getValues(map, s, endNode, res, alreadyVisited);
			}else {
				 return res;
			}
			alreadyVisited.remove(s);
		}
		return res;
	}
	
	//Method from LC solutions
	private static double dfs(Map<String, Map<String, Double>> map, String start, String target, double r, Set<String> seen) {

		if (start.equals(target)) {
			return r;
		}
		Map<String, Double> m = map.get(start);
		for (String s : m.keySet()) {
			if (seen.contains(s)) {
				continue;
			}
			seen.add(s);
			double res = dfs(map, s, target, r * m.get(s), seen);
			if (res != -1) {
				return res;
			}
			seen.remove(s);
		}
		return -1;
	}

}
