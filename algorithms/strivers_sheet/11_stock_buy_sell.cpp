Solution 1 :- 
Time Complexity :- O(n)
Space Complexity :- O(1)

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int sell = 0;
        int buy = INT_MAX;
        int i;
        for(i=0;i<prices.size();i++) {
            buy = min(buy, prices[i]);
            sell = max(sell, prices[i] - buy);
        }
        return sell;
    }
};


Solution 2 :-
Time Complexity :- O(n^2)
Space Complexity :- O(1)

public class Solution {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}


