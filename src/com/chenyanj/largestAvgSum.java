package com.chenyanj;

public class largestAvgSum {

    static double largestSumOfAverages(int[] A, int K)
    {
        int n = A.length;

        // storing prefix sums
        double []pre_sum = new double[n + 1];
        pre_sum[0] = 0;
        for (int i = 0; i < n; i++)
            pre_sum[i + 1] = pre_sum[i] + A[i];

        // for each i to n storing averages
        double []dp = new double[n];
        double sum = 0;
        System.out.println(String.format("The default n = %s, dp values initially is:", n));
        for (int i = 0; i < n; i++){
            dp[i] = (pre_sum[n] - pre_sum[i]) / (n - i);
            System.out.println(String.format("dp[%s]  =  %s",i, dp[i] ));
        }

        System.out.println("The presum is :");
        for(int k = 0; k< pre_sum.length;k++){
            System.out.println(String.format("pre_sum[%s]  =  %s",k, pre_sum[k] ));
        }

        for (int k = 0; k < K - 1; k++)
        {
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    dp[i] = Math.max(dp[i], (pre_sum[j] -
                            pre_sum[i]) / (j - i) + dp[j]);
            System.out.println(String.format("At iter %s", k));

            for(int h = 0;h< dp.length; h++){
                System.out.println(String.format("dp[%s]  =  %s",h, dp[h] ));
            }
        }


        return dp[0];
    }

    // Driver code
    public static void solve()
    {
        int []A = { 9, 1, 2, 3, 9 };
        int K = 3; // atmost partioning size
        System.out.println(largestSumOfAverages(A, K));
    }

}
