// 27. REMOVE ELEMENTS
// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The order of the elements may be changed. then return the number of elements in nums which are not equal to val.
// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things.
// Change the array nums such that the first k elements of nums contain the elements which are not equal to val. the remaining
// elements of nums, are not important as well as size of nums. Return k.
// Example:
// input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2,_,_]

public class RemoveElement {
    public static void main(String[] args){

        System.out.println(removeElements(new int[] {3,2,2,3}, 3));     // Calling the function with arguments
    }

    private static int removeElements(int[] nums, int val){
        int count = 0;                                  // As we are supposed to return the number of elements that are not equal to val.
        for(int i = 0; i < nums.length; i++) {          // iterating through the array
            if (nums[i] != val) {                       // check if element at index i is not equal to the val argument.
                nums[count] = nums[i];                  // if not equal we will insert the element from index i at index count.
                count++;                                // then we increment count, so that the next index can be replaced if needed.
            }
        }
        return count;       // returns the number of elements that are not equal to val.
    }
}

// TIME COMPLEXITY: O(n), where n is the number of elements in the input array
// The function iterates over the input array, using a for loop: O(n)
// inside the loop the function performs a constant amount of work: O(1)
// O(n) * O(1) = O(n)
// SPACE COMPLEXITY: O(1)
// constant amount of space is required for count variable: O(1)
// the function modifies the array in-place, without creating additional data structures. this means space does not depend on input array size. O(1)