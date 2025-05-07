package com.foo.arreglos;


import org.junit.jupiter.api.Test;

import com.foo.Arrays_strings_Hash.arrays.TwoSum;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {

    @Test
    public void twoSumTest() {
        int[] array = new int[]{9, 2, 5, 6};
        TwoSum twoSum = new TwoSum();

        int[] result = twoSum.twoSum(array, 7);

        assertNotNull(result);
        assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));

        assertNull(twoSum.twoSum(array, 50));
    }
}
