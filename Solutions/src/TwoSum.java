/* 1. TWO SUM
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and may not use the same elements twice. You can return
answer in any order.

Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0,1]
Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

 Constraints:
 - 2 <= nums.length <= 10^4
 - -10^9 <= nums[i] <= 10^9
 - -10^9 <= target <= 10^9

 */
// ***************************************************************************

/* Understanding the question
  * We are given an array of integers called nums, for Example: nums = [2,7,11,15]
    And a single integer called target, for Example: target = 9
    Our goal is to find two numbers from the list that add up to the target and return their indices (meaning the indices
    of the array have to be returned, and not the number itself.
    In the example we see that the numbers 2 and 7 add up to 9. Their indices in the array are 0 and 1. So the correct
    output will be [0,1]

  * We cannot use the same number twice: This means if target = 6 and nums = [3,3], using hte same 3 at the same index twice
    is not allowed.

  * There is always exactly one solution: This means the input is designed in a way where we will always find one and
    only one valid answer.

    * Constraints Explained: constraints are limits on the input values. They help us understand what kind of input to
      expect and how to design an efficient solution.
        * 2 <= nums.length <= 10^4
          This means the input array nums will always have at least 2 numbers and at most 10,000 numbers. This means that
          we don't have to handle empty list or a list with just one element.
        * -10^9 <= nums[i] <= 10^9
          Each number in the array nums[i] can be as small as -1,000,000,000 and as large as 1,000,000,000. This means
          the numbers can be negative, positive or zero.
        * -10^9 <= target <= 10^9
          The target number we are trying to reach with a pair of elements can also range from -1 billion to +1 billion.
 */


import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main (String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumOptimized(nums, target)));
    }

    /* BRUTE FORCE APPROACH: This method simply tries every possible pair of numbers in the list to check if they add
       up to the target.
       Logic:
       - Loop through each element in the array (i)
       - For each i, loop through every element after it (j).
       - Check if nums[i] + nums[j] == target.
       - if yes return [i,j]
     */
    public static int[] twoSum(int[] nums, int target) {        // This defines a static method named twoSum that: takes
                                                                // an array of integers nums, takes an integer target
                                                                // and returns an array of two integers.
        for(int i = 0; i < nums.length; i++){       // This Loop starts with i = 0 and goes up to i < nums.length
            for(int j = i+1; j < nums.length ; j++){        // Second loop starts j from the next index after i,
                                                            // ensuring we dont reuse the same number
                if(nums[i] + nums[j] == target) {       // Checks if the current pair of numbers adds up to the target
                    return new int[]{i, j};             // If yes, then we return their indices immediately
                }
            }
        }
        return new int[]{-1,-1};             // If no pair is found that sums to the target, return [-1,-1] as a not found
                                             // indicator.
    }

    //


    public static int[] twoSumOptimized(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();        // Creates a HashMap to store previously seen numbers from the array
                                                                // Key: the number from the array (nums[i])
                                                                // Value: the index where the number appears.
                                                                // This allows fast lookup in constant time O(1)
        for(int i = 0; i < nums.length;i++){            // Loops through each element in the array nums. i is the current index.
                int complement = target - nums[i];      // For each number nums[i], this calculates the complement needed
                                                        // to reach the target.
            if (map.containsKey(complement)) {      // Checks if the complement already exists in the map

                return new int[]{map.get(complement),i};        // if yes, it means that we have already seen a number that
                                                                // together with ums[i], adds up to the target.
                                                                // map.get(complement) gives the index of the earlier number.
                                                                // i is the index of the current number.
            }
            map.put(nums[i],i);               // if complement was not found, store the current numbers and its index in the map.
        }
        return new int[]{-1,-1};        // This is a fallback return if no solution is found. the problem guarantees
                                        // that a solution will exist, so this line shouldn't be reached under valid inputs.
    }
}
