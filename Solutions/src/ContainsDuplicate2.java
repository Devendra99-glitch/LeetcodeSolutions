/* 219. CONTAINS DUPLICATE II
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such
    the nums[i] == nums[j] and abs(i - j) <= k

    Example 1
    Input: nums = [1,2,3,1] , k = 3
    Output: 3

    Example 2:
    Input: nums = [1,0,1,1], k = 1

    Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false

    Constraints:
    - 1 <= nums.length <= 10^5
    - -10^9 <= nums[i] <= 10^9
    - 0 <= k <= 10^5
 */

/* UNDERSTANDING THE PROBLEM
    We are still trying to detect duplicates, but now they must appear within k indices of each other.
    it means, we check if the same value appears twice, and their positons are not too far apart (distance <= k)

    For input, we will have an array of integers nums and an integer k.
    We have to return true if any two equal numbers are at most k indices apart. Or else return false.

    Constraints:
    - 1 <= nums.length <= 10^5: the array nums can be very large up to 100,000 elements and at least have one element.
                                This means we cannot use brute force approaches like nested loops, as that will be slow.
    - -10^9 <= nums[i] <= 10^9: Each element in the array can be as small as -1,000,000,000 and as large as +1,000,000,000
    - 0 <= k <= 10^5: k is the maximum allowed distance between two equal elements.
                    When k = 0, value at the same index cannot be repeated, so always false.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ContainsDuplicate2 {
    public static void main(String[] args){
        System.out.println(containsDuplicate(new int[]{1,2,3,1}, 3));
    }

    // HASHMAP TECHNIQUE
    public static boolean containsDuplicate(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();        // Initializes a HashMap to track Key: a number from the array
                                                            // Value: the last index where that number was seen.
        int index = 0;          // this variable is used to keep track of the current index location.
        for(int i = 0; i < nums.length; i++){           // Loop through the array using index
            if(map.containsKey(nums[i])){               // Checks if the current number has already been seen before by looking it up in the map.
                int distance = Math.abs(map.get(nums[i]) - (index));    // Calculates the distance between the indices.
                if(distance <= k){              // if the number has been seen before and the distance between the two indices is less than or equal to k
                    return true;                // we return true
                }
            }
            map.put(nums[i],i);     // if the number has never been seen before then we add it to the map Key: being the number itself and Value: being the index
            index++;        // index variable is incremented with each pass, to keep track of the current index location.
        }
        return false;       // If we reach this point, the loop has finished, and no valid duplicates were found. so we return false.

    }

/* TIME COMPLEXITY
    O(n)  We loop through the array once. each put and get in HashMap is O(1)
    SPACE COMPLEXITY
    O(n) in the worst case the map stores all n elements.
 */

    // HASHSET AND SLIDING WINDOW TECHNIQUE
    public static boolean containsDuplicate2(int[] nums, int k){
        Set<Integer> set = new HashSet<>();             // initializes a HashSet to store the numbers in a sliding window of last k elements.
        for( int i = 0; i < nums.length ; i++){     // A loop to iterate through every element in the array using index i
            if(set.contains(nums[i])){      // checks whether the current number already exists in the sliding window (set)
                return true;                // if yes, then we return true
            }
            set.add(nums[i]);           // if no duplicate was found, we add the current number to the set
            if(set.size() > k){         // This ensures the window size doesnt exceed.
                                        // if the window has more than k elements, we remove the oldest element to maintain the k- element range.
                set.remove(nums[i-k]);      // removes the element that is not outside the window. So the sliding window always contains the last k elements.
            }
        }
        return false;       // if the loop completes and no duplicates were found within k distance, return false.
    }

    /* TIME COMPLEXITY
        O(N) We loop through the array once. each put and get in HashMap is O(1)

        SPACE COMPLEXITY
        O(k)
        The set stores at most k elements at a time.
     */
}


