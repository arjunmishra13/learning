package practice.algorithms.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PracticePriorityQueue {
  class Ticker {
    String name;
    int count;
    Ticker(String name) {
      this.name = name;
      count = 0;
    }
    private void increment() {
      this.count++;
    }
    @Override
    public String toString() {
      return name + "," + count;
    }
  }
  PriorityQueue<Ticker> pheap;
  int k;
  Map<String, Ticker> tmap;
  PracticePriorityQueue(int k) {
    this.k = k;
    pheap = new PriorityQueue<Ticker>(tickerComparator);
    tmap = new HashMap<String, Ticker>();
  }

  private Comparator<Ticker>tickerComparator = new Comparator<Ticker>() {
    @Override
    public int compare(Ticker o1, Ticker o2) {
      return Integer.compare(o1.count, o2.count);
    }
  };

  //O(K)
  public void addTicker(String ticker) {

    //O(1)
    if (!tmap.containsKey(ticker)) {
      tmap.put(ticker, new Ticker(ticker));
    }

    //Check if its in the queue
    //O(1)
    Ticker curr = tmap.get(ticker);

    if (pheap.remove(curr)) {//O(K)
      curr.increment();
      pheap.add(curr); //O(Log(K))
      return;
    } else if (pheap.size() < this.k) {
      curr.increment();
      pheap.add(curr); //O(Log(K))
      return;
    } else

    curr.increment();
    //Check if top is less than this. If yes extract and add new
    Ticker top = pheap.peek();
    if (top.count < curr.count) {
      pheap.remove(); //O(K)
      pheap.add(curr); //O(Log(K))
    }
  }

  //O(K)
  public List<Ticker> topK() {
    List<Ticker>top = new LinkedList<Ticker>();
    Iterator<Ticker> tickerIterator = pheap.iterator();
    while (tickerIterator.hasNext()) {
      top.add(tickerIterator.next());
    }

    return top;
  }

  public static void main(String[]args) {
    PracticePriorityQueue p = new PracticePriorityQueue(5);
    String[]arr = {"b","i","v","x","i","p","u","f","s","r","i","x","j","o","j","i","u","p","n","u","p","t","e","n","z","o","z","n","x","s","a","d","o","j","k","v","e","z","n","w","f","z","i","u","s","l","h","e","e","q","j","h","b","t","t","j","u","x","n","p","d","r","j","q","l","n","e","g","b","o","g","o","n","b","l","h","s","x","f","i","e","c","f","w","a","n","p","n","q","j","r","n","m","i","k","n","q","r","y","a","k","k","x","r","h","u","e","e","i","b","d","h","u","u","o","o","i","a","a","q","e","i","f","i","q","l","c","k","a","f","f","s","h","v","m","d","u","b","r","h","j","b","g","s","i","l","b","y","n","o","t","n","k","x","s","x","d","d","b","h","v","w","o","v","w","z","l","o","u","t","r","b","h","s","g","w","f","x","o","b","c","v","i","g","c","s","a","b","s","p","j","p","l","k","u","p","w","v","v","n","n","o","t","x","r","b","d","y","f","r","d","w","z","h","x","y","h","y","q","j","q","x","f","f","w","u","k","r","g","t","p","v","z","b","e","i","m","n","i","l","x","c","n","x","b","c","x","s","t","p","f","c","x","a","r","l","k","l","l","y","w","v","o","i","d","x","y","i","r","w","t","l","e","r","x","s","y","q","o","o","y","e","o","h","z","u","b","f","f","t","w","a","h","t","w","h","y","m","m","o","l","c","c","c","k","y","c","k","y","p","c","f","p","v","q","x","b","b","c","p","w","n","n","u","u","x","d","e","r","z","w","w","c","q","x","s","d","y","a","c","b","f","u","v","t","t","d","x","v","p","z","d","a","b","d","q","y","t","u","v","a","o","m","r","u","p","a","c","d","h","s","k","t","g","s","y","x","o","v","f","d","s","j","l","v","s","l","z","n","k","h","w","o","p","o","s","w","w","d","x","j","y","s","w","v","d","b","g","q","h","h","z","d","n","v","e","e","a","y","k","j","i","j","q","b","i","t","m","y","x","d","j","n","r","z","y","h","m","d","s","u","c","e","o","v","b","v","q","d","y","k","l","u","c","g","y","y","p","n","x","x","e","t","j","y","z","j","i","c","v","q","w","k","u","z","a","u","r","a","m","d","t","h","a","u","q","h","k","f","m","k","t","b","a","k","d","x","b","b","u","a","v","y","b","r","p","s","z","a","c","l","q","w","v","r","n","t","o","r","a","x","k","d","v","t","r","y","h","d","g","v","r","t","k","m","u","b","k","k","j","u","n","y","n","y","k","g","y","g","u","r","a","a","a","i","o","d","e","w","g","p","i","f","h","t","j","o","c","l","m","p","q","f","q","t","u","e","q","y","g","m","p","c","t","i","p","f","z","p","h","x","j","b","i","q","s","q","m","m","f","a","h","s","h","d","g","b","p","v","g","m","c","x","w","b","l","h","k","r","i","s","r","u","t","y","y","g","n","j","h","j","b","v","v","c","z","a","r","p","j","f","w","j","s","l","f","x","t","f","e","s","m","x","w","e","f","j","a","m","s","r","n","a","o","e","f","n","z","j","d","s","l","r","a","g","b","r","m","z","p","a","n","z","h","o","h","n","v","n","e","l","m","t","y","e","y","d","g","i","w","p","r","w","s","k","k","r","b","q","z","z","b","q","h","v","f","k","f","k","a","b","c","i","e","a","l","y","l","x","n","h","d","f","v","p","g","c","s","x","f","y","b","f","s","h","w","q","l","t","f","t","s","y","d","k","m","x","v","b","f","z","z","m","m","m","p","i","w","y","u","b","y","m","r","g","y","l","h","s","j","b","v","m","e","g","j","a","v","c","r","m","t","e","h","f","w","f","q","u","r","z","f","n","b","z","m","w","h","m","b","c","u","d","m","d","r","l","d","a","p","e","q","g","q","k","g","b","v","d","s","w","r","r","h","g","s","c","z","l","c","h","z","f","y","i","b","i","i","y","c","z","a","c","c","c","g","g","h","q","g","v","j","q","p","v","y","y","y","r","m","l","o","c","h","z","a","m","p","x","h","m","c","o","h","y","e","d","p","f","h","t","w","q","r","b","q","a","v","q","e","e","j","t","m","g","u","z","l","y","p","i","n","f","f","t","k","y","c","d","s","i","m","t","u","e","u","h","d","u","b","r","f","u","s","r","g","x","s","x","o","h","u","h","m","n","k","t","j","n","i","t","o","h","w","u","c","c","x","v","d","u","p","p","u","w","n","c","o","t","y","d","m","x","t","x","z","w","r","a","l","k","e","s","d","d","y","z","g","a","i","u","c","g","k","s","f","j","a","n","g"};
    int count = 10;
    for (String s: arr) {
      p.addTicker(s);
      if (count-- == 0) {
        System.out.println(p.topK());
        count = 100;
      }
    }
  }
}
