//Esha Sharma
import java.util.Scanner;
public class CMSC401_A4 {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rodSize = sc.nextInt();
        int numOfCutPoints = sc.nextInt();
        int[] cutPoints = new int[numOfCutPoints];
        for (int i = 0; i < numOfCutPoints; i++) {
            cutPoints[i] = sc.nextInt();
        }
        matrix = new int[numOfCutPoints][numOfCutPoints];


        for (int j = 0; j < matrix.length; j++) {
            for ( int k = 0; k < matrix.length; k++) {
                matrix[j][k] = -1;
            }
        }

        int minCost = findMinCost(cutPoints, 0, rodSize, 0, cutPoints.length - 1);
        System.out.println(minCost);

    }
    public static int findMinCost(int[] cutPoints, int startRod, int rodSize, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (matrix[start][end] != -1) {
            return matrix[start][end];
        }
        int minCost = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            int length = rodSize - startRod;
            int currentCost = length + findMinCost(cutPoints, startRod, cutPoints[i], start, i - 1)
                    + findMinCost(cutPoints, cutPoints[i], rodSize, i + 1, end);
            if (currentCost < minCost) {
                minCost = currentCost;
            }

        }
        matrix[start][end] = minCost;

        return minCost;
    }
}
