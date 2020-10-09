package com.chenyanj;
import java.util.Arrays;

public class countWaysOfSum {

    static int countWays(int n)
    {

        // table[i] will be storing the
        // number of solutions for value
        // i. We need n+1 rows as the
        // table is consturcted in bottom
        // up manner using the base case
        // (n = 0)
        int table[] = new int[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all integer one by one and
        // update the table[] values after
        // the index greater than or equal
        // to n
        for (int i = 1; i < n; i++){
            for (int j = i; j <= n; j++){
                table[j] += table[j - i];

                System.out.println(String.format("j %s is added from table[%s] with Value %s", j, j-i, table[j-i]));
            }

            System.out.println(String.format("At iteration %s", i));
            for(int k = 0; k < table.length;k++){
                System.out.println(String.format("dp[%s] = %s", k, table[k]));

            }
        }
        return table[n];
    }

    //driver code
    public static void solve ()
    {
        int n = 7;

        System.out.print(countWays(n));
    }
}
