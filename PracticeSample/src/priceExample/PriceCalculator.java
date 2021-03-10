package priceExample;


class App{
	int maxProfit(int price[], int start, int tail) {
		if (tail <= start)
	        return 0;
		int profit=0;
		for (int i = start; i < tail; i++) {
			for (int j = i + 1; j <= tail; j++) {
				if(price[j]>price[i]) {
					int current_profit = price[j] - price[i];
					profit = Math.max(profit, current_profit);
				}
				
			}
			
		}
		return profit;
	}

}

public class PriceCalculator {
	static App p =new App();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[] = {8,11,5,7,8,10};
		int n = price.length;
		System.out.println(p.maxProfit(price,0,n-1));
	}

}
