import javax.sound.midi.SysexMessage;
import java.util.Dictionary;
import java.util.Random;

public class Knapsack {
    public static void main(String[] args)
    {
        int dataSize = 100000;
        Random rd = new Random(1);

        int[] val = new int[dataSize];
        int[] wt = new int[dataSize];
        int W = 5000;
        int[] dp = new int[val.length];

        for (int i = 0; i < dataSize; i++)
        {
            val[i] = rd.nextInt(200);
            wt[i] = rd.nextInt(100);
        }

       //System.out.println("Naive Solution: " +  NaiveWay(val, wt , W, val.length));
       System.out.println("Better solution: " + DP(val,wt, W));
    }



    private static int Max(int a, int b)
    {
        if(a > b)
            return a;
        return b;
    }

    private static int NaiveWay(int[] val, int[] weight, int W, int i)
    {
        if(W==0 || i == 0)
            return 0;

        if(weight[i - 1] > W)
            return NaiveWay(val, weight, W, i-1);
        else
        {
            return Max(NaiveWay(val, weight, W, i-1),
             val[i-1] + NaiveWay(val, weight, W-weight[i-1], i-1));
        }
    }

    private static int DP(int[] val, int[] wt, int W)
    {
       int size = val.length;
       int[][] dp = new  int[size + 1][ W+1];

       for (int i = 0; i <= size; i++)
       {
           for (int w = 0; w <= W; w++)
           {
               if(i == 0 || w == 0)
               {
                   dp[i][w] = 0;
               }
               else {
                   if(wt[i-1] < w)
                   {
                       dp[i][w] = Max(dp[i-1][w], val[i-1] + dp[i-1][w-wt[i-1]]);
                   }
                   else
                   {
                       dp[i][w] = dp[i-1][w];
                   }
               }

           }
       }

       return  dp[size][W];

    }


}
