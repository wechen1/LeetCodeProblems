package com.chenyanj;

import java.awt.Point;
import java.util.HashMap;
public class maxRatioSum {

    static int maxWeightRec(int wt[], int val[], int K,
                            HashMap<Point, Integer> hm,
                            int last, int diff)
    {
        //  base cases : if no item is remaining
        if (last == -1)
        {
            if (diff == 0)
                return 0;
            else
                return Integer.MIN_VALUE;
        }

        // first make pair with last chosen item and
        // difference between weight and values
        Point tmp = new Point(last, diff);
        if (hm.containsKey(tmp))
            return hm.get(tmp);

        /*  choose maximum value from following two
            1) not selecting the current item and calling
               recursively
            2) selection current item, including the weight
               and updating the difference before calling
               recursively */
        hm.put(tmp,Math.max(maxWeightRec(wt, val, K, hm, last - 1, diff),
                wt[last] + maxWeightRec(wt, val, K, hm,
                        last - 1, diff + wt[last] - val[last] * K)));

        return hm.get(tmp);
    }

    // method returns maximum sum of weight with K
    // as ration of sum of weight and their values
    static int maxWeight(int wt[], int val[], int K, int N)
    {
        HashMap<Point, Integer> hm = new HashMap<>();
        return maxWeightRec(wt, val, K, hm, N - 1, 0);
    }

    // Driver method
    public static void solve()
    {
        int wt[] = {1,5,7};
        int val[]={2,1,1};
        //int wt[] = {4, 8, 9};
        //int val[] = {2, 4, 6};

        int K = 2;


        // abbc
        // cbba



        // abbc v.s. cbb
        // or abb v..s cbba
        // or abb v.s. cbb
        System.out.println(maxWeight(wt, val, K, wt.length));
    }
}

