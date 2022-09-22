package rough;

import java.util.ArrayList;
import java.util.Arrays;

public class BuySellStock {

  public static void main(String[] args) {
    //

    int[] prices = new int[]{1,3,4,2,5,1,6,2,5};

    // 1 buy 1 sell
    int maxProfit1 = buySell1(prices);

    // mutiple buys and sells - one stock at a tim
    int maxProfit2 = buySell2(prices);

    // at max 2 buys and 2 sells
    int maxProfit3 = buySell3(prices);

    // at max k buys and k sells
    int k = 5;
    int maxProfit4 = buySell4(prices, k);

    System.out.println("Buy Sell 1 (1 buy 1 sell) - Profit : " + maxProfit1);
    System.out.println("Buy Sell 2 (multiple buy and sell)- Profit : " + maxProfit2);

    System.out.println("Buy Sell 2 (Recursive) (multiple buy and sell)- Profit : " + buySell2Rec(prices));

    System.out.println("Buy Sell 3 (2 buys 2 sells) - Profit : " + maxProfit3);
    System.out.println("Buy Sell 3 (Recursive) (2 buys 2 sells) - Profit : " + buySell3Rec(prices));


    System.out.println("Buy Sell 4 (k buys k sells)  - Profit : " + maxProfit4);
  }

  private static int buySell4(int[] prices, int k) {
    return 0;
  }

  private static int buySell3(int[] prices) {
    int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE, s1=0, s2=0;
    for(int i:prices) {
      b1 = Math.max(b1, -i);
      s1 = Math.max(s1, b1+i);
      b2 = Math.max(b2, s1-i);
      s2 = Math.max(s2, b2+i);
    }
    return s2;
  }

  private static int buySell1(int[] prices) {

    int b1 = Integer.MIN_VALUE, s1 = 0;
    for(int i:prices)
    {
      b1 = Math.max(b1,-i);
      s1 = Math.max(s1, b1 + i);
    }
    return s1;
  }

  // buy when prices is min -> one element before => p[i+1] > p[i]
  // sell when prices is max -> one element before => p[i+1] < p[i]
  public static int buySell2 (int[] prices)
  {
    int n = prices.length;
    int buy, sell, profit=0;
    for(int i=0 ; i<n-1 ; i++)
    {
      //buy
      while(i<n-1 && prices[i+1] <= prices[i]) i++;
      buy = prices[i];

      //sell
      while(i<n-1 && prices[i+1] >= prices[i]) i++;
      sell = prices[i];

      profit += sell - buy;
    }
    return profit;
  }

  public static int buySell2Rec (int[] prices)
  {
    // recFn(prices, index, buy)
    int index = 0, buy = 0;
    int[][] dp = new int[prices.length][2];
    for(int[] r:dp)
      Arrays.fill(r,-1);
    int maxProfit = recFn(prices, index, buy, dp);
    return maxProfit;
  }

  public static int buySell3Rec (int[] prices)
  {
    // recFn(prices, index, buy)
    int index = 0, buy = 0;
    int[][][] dp = new int[prices.length][2][3];
    for(int[][] r:dp)
      for(int[] c:r)
        Arrays.fill(c, -1);
    int maxProfit =   recFnMax2(prices, index, buy, dp, 0);
    return maxProfit;
  }

  private static int recFn(int[] prices, int index, int buy, int[][] dp) {

    // if b == 0 => dont buy move on to next OR buy, subtract from profit and move on to next
    // if b == 1 => dont sell and move on OR sell, add profit and move on

    // base condition -> if index == prices.length;
    if(index == prices.length) return 0;

    if(dp[index][buy] != -1) return dp[index][buy];
    if(buy == 0)
      return dp[index][buy] = Math.max(recFn(prices, index+1, 0, dp), -prices[index]+recFn(prices, index+1, 1, dp));

    else
      return dp[index][buy] = Math.max(recFn(prices, index+1, 1, dp), prices[index] + recFn(prices, index+1, 0, dp));
  }


  private static int recFnMax2(int[] prices, int index, int buy, int[][][] dp, int transactions) {

    // if b == 0 => dont buy move on to next OR buy, subtract from profit and move on to next
    // if b == 1 => dont sell and move on OR sell, add profit and move on

    // base condition -> if index == prices.length;

    if(dp[index][buy][transactions] != -1) return dp[index][buy][transactions];
    if(buy == 0)
      return dp[index][buy][transactions] = Math.max(recFnMax2(prices, index+1, 0, dp, transactions), -prices[index]+recFnMax2(prices, index+1, 1, dp, transactions));
    else
      return dp[index][buy][transactions] = Math.max(recFnMax2(prices, index+1, 1, dp, transactions), prices[index] + recFnMax2(prices, index+1, 0, dp, transactions+1));
  }

}
