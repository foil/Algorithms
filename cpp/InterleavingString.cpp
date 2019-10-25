/**
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
**/

#include <iostream>

using namespace std;

class Solution
{
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s3.size() != s1.size() + s2.size())
            return false;

        bool dp[s1.size() + 1][s2.size() + 1] = {false};

        for (int i = 0; i < sizeof(dp) / sizeof(dp[0]); i ++) {
            for (int j = 0; j < sizeof(dp[0]); j ++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = (s2[j-1] == s3[j-1] && dp[i][j-1]);
                else if (j == 0)
                    dp[i][j] = (s1[i-1] == s3[i-1] && dp[i-1][j]);
                else
                    dp[i][j] = ((s1[i-1] == s3[i+j-1] && dp[i-1][j]) || (s2[j-1] == s3[i+j-1] && dp[i][j-1]));
            }
        }
        return dp[s1.size()][s2.size()];
    }
};

int main() {
    Solution s;
    cout << s.isInterleave("aabcc", "dbbca", "aadbbcbcac") << endl;
    return 0;
}