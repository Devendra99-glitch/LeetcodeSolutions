/* 26. REMOVE DUPLICATES FROM SORTED ARRAY
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
    element appears only once. the relative order of the elements should be kept the same. Then return the number of
    unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    - Change the arrays nums such that the first k elements of nums contain the unique elements in the order they were
    present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    - return k.

    Example 1:
    Input: nums = [1,1,2]
    Output: [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    Example 2:
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0,1,2,3, and 4 respectively.

    Constraints:
    - 1 <= nums.length <= 3 * 10^4
    - -100 <= nums[i] <= 100
    - nums is sorted in non-decreasing order.
 */

/* Understanding the problem
    We are given an array of numbers. Our task is to remove duplicates from the array, but we are not allowed to use extra space.
    The array is already sorted in ascending order (non-decreasing order)

    Output should return an integer representing how many unique numbers are in the array after removing duplicates.
    Also, modify the array in-place so that the first part contains only the unique elements.

    Constraints:
    - 1<= nums.length <= 30,000: the input array will have at least 1 element and at most 30,000 elements.
    - -100 <= nums[i] <= 100: Each number in the array is between -100 and 100.
 */


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,2,3,4,4,5}));
    }

    public static int removeDuplicates(int[] nums){
        int k = 0;                      // This is a pointer to the last unique value seen.
                                        // it starts at index 0 - assuming the first element is always unique for sorted arrays.
        for(int i = 0; i < nums.length; i++){           // i is the scanning pointer - it goes over every element.
                                                        // i checks whether the current number is different from the last unique number.
            if(nums[i] != nums[k]){         //  Checks if the current number is different from the last unique one.
                nums[++k] = nums[i];        // first, ++k we increase the value of k pointer to the next spot for the new unique number.
                                            // then nums[k] = nums[i] stores the new unique number at that position.
            }
        }
        return ++k;     // At the end we increase k by 1 to get the total count of unique numbers.
    }
}

/* TIME COMPLEXITY:
    O(n) because the method uses a single loop that runs from i = 0 to i = nums.length - 1.
    Each comparison nums[i] != nums[j] and assignment nums[++k] = nums[i] takes constant time O(1)
    So for n elements we do at most n comparisons and writes.


    SPACE COMPLEXITY:
    O(1) because we are not using any extra arrays or data structures.
    only two integer variables k and i, which use constant space.
 */
