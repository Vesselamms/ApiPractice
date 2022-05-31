package API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question1 {

    public static ArrayList<Integer> minValues = new ArrayList<Integer>();
    public static ArrayList<Integer> maxValues = new ArrayList<Integer>();

    static void findMinDiff(int[] arr, int n) {
        // Sort array
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] < diff) {
                diff = arr[i + 1] - arr[i];
                minValues.clear();
                maxValues.clear();
                minValues.add(Integer.min(arr[i + 1] , arr[i]));
                maxValues.add(Integer.max(arr[i + 1] , arr[i]));
            }
            else if (arr[i + 1] - arr[i] == diff) {
                minValues.add(Integer.min(arr[i + 1] , arr[i]));
                maxValues.add(Integer.max(arr[i + 1] , arr[i]));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        findMinDiff(arr, arr.length);
        for (int i = 0; i < minValues.size(); i++) {
            System.out.print(minValues.get(i) + " " + maxValues.get(i));
        }
    }
}



