int Solution::isMatch(const string A, const string B) {
    int i,j;
    int m = A.length();
    int n = B.length();
    int dp[m+1][n+1];
    memset(dp, false,sizeof(dp));
    dp[0][0] = true;
    for(j=1;j<n+1;j++) {
        dp[0][j] = dp[0][j-2];
    }
    for(i=1;i<=m;i++) {
        for(j=1;j<=n;j++) {
            if(A[i-1] == B[j-1] || B[j-1] == '.') {
                dp[i][j] = dp[i-1][j-1];
            } else {
                if(B[j-1] == '*') {
                    dp[i][j] = dp[i][j-2];
                    if(B[j-2] == '.' || B[j-2] == A[i-1]) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
    }
    return dp[m][n];
}
