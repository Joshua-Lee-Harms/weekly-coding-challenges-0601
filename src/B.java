//=====================================================================================================================
//        b) Write a function that returns true if you can partition an array into one element and the rest,
//        such that this element is equal to the product of all other elements excluding itself.
//
//        Examples:
//        canPartition([2, 8, 4, 1]) -> true
//        8 = 2 x 4 x 1
//
//        canPartition([-1, -10, 1, -2, 20]) -> false
//
//        canPartition([-1, -20, 5, -1, -2, 2]) -> true
//=====================================================================================================================
// Author: Joshua Harms
//=====================================================================================================================

import java.util.ArrayList;

public class B {

    public static void main(String[] args) {

        // Test Cases
        int[] a = { 2, 8, 4, 1 };
        int[] b = { -1, -10, 1, -2, 20 };
        int[] c = { -1, -20, 5, -1, -2, 2 };

        // Print Results
        System.out.println("canPartition(a) = " + canPartition(a));     // True
        System.out.println("canPartition(b) = " + canPartition(b));     // False
        System.out.println("canPartition(c) = " + canPartition(c));     // True
    }

    public static boolean canPartition(int[] a) {

        ArrayList<Integer> originalArray = new ArrayList<>();
        for (int num : a) {
            originalArray.add(num);
        }
        for (int currentElement = 0; currentElement < originalArray.size(); currentElement++) {
            ArrayList<Integer> remainder = new ArrayList<>(originalArray);
            Integer product = remainder.remove(currentElement);
            if (product.equals(productOf(remainder))) {
                return true;
            }
        }
        return false;
    }

    // Helper function to calculate product of array remainder
    public static int productOf(ArrayList<Integer> remainder) {
        int product = 1;
        for (int element : remainder) {
            product *= element;
        }
        return product;
    }

}
