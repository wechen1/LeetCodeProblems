package com.chenyanj;
import java.util.*;

public class linearEquation {

    // Returns counr of solutions for given
    // rhs and coefficients coeff[0..n-1]
    static int countSol(int coeff[],
                        int n, int rhs)
    {

        // Create and initialize a table to
        // store results of subproblems
        int dp[] = new int[rhs + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        // Fill table in bottom up manner
        for (int i = 0; i < n; i++){
            for (int j = coeff[i]; j <= rhs; j++)
                dp[j] += dp[j - coeff[i]];
            for (int j = coeff[i]; j <= rhs; j++)
                System.out.println( String.format("i=%s, dp[%s] =%s", i, j,dp[j]));
        }


        return dp[rhs];
    }

    static void solve(){
        int coeff[] = {1,2};
        int rhs = 5;
        int n = coeff.length;
        System.out.print(countSol(coeff, n, rhs));
    }


}
