package com.chenyanj;
import java.util.*;
import java.util.PriorityQueue;

public class NumberOfNGEs {

    static void fillNext(int next[], int a[], int n)
    {
        // Use stack
        Stack<Integer> s = new Stack<Integer>();

        // push the 0th index to the stack
        s.push(0);
        // int a[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
        // traverse in the loop from 1-nth index
        for (int i = 1; i < n; i++)
        {
            while (s.size() > 0)
            {
                // get the topmost index in the stack
                int cur = s.peek();
                // if the current element is greate then the top index-th element, then
                // this will be the next greatest index of the top index-th element
                if (a[cur] < a[i])
                {
                    // initialize the cur index position next greatest as index
                    next[cur] = i;

                    // pop the cur index as its greater element has been found
                    s.pop();
                }

                // if not greater then break
                else
                    break;
            }

            // push the i index so that its next greatest
            // can be found
            s.push(i);
        }

        PriorityQueue<String> abc = new PriorityQueue<>();


        // iterate for all other index left inside stack
        while (s.size() > 0)
        {

            int cur = s.peek();

            // mark it as -1 as no element in greater
            // then it in right
            next[cur] = -1;

            s.pop();
        }
    }

    // function to count the number of
// next greater numbers to the right
    static void count(int a[], int dp[], int n)
    {
        // initializes the next array as 0
        int next[] = new int[n];
        for(int i = 0; i < n; i++)
            next[i] = 0;

        // calls the function to pre-calculate
        // the next greatest element indexes
        fillNext(next, a, n);

        System.out.println("After the fill next");
        for(int i =0; i< next.length;i++){
            System.out.println(String.format("next[%s] is %s", i, next[i]));
        }

        for (int i = n - 2; i >= 0; i--)
        {

            // if the i-th element has no next
            // greater element to right
            if (next[i] == -1)
                dp[i] = 0;

                // Count of next greater numbers to right.
            else
                dp[i] = 1 + dp[next[i]];
        }
    }



    ArrayList<Integer>[] arr = new ArrayList[7];

    // 0 1 2 3 4
    // 5 6 2 9 1

    // next -> 1, 3, 3, 0, 0
    // answers all queries in O(1)
    static int answerQuery(int dp[], int index)
    {
        // returns the number of next greater
        // elements to the right.
        return dp[index];
    }

    // driver code
    public static void solve()
    {
        int a[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
        int n = a.length;

        int dp[] = new int[n];

        // calls the function to count the number
        // of greater elements to the right for
        // every element.
        count(a, dp, n);

        // query 1 answered
        System.out.println(answerQuery(dp, 3));

        // query 2 answered
        System.out.println( answerQuery(dp, 6));

        // query 3 answered
        System.out.println( answerQuery(dp, 1) );

    }
}
