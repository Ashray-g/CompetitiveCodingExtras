package codechef;

import java.util.Scanner;

public class KAVGMAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(t=t;t>0;t--){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();
            long[][] mat = new long[n][m];
            for(int i = 0 ;i<n;i++){
                for(int j = 0;j<m;j++) mat[i][j] = scan.nextInt();
            }
            long[][] prefixSum = new long[n+1][m+1];
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=m;j++){
                    prefixSum[i][j] = mat[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
                }
            }
            int ans = 0;
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=m;j++){
                    int start = 0;
                    int end = Math.min(n-i, m-j);
                    int ind = -1;
                    while(start <= end){
                        int mid = (start +end)/2;
                        boolean works = false;
                        int newI = i + mid;
                        int newJ = j + mid;
                        long sum = prefixSum[newI][newJ] - prefixSum[newI][j-1] - prefixSum[i-1][newJ] + prefixSum[i-1][j-1];
                        if((long)sum >= (long)k * (long)(mid + 1) * (long)(mid+1)){
                            end = mid - 1;
                            ind = mid;
                        }else{
                            start = mid + 1;
                        }
                    }
                    if(ind != -1){
                        ans += Math.min(n - ind - i, m - ind - j) + 1;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
