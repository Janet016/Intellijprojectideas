//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Arrays;

 class StockPriceAnalysis {

     // Method to calculate the average stock price
     public static float calculateAveragePrice(float[] prices) {
         float sum = 0;
         for (float price : prices) {
             sum += price;
         }
         return sum / prices.length;
     }

     // Method to find the maximum stock price
     public static float findMaximumPrice(float[] prices) {
         float maxPrice = prices[0];
         for (float price : prices) {
             if (price > maxPrice) {
                 maxPrice = price;
             }
         }
         return maxPrice;
     }

     // Method to count the occurrences of a specific price
     public static int countOccurrences(float[] prices, float targetPrice) {
         int count = 0;
         for (float price : prices) {
             if (price == targetPrice) {
                 count++;
             }
         }
         return count;
     }


    // Method to compute the cumulative sum of stock prices
  public  static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    // Main method for testing the above methods
    public static void main(String[] args) {
        // Example data
        float[] stockPricesArray = {10.5f, 11.2f, 12.0f, 11.5f, 10.8f, 12.3f, 13.2f, 14.0f, 13.8f, 14.5f};
        ArrayList<Float> stockPricesList = new ArrayList<>(Arrays.asList(10.5f, 11.2f, 12.0f, 11.5f, 10.8f, 12.3f, 13.2f, 14.0f, 13.8f, 14.5f));

        // Calculate average price
        float averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + averagePrice);

        // Find maximum price
        float maxPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + maxPrice);

        // Count occurrences of a specific price
        float targetPrice = 12.0f;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of price " + targetPrice + ": " + occurrences);

        // Compute cumulative sum
        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSum);
    }
}
