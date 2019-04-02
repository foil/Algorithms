#include <iostream>
#include <vector>
using namespace std;

class Solution {
    public:
        bool PredictTheWinner(vector<int>& nums) {
            int sz = nums.size();
            vector<vector<vector<int>>> dp(sz, vector<vector<int>>(sz, vector<int>(2, 0)));
            for (int i = 0; i < sz; i ++) {
                dp[i][i][0] = nums[i];
            }

            for (int d = 1; d < sz; d ++)
                for (int i = 0; i < sz - 1; i ++)
                    if (i + d < sz) {
                        int r = dp[i][i + d - 1][1] + nums[i + d];
                        int l = dp[i + 1][i + d][1] + nums[i];
                        if (r > l) {
                            dp[i][i + d][0] = r;
                            dp[i][i + d][1] = dp[i][i + d - 1][0];
                        } else {
                            dp[i][i + d][0] = l;
                            dp[i][i + d][1] = dp[i + 1][i + d][0];
                        }
                    }

            return dp[0][sz - 1][0] >= dp[0][sz - 1][1];
        }
};

int main() {
    Solution s;
    vector<int> nums{1,5,2};
    cout << s.PredictTheWinner(nums) << endl;
}
    
