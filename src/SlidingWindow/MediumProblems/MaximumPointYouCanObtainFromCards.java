package SlidingWindow.MediumProblems;

public class MaximumPointYouCanObtainFromCards {
    public int maxScore_sol1(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int i = 0, j = n-1;
        int sum = 0, res = 0;

        while(i < k) {
            sum += cardPoints[i];
            i++;
        }
        res = Math.max(res, sum);
        i = k-1;
        while(i >= 0) {
            sum = sum - cardPoints[i] + cardPoints[j];
            res = Math.max(res, sum);
            j--;
            i--;
        }
        return res;
    }
    //--------------------------------------------------------------------------------------------------------------
    public int maxScore_sol2(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] leftToRightSum = new int[n];
        int[] rightToLeftSum = new int[n];
        int sum1 = 0, sum2 = 0;
        for(int i=0; i<n; i++) {
            sum1 += cardPoints[i];
            sum2 += cardPoints[n-i-1];
            leftToRightSum[i] = sum1;
            rightToLeftSum[n-i-1] = sum2;
        }

        int sum = 0;
        sum = Math.max(sum, leftToRightSum[k-1]);
        sum = Math.max(sum, rightToLeftSum[n-k]);

        for(int i=0; i<k-1; i++) {
            sum = Math.max(sum, leftToRightSum[i] + rightToLeftSum[n-k+i+1]);
        }
        return sum;
    }
}
