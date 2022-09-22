package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class temp1 {

  public static void main(String[] args) {
    //
    String s = "abc";
    int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};

    System.out.println(maxSubArray(arr));
  }

  public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
      maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
      System.out.print(maxEndingHere + " ");
      maxSoFar=Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }
}
