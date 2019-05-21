package coursera.algorithms;


public class MedianInAStream {
  int[]minheap;
  int[]maxheap;
  int median;
  int mini;
  int maxi;

  public MedianInAStream(int n) {
    minheap = new int[n];
    maxheap = new int[n];
    mini = 0;
    maxi = 0;
    median = 0;
  }

  public void printmedian(int x) {

    if (x >= median) {
      minheap[mini] = x;
      shiftup(minheap, true, mini);
      mini++;
    } else if (x < median) {
      maxheap[maxi] = x;
      shiftup(maxheap, false, maxi);
      maxi++;
    }

    if (maxi - mini > 1) {
      int val = extract(maxheap, false, maxi);
      minheap[mini] = val;
      maxi--;
      shiftup(minheap, true, mini);
      mini++;
    } else if (mini - maxi > 1) {
      int val = extract(minheap, true, mini);
      mini--;
      maxheap[maxi] = val;
      shiftup(maxheap, false, maxi);
      maxi++;
    }

    if (mini > maxi) {
      median = minheap[0];
    } else if (maxi > mini) {
      median = maxheap[0];
    } else {
      median = (minheap[0] + maxheap[0])/2;
    }

    printheapsmedian();
  }

  private void printheapsmedian() {
    StringBuilder strbmin = new StringBuilder();
    for (int i = 0; i < mini; i++) {
      if (strbmin.length() == 0) {
        strbmin.append(minheap[i]);
      } else {
        strbmin.append(",").append(minheap[i]);
      }
    }
    StringBuilder strbmax = new StringBuilder();
    for (int i = 0; i < maxi; i++) {
      if (strbmax.length() == 0) {
        strbmax.append(maxheap[i]);
      } else {
        strbmax.append(",").append(maxheap[i]);
      }
    }

    System.out.println("MinHeap: " + strbmin.toString());
    System.out.println("MaxHeap: " + strbmax.toString());
    System.out.println("Median: " + median);
    System.out.println();
  }

  private int extract(int[]arr, boolean min, int size) {
    int val = arr[0];
    swap(arr, 0, size - 1);
    size--;
    shiftdown(arr, min, 0, size);

    return val;
  }

  private void shiftdown(int[]arr, boolean min, int i, int size) {

    if (2*i + 1 >= size) {
      return;
    }

    int nexti = 2*i + 1;
    if (2*i + 2 < size) {
      if (min) {
        nexti = arr[nexti] < arr[2*i + 2]? nexti:2*i + 2;
      } else {
        nexti = arr[nexti] > arr[2*i + 2]? nexti:2*i + 2;
      }
    }

    if (min && (arr[i] > arr[nexti])) {
        swap(arr, i, nexti);
        shiftdown(arr, min, nexti, size);
    } else if (!min && (arr[i] < arr[nexti])){
      swap(arr, i, nexti);
      shiftdown(arr, min, nexti, size);
    } else {
      return;
    }
  }

  private void shiftup(int[]arr, boolean min, int i) {

    if (i == 0) {
      return;
    }

    int parent = i%2==0? i/2 - 1:i/2;
    if (min) {
      if (arr[parent] > arr[i]) {
        swap(arr, parent, i);
      }
    } else {
      if (arr[parent] < arr[i]) {
        swap(arr, parent, i);
      }
    }

    shiftup(arr, min, parent);
  }

  private void swap(int[]arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  public static void main (String[] args) {
    //code
    int n = 20;
    int[]test = {12,19,7,3,5,14,16,4,20,11,9,2,10,15,8,6,13,18,1,17};

    MedianInAStream g = new MedianInAStream(n);
    for (int i:test) {
      g.printmedian(i);
    }
  }
}