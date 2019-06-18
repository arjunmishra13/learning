package practice.techlead.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <h>Daily Coding Problem: Problem #17 [Hard]</h>
 * <p>This problem was asked by Google.</p>
 * <p>
 *   Suppose we represent our file system by a string in the following manner:
 *
 *   The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 *   <code>
 *     dir
 *         subdir1
 *         subdir2
 *             file.ext
 *   </code>
 *
 *   The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 *
 *   The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 *
 *   <code>
 *     dir
 *          subdir1
 *              file1.ext
 *              subsubdir1
 *          subdir2
 *              subsubdir2
 *                  file2.ext
 *   </code>
 *
 *   The directory dir contains two sub-directories subdir1 and subdir2.
 *   subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 *   subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 *
 *   We are interested in finding the longest (number of characters) absolute path to a file
 *   within our file system. For example, in the second example above, the longest absolute
 *   path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 *
 *   Given a string representing the file system in the above format, return the length of the
 *   longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.
 *
 *   Note:
 *
 *   The name of a file contains at least a period and an extension.
 *
 *   The name of a directory or sub-directory will not contain a period.
 * </p>
 */
public class May31_2019 {

  private static class Node {
    String val;
    List<Node> children;
    int len;
    Node(String val, int len) {
      this.val = val;
      children = new ArrayList<Node>();
      this.len = len + val.length();
    }
  }

  static String pathStr = null;
  static String baseDelimiter = "\\n";
  private static int getLongestPath(String path) {
    pathStr = path;
    Node node = buildtree("\\n\\t", 0);

    return 0;
  }


  private static Node buildtree(String delimiter, int len) {
    if (pathStr == null || pathStr.length() == 0) {
      return null;
    }

    int index = pathStr.indexOf(delimiter);
    if (index != -1) {
      Node node = new Node(pathStr.substring(0, index), len);
      pathStr = pathStr.substring(index + 1);


      return node;
    } else {
      return new Node(pathStr, len);
    }
  }


  public static void main(String[]args) {

    String path = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
    System.out.println(getLongestPath(path));
  }
}
