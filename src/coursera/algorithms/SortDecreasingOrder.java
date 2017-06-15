package coursera.algorithms;

import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

/**
 * Using greedy algorithms
 * @author amishra
 *
 */
public class SortDecreasingOrder {

	public String sort(Vector<Integer>v) {
		String outStr = StringUtils.EMPTY;
		while( !v.isEmpty() ) {
			Integer max = getMax(v);
			outStr += Integer.toString(max);
			v.remove(max);
		}
		
		return outStr;
	}
	private Integer getMax(Vector<Integer> v) {
		int max= Integer.MIN_VALUE;
		for(int i=0;i<v.size();i++) {
			if(max < v.get(i)) {
				max = v.get(i);
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		Vector<Integer>v = new Vector<Integer>();
		v.add(4);
		v.add(1);
		v.add(9);
		v.add(9);
		v.add(9);
		v.add(3);
		v.add(3);
		v.add(3);
		v.add(3);
		v.add(3);
		v.add(3);
		v.add(3);
		v.add(2);
		
		SortDecreasingOrder sortObject = new SortDecreasingOrder();
		System.out.println(sortObject.sort(v));
	}
}
