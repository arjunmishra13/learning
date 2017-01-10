package coursera.algorithms;

public class Item<W extends Number, V extends Number> {
	W weight;
	V value;

	public Item(W weight, V value) {
		this.weight = weight;
		this.value = value;
	}
	
	public double getDensity() {
		return weight.doubleValue() == 0d?0:value.doubleValue()/weight.doubleValue();
	}
	
	public String toString() {
		return weight.toString() + "\t" + value.toString();
	}
}
