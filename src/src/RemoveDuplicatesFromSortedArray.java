// 26. REMOVE DUPLICATES FROM SORTED ARRAY
// Given an array nums order in non-decreasing order, remove the duplicates in place such that each unique element appears only once.
// the relative order of the elements should be kept the same.
// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
// Change the array nums, such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
// The remaining elements of nums are not important as well as the size of nums.
// return k.
// Example:
// Input: nums = [1,1,2]    Output: 2, nums = [1,2,,,]

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){

        System.out.println(removeDuplicates(new int[] {1,1,2}));
    }

    public static int removeDuplicates(int[] nums){
        int j = 0;                                  // First we initialize a pointer at the start of the array index
        for(int i = 0; i < nums.length; i++){       // iterating through the array with another pointer i starting at index 0.
            if(nums[j] != nums[i]){                 // then we check if the elements at the indices are not equal, that means the elements are unique
                j++;                                // then we increment j pointer by 1, so that we can insert the new element after the first unique element.
                nums[j] = nums[i];                  // then we insert the unique element at index i in the place of index j.
            }
        }
        return j + 1;                           // we have to return the k unique elements in the array. so j is the pointer which will point tot he last unique element,
                                                // and as we start indexing from 0, we add 1 to the j to get the total number of unique elements.

    }
}

// TIME COMPLEXITY: O(n), where n is the number of elements in the input array.
// the for loop to iterate over the elements of the array: O(n)
// All other operations require: O(1)
// Since the loop iterates n times, and each iteration performs a constant amount of work O(n) * O(1) = O(n)
// SPACE COMPLEXITY: O(1)
// the function uses a constant amount of space for pointers, regardless of the size of the input array. Space does not grow with the size of the input array.
