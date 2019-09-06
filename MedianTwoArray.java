/**
 * Leetcode - Median of Two Sorted Arrays
 * 
 * Share There are two sorted arrays nums1 and nums2 of size m and n
 * respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianTwoArray{
  public static void main(String[] args) {
    int[] arr1 = {}; // empty array
    // int[] arr1 = {1, 4};
    int[] arr2 = {5};
    // int[] arr2 = {3,10};
    System.out.println("Median search: " + medianSearch(arr1, arr2));
  }

  public static double medianSearch(int[] nums1, int[] nums2){
    // while (nums1.length < 0 && nums2.length < 0) {
    //   nums
    // }
    int[] bigArr = new int[nums1.length + nums2.length];
    int count = 0;
    int firstBin = 0;
    int lastBin = bigArr.length - 1;
    int middle;
    double median = 0;

    if(nums1.length != 0 || nums2.length != 0) {
      //joint arrays
      for (int i = 0; i < nums1.length; i++) {
        bigArr[i] = nums1[i];
        count++;
      }
      for (int i = 0; i < nums2.length; i++)
        bigArr[i + count] = nums2[i];

      // selection sort
      for (int last = 0; last < bigArr.length - 1; last++) {
        int minIndex = last;
        for (int index = last; index <= bigArr.length - 1; index++) {
          if (bigArr[index] < bigArr[minIndex])
            minIndex = index;
        }
        int temp = bigArr[minIndex];
        bigArr[minIndex] = bigArr[last];
        bigArr[last] = temp;
      }
      //binary search
      if (bigArr.length % 2 != 0) { //odd length
        middle = (firstBin + lastBin) / 2;
        median = bigArr[middle];
        // System.out.println("Pass here: " + median);
      }
      if(bigArr.length % 2 == 0){ //even length
        middle = (firstBin + lastBin) / 2;
        median = ((double)(bigArr[middle] + bigArr[middle+1])) / 2;
        // System.out.println("Pass here: " + (bigArr[middle] + bigArr[middle+1]));
        // System.out.println("Pass here: " + median);
      }
    }
    else
      System.out.println("Arrays cannot be both empty.");

    //   for (int i = 0; i < bigArr.length; i++)
    // System.out.println(bigArr[i]);
    return median;
  }
}