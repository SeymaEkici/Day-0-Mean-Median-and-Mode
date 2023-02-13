import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Compute mean
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double mean = sum / n;

        // Compute median
        Arrays.sort(arr);
        double median;
        if (n % 2 == 0) {
            median = (arr[n/2-1] + arr[n/2]) / 2.0;
        } else {
            median = arr[n/2];
        }

        // Compute mode
        int maxFreq = 0;
        int mode = Integer.MAX_VALUE;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int freq = freqMap.getOrDefault(arr[i], 0) + 1;
            freqMap.put(arr[i], freq);
            if (freq > maxFreq || (freq == maxFreq && arr[i] < mode)) {
                maxFreq = freq;
                mode = arr[i];
            }
        }

        // Print results
        System.out.printf("%.1f\n", mean);
        System.out.printf("%.1f\n", median);
        System.out.println(mode);

        scanner.close();

    }
}
