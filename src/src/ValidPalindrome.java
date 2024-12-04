// 125. VALID PALINDROME
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.
// Example:
// Input: s = "A man, a plan, a canal: Panama"  Output: true    Explanation: "amanaplanacanalpanama" is a palindrome
// Input: s = "race a car"  Output: false   Explanation: "raceacar" is not a palindrome.
// Input: s = " "   Output: true    Explanation: s is an empty string, since an empty strings reads the same forward and backward.

public class ValidPalindrome {
    public static void main(String[] args){
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));    // Calling the method with string argument.
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));         // Calling the optimized method with string argument.
    }

    // Brute force solution: where we first remove all the non alphanumeric characters by using a for loop to iterate through the string.
    // then we iterate through the new string again to check if the string is a palindrome.
    public static boolean isValidPalindrome(String s){
        String fixed_string = "";               // first we create an empty string, to store the filtered string after removing the non alphanumeric characters

        for( char c : s.toCharArray()){         // now we use the method from String class to create the string into a character array, and we iterate through each character in that array
            if(Character.isDigit(c) || Character.isLetter(c)){      // we check condition if the character is either a digit or a letter
                fixed_string += c;                                  // if the condition is true then we add the character to the empty string.
            }
        }
                                                        // After the for loop is completed, the non alphanumeric characters are removed from the string.
        fixed_string = fixed_string.toLowerCase();      // now we convert the string to lowercase, so that all characters in the string are lowercase.

        int i = 0;                                  // we initialize a pointer at the start of the String
        int j = fixed_string.length() - 1;          // initializing a second pointer at the end of the string.
        while( i <= j){                             // while the two pointers do not cross over each other, as we increment the start pointer and decrement the end pointer,
                                                    // there will be a point where both of them are at the same index.
            if(fixed_string.charAt(i) != fixed_string.charAt(j)){       // now we check if the characters at each start and end index are not same
                return false;                                       // if not same then we return false, meaning the string is not a palindrome.
            }
            i += 1;                                            // if the characters are same, then we increment the start pointer by 1 to check the next character.
            j -= 1;                                            // and decrement the end pointer, for comparing the characters. both pointers move close to each other.
        }
                                // once all the conditions pass, this means that the string is a palindrome.
        return true;            // if string is a palindrome it returns true, otherwise it returns false.
    }
// TIME COMPLEXITY: O(n), where n is the length of the input string.
// The method iterates through the input string twice, once to remove non-alphanumeric characters and once to check if the string is a palindrome.
// Each iteration takes O(n) time.
// Therefore, the overall time complexity is:  O(n) + O(n) = O(2n) which simplifies to O(n)
// SPACE COMPLEXITY: O(n), where n is the length of the input string.
// The method creates a new String to store the filtered input string. the length of the filtered string is at most n, where n is the length of the input String.


    // The optimized way where we do not create a new string, nor iterate twice over the string (just once)
    public static boolean isPalindrome(String s){
        if(s.isEmpty()){                // first we check if the string is empty, if empty string is same forward or backward.
            return true;                // returns true, it is a palindrome.
        }
        int start = 0;                  // initialize a pointer at the start index of the string.
        int last = s.length() - 1;      // initialize a pointer at the end of the string.
        while( start <= last){          // while the two pointers dont cross each other, the condition remains true
            char currStart = s.charAt(start);       // we get the character at the first index
            char currLast = s.charAt(last);         // we get the character at the last index.
            if(!Character.isLetterOrDigit(currStart)){      // we check if the first character is not a letter ot digit, then we increment the start index.
                start++;
            } else if(!Character.isLetterOrDigit(currLast)){    // else we check one more condition if the last index is not a digit or letter, then we decrement the last index by 1
                last --;
            }else{
                if(Character.toLowerCase(currStart) != Character.toLowerCase(currLast)){        // if both conditions are true, that the first and last characters are not non-alphanumeric
                                                                                            // then we check if both characters are not equal.
                    return false;                               // if not equal, then not a palindrome and returns a false.
                }
                                    // if equal
                start++;           // then we check for the next characters by incrementing start character by 1 and decrementing last character by 1.
                last--;
            }
        }
        return true;                // if all conditions are satisfied, this means the string is a palindrome, and the method returns true.

    }

    // TIME COMPLEXITY: O(n), where n is the length of the input string.
    // while loop iterating over the string: O(n)
    // Everything else from creation of variables to return statement and conditional checks: O(1)
    // SPACE COMPLEXITY: O(1)
    // Variables: O(1)
    // input string is not counted towards space complexity as its part of the input, not the algorithm's space usage.

}

