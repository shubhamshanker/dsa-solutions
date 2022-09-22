package rough;

import java.util.ArrayList;
import java.util.List;

public class dp {

  public static int count=0;

  public static void main(String[] args) {
    //

    int arr[] = new int[]{3,2,5,4,8,2,9};
    int arr1[] = new int[]{0,1,2};
//
//      List<List<Integer>> subsets = allSets(arr);
//    for (List<Integer> li : subsets) System.out.println(li);
    int sum = 0;
    boolean subsetSum = subetSum(arr1, sum);
    System.out.println("Subset sum : " +subsetSum);
  }

    private static boolean subetSum(int[] arr, int sum) {

      boolean ans = recSubsetSum(arr, arr.length, sum);
      System.out.println("Count = " + count);
      return ans;

    }

    private static boolean recSubsetSum(int[] arr, int index, int sum) {

      if(sum == 0){
      count++;
      ; return true;}
      if(index == 0) return false;

      if(arr[index-1] <= sum)
          return recSubsetSum(arr, index-1,  sum - arr[index-1]) | recSubsetSum(arr,  index-1, sum);
      else return recSubsetSum(arr, index-1, sum);


    }

    // pick or not pick
    private static List<List<Integer>> allSets(int[] arr) {

        List<List<Integer>> li = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();

        int n = arr.length;
        int index = 0;
        allSubsets(arr, li, index, n, templist);
        return li;

    }

  private static void allSubsets(
      int[] arr, List<List<Integer>> li, int index, int n, List<Integer> tempList) {

    if (index == n) {
      // create new instance of templist
      li.add(new ArrayList<>(tempList));
      return;
    }
    // pick item
    tempList.add(arr[index]);
    allSubsets(arr, li, index + 1, n, tempList);
    // remove the last element added
    tempList.remove(tempList.size() - 1);

    // do not pick item
    allSubsets(arr, li, index + 1, n, tempList);
      }
}
