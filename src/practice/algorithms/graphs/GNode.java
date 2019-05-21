package practice.algorithms.graphs;

import java.util.LinkedList;
import java.util.List;

public class GNode {
  int data;
  List<GNode> connections;

  public GNode(int data) {
    this.data = data;
    connections = new LinkedList<GNode>();
  }
}
