/* 217. CONTAINS DUPLICATE
    Given an integer array nums, return true if nay value appears at least twice in the array and return false if very element is distinct.
    Example 1:
    Input: nums = [1,2,3,1]
    Output: true
    Explanation: the element 1 occurs at the indices 0 and 3.
    Example 2:
    Input: nums = [1,2,3,4]
    Output: false
    Explanation: All elements are distinct

    Constraints
    - 1 <= nums.length <= 10^5
    - -10^9 <= nums[i] <= 10^9
 */

/* UNDERSTANDING THE PROBLEM
    We are given an array of integers. We need to check if any number appears more than once in the array.
    If yes, return true. If all numbers are unique, return false.

    Constraints:
    - 1 <= nums.length <= 100,000: input array can have 1 element or as many as 100,000 elements.
    - -1,000,000,000 <= nums[i] <= 1,000,000,000: Each number in the array can be as low as -1 billion and as high as +1 billion.

 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args){

        System.out.println(containsDuplicate(new int[]{1,2,3,1}));

    }

    public static boolean containsDuplicate(int[] nums){
        Set<Integer> intSet = new HashSet<>();      // Creates a HashSet to store unique elements from the array
                                                    // Set ensures that no duplicate values are stored.
        for(int i = 0; i < nums.length; i++){       // Loop through every element in the array nums.
            if(intSet.contains(nums[i])){       // Check if the current number has already been seen (exists in the set.
                return true;                    // if yes, we found a duplicate and return true.
            }
            intSet.add(nums[i]);        // if the number wasn't seen before, add it to the set.
        }
        return false;       // if the loop completes without finding any duplicates, return false.

    }
}

/* TIME COMPLEXITY
    O(n)
    We loop through each element once. Lookup and adding Set takes constant time.

    SPACE COMPLEXITY
    O(n)
    We are using a HashSet to tore unique values from nums. In the worst case, all numbers in the array are unique, so we
    add all n of them to the set.
 */
