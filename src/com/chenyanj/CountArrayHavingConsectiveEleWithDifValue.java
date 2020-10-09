package com.chenyanj;

public class CountArrayHavingConsectiveEleWithDifValue {

    static int MAXN = 109;

    public static int countarray(int n, int k,
                                 int x)
    {
        int[] dp = new int[109];

        // Initalising dp[0] and dp[1].
        dp[0] = 0;
        dp[1] = 1;

        // Computing f(i) for each 2 <= i <= n.
        for (int i = 2; i < n; i++)
            dp[i] = (k - 2) * dp[i - 1] +
                    (k - 1) * dp[i - 2];

        return (x == 1 ? (k - 1) * dp[n - 2] :
                dp[n - 1]);
    }

    // driver code
    public static void solve()
    {
        int n = 2, k = 9, x = 2;
        System.out.println(countarray(n, k, x));
    }
}
