//=====================================================================================================================
//        a) Create a function that reorders the digits of each numerical element
//        in an array based on ascending (asc) or descending (desc) order.
//
//        Examples:
//        reorderDigits([515, 341, 98, 44, 211], "asc") -> [155, 134, 89, 44, 112]
//
//        reorderDigits([515, 341, 98, 44, 211], "desc") -> [551, 431, 98, 44, 211]
//
//        reorderDigits([63251, 78221], "asc") -> [12356, 12278]
//
//        reorderDigits([63251, 78221], "desc") -> [65321, 87221]
//
//        reorderDigits([1, 2, 3, 4], "asc") -> [1, 2, 3, 4]
//
//        reorderDigits([1, 2, 3, 4], "desc") -> [1, 2, 3, 4]
//
//        Notes:
//        Single-digit numbers should be ordered the same regardless of direction.
//        Numbers in the array should be kept the same order.
//=====================================================================================================================
// Author: Joshua Harms
//=====================================================================================================================

import java.util.Arrays;
import java.util.Collections;

public class A {

    public static void main(String[] args) {

        // Test Cases:
        int[] a = { 515, 341, 98, 44, 211 };
        int[] b = { 515, 341, 98, 44, 211 };
        int[] c = { 63251, 78221 };
        int[] d = { 63251, 78221 };
        int[] e = { 1, 2, 3, 4 };
        int[] f = { 1, 2, 3, 4 };

        // Compare actual result to expected
        boolean aResult = Arrays.equals(reorderDigits(a, "asc"), new int[]{155, 134, 89, 44, 112});
        boolean bResult = Arrays.equals(reorderDigits(b, "desc"), new int[]{551, 431, 98, 44, 211});
        boolean cResult = Arrays.equals(reorderDigits(c, "asc"), new int[]{12356, 12278});
        boolean dResult = Arrays.equals(reorderDigits(d, "desc"), new int[]{65321, 87221});
        boolean eResult = Arrays.equals(reorderDigits(e, "asc"), new int[]{1, 2, 3, 4});
        boolean fResult = Arrays.equals(reorderDigits(f, "desc"), new int[]{1, 2, 3, 4});

        // Print Test Results
        System.out.println("aResult = " + aResult);
        System.out.println("reorderDigits(a, \"asc\") = " + Arrays.toString(reorderDigits(a, "asc")));
        System.out.println("bResult = " + bResult);
        System.out.println("reorderDigits(b, \"desc\") = " + Arrays.toString(reorderDigits(b, "desc")));
        System.out.println("cResult = " + cResult);
        System.out.println("reorderDigits(c, \"asc\") = " + Arrays.toString(reorderDigits(c, "asc")));
        System.out.println("dResult = " + dResult);
        System.out.println("reorderDigits(d, \"desc\") = " + Arrays.toString(reorderDigits(d, "desc")));
        System.out.println("eResult = " + eResult);
        System.out.println("reorderDigits(e, \"asc\") = " + Arrays.toString(reorderDigits(e, "asc")));
        System.out.println("fResult = " + fResult);
        System.out.println("reorderDigits(f, \"desc\") = " + Arrays.toString(reorderDigits(f, "desc")));
    }

    public static int[] reorderDigits(int[] a, String order) {

        int[] resultArray = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            String element = Integer.toString(a[i]);
            String[] digits = new String[element.length()];
            for (int j = 0; j < digits.length; j++)
                digits[j] = String.valueOf(element.charAt(j));
            if ("asc".equalsIgnoreCase(order))
                Arrays.sort(digits);
            else if ("desc".equalsIgnoreCase(order))
                Arrays.sort(digits, Collections.reverseOrder());
            StringBuilder newElement = new StringBuilder();
            for (String d : digits)
                newElement.append(d);
            resultArray[i] = Integer.parseInt(newElement.toString());
        }
        return resultArray;
    }
}
