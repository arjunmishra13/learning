package coursera.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Given N number of items each with weight w(i) and value v(i)
 * Given a knapsack with capacity weight W. Maximize the value of that bag without exceeding total weight
 * We can split an item into it's unit size, since this is fractional knapsack.
 * 
 * Greedy solution will give us the right answer. We sort items in decreasing order
 * of density (value/weight) and assign items unitl you can't fit anymore, then
 * move to a differnt product
 * </p>
 * @author mishra
 *
 */
public class FractionalKnapsack <W extends Number, V extends Number> {

	List<Item<W,V>>items;
	W maxWeight;
	public FractionalKnapsack(W maxWeight, List<Item<W,V>>items) {
		this.maxWeight = maxWeight; 
		this.items = items;
		Collections.sort(items, sortByDensity);
	}
	
	public double getMaxValue() {
		
		double totalValue = 0.0;;
		double weightCapacity = maxWeight.doubleValue();

		for(Item<W,V> it:items) {
			
			if(it.weight.doubleValue() <= weightCapacity) {
				totalValue += it.value.doubleValue();
				weightCapacity -= it.weight.doubleValue();
			} else {
				double fractionalValue = (weightCapacity)*it.getDensity();
				totalValue += fractionalValue;
				weightCapacity = 0;
			}
			if(weightCapacity == 0) {
				break;
			}
		}
		return totalValue;
	}
	
	public double getMaxRecursive(List<Item<W,V>>items, double weightCapacity, double maxValue) {
		
		if(weightCapacity == 0) {
			return maxValue;
		}
		
		Item<W,V>item = items.remove(0);
		if(item.weight.doubleValue() <= weightCapacity) {
			maxValue += item.value.doubleValue();
			weightCapacity -= item.weight.doubleValue();
		} else {
			double fractionalValue = (weightCapacity)*item.getDensity();
			maxValue += fractionalValue;
			weightCapacity = 0;
		}
		return getMaxRecursive(items, weightCapacity, maxValue);
		
	}
	
	public final Comparator<Item<W,V>> sortByDensity = new Comparator<Item<W,V>>() {

		@Override
		public int compare(Item<W, V> o1, Item<W, V> o2) {
			
			Double density1 = o1.weight.doubleValue() == 0d? 0.0:o1.value.doubleValue()/o1.weight.doubleValue();
			Double density2 = o2.weight.doubleValue() == 0d? 0.0:o2.value.doubleValue()/o2.weight.doubleValue();
			return density2.compareTo(density1);
		}
		
	};
	
	public static void main(String[] args) throws IOException {
		Integer maxWeight = 25;
		
		String fileName = "/Users/amishra/Scripts/input/knapsack.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		String line = bufferedReader.readLine();
		List<Item<Integer, Integer>>items = new LinkedList<Item<Integer, Integer>>();
		while(line != null) {
			String[] arr = line.split("\t");
			int weight = Integer.parseInt(arr[0]);
			int value = Integer.parseInt(arr[1]);
			Item<Integer, Integer>item = new Item<Integer, Integer>(weight, value);
			items.add(item);
			line = bufferedReader.readLine();
		}

		bufferedReader.close();
		FractionalKnapsack<Integer, Integer> fks = new FractionalKnapsack<Integer, Integer>(maxWeight, items);
		System.out.println(items.toString());
		System.out.println(fks.getMaxValue());
//		System.out.println(fks.getMaxRecursive(items, maxWeight, 0.0));
	}
}
