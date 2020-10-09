package com.chenyanj;

import java.util.*;

public class SubsetSum {

    /*

    Subset Sum Problem | DP-25
    Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
    Example:

    Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    Output:  True  //There is a subset (4, 5) with sum 9.
     */

    static boolean isSubsetSumOptimized(int arr[], int n, int sum)
    {
        // The value of subset[i%2][j] will be true
        // if there exists a subset of sum j in
        // arr[0, 1, ...., i-1]
        boolean subset[][] = new boolean[2][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                // A subset with sum 0 is always possible
                if (j == 0)
                    subset[i % 2][j] = true;

                    // If there exists no element no sum
                    // is possible
                else if (i == 0)
                    subset[i % 2][j] = false;
                else if (arr[i - 1] <= j)
                    subset[i % 2][j] = subset[(i + 1) % 2]
                            [j - arr[i - 1]] || subset[(i + 1) % 2][j];
                else
                    subset[i % 2][j] = subset[(i + 1) % 2][j];
            }
        }

        return subset[n % 2][sum];
    }

    static boolean isSubsetSum(int set[],
                               int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] =
                new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton
        // up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j-1]][j-1];
                //System.out.println( String.format("Subset[%s][%s] = %5s; i is %s, j is %s, and set[j-1] is %s", i, j, subset[i][j], i, j, set[j-1]));
            }
        }

        /* // uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */

        return subset[sum][n];
    }

    public static void solve(){
        int[] set = {3,34,4,12,5,2};
        int sum = 9;
        int n = set.length;

        long start = System.nanoTime();
        boolean result = isSubsetSumOptimized(set, n, sum);
        long elapsedTime = System.nanoTime() - start;

        long start2 = System.nanoTime();
        boolean result2 = isSubsetSum(set, n, sum);
        long elapsedTime2 = System.nanoTime() - start;

        System.out.println(String.format("The optimized method increase speed by factor %s", (elapsedTime2/1e9)/(elapsedTime/1e9)));

        if (result == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");

    }
}
