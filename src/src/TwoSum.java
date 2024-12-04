// 1. TWO SUM
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
// to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// EXAMPLE:
// Input: nums = [2,7,11,15], target = 9    Output: [0,1]
// Input: nums = [3,2,4], target = 6    Output: [1,2]
// Input: nums = [3,3], target = 6  Output: [0,1]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));  // calling the brute force method with arguments
        System.out.println(Arrays.toString(findTwoSum(new int[] {2,7,11,15}, 9)));  // calling the optimized method with arguments.
    }

    // First we try with the Brute force method.
    // where we take two pointers to iterate through the array, one is a slow pointer and the other a fast pointer.
    // the slow pointer starts from the first index, and the fast pointer starts from (slow pointer index + 1).
    // so we are comparing the first element at index 0, to all the elements in the array. until we hit the target.
    private static int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){               // the slow pointer starts at index 0
            for(int j = i+1; j < nums.length; j++){         // the fast pointer start from i+1 index (this means if the slow pointer is at index 0, then fast pointer is at 1.
                                                            // we do this as the problem says we may not use the same element twice.
                if(nums[i] + nums[j] == target){            // then we put a condition to check if both elements add up to the target value
                    return new int[] {i,j};                 // if they are equal to the target value then, we return a new integer array with the indices of both elements.
                }
                                                            // if not then, we increment the value of j and check.
            }
                                                            // when we are not able to find the elements that equal target, then we increment the i pointer and check again.
        }
        return null;                                        // if no match is found, then we can return null meaning no match was found.
    }

// TIME COMPLEXITY: O(n^2), where n is the number of elements in the input array.
// Explanation: the method uses two nested for loops to iterate through the input array. the outer loop runs from 0 to n-1 and the inner loop runs from i+1 to n-1
// in the worst case the method has to iterate through the entire array, which means the outer loop runs n times, and inner loop n-1.n-2...1 times, depending on the
// current iteration of the outer loop.
// therefore the total number of iterations is n + (n-1) + (n-2)+ .... + 1 = n(n-1)/2 = O(n^2)
// SPACE COMPLEXITY: O(1), which means the space required does not change with the size of the input array.
// the method only uses a constant amount of spaces to store the indices i and j. and as the input array is not modified. therefore O(1)

    // Now trying to optimize it, we will use HashMaps.

    private static int[] findTwoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();            // A hashmap is created to store the numbers in the array as keys and their indices as values.
        for(int i = 0; i < nums.length; i++){                   // iterating through the array using a for loop
            int complement = target - nums[i];                  // for each nums[i], this method will calculate the complement
            if(map.containsKey(complement)){                    // if the complement already exists in the map, this means that we have found the two numbers that equal target
                return new int[] {map.get(complement), i};      // and we return a new integer array with the indices of the two numbers.
            }else{
                map.put(nums[i], i);                            // else if hte complement is not found in the map, then we add the current number and its index to the map.
            }
        }
        return null;                // if the method iterates through the array without finding the solution then we return null.
    }
}

// TIME COMPLEXITY: O(n), where n is the number of elements in the input array.
// Explanation: the method iterates through the array once, performing a constant amount of work for each element. the containsKey and put operations on the Hashmap also take constant time on average.
// iterating through the array: O(n)
// Calculating the complement of the current element with respect to target sum: O(1)
// Checks if the complement is already present in the HashMap using containsKey method: O(1)
// If complement is found, returns an array with indices: O(1)
// If the complement is not found, adds the current element and its index to the HashMap using put method: O(1)
// Time Complexity: O(n) + O(1) + O(1) + O(1) + O(1) = O(n)

// SPACE COMPLEXITY: O(n) where n is the number of elements in the input array.
// Explanation: this i9s because the method uses a HashMap to store the elements of the array, which requires O(n) space in the worst case.
