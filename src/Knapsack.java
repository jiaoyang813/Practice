public class Knapsack {
    public static void main(String[] args)
    {
        int[] val = {60, 100, 120};
        int[] wt = {10,20,30};
        int W = 50;

       System.out.print("Naive Solution: " +  NaiveWay(val, wt , W, 3));
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
}
