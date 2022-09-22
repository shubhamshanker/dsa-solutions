package solutions;

public class L88_MergeSortedArray {

  public static void main(String[] args) {
  }
  // start from the end
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, mainptr  = m+n-1;
        while(i >=0 && j >=0)
        {
            nums1[mainptr--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        // dont need to check for nums1 as its already sorted
        while(j>=0)
            nums1[mainptr--] = nums2[j--];
    }
}
