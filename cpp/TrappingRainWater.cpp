#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int L = height.size();
        vector<int> maxL(L, 0), maxR(L, 0);
        int curMax = 0;
        for (int i = 0; i < L - 1; i ++) {
            if (height[i] > curMax)
                curMax = height[i];
            maxL[i + 1] = curMax;
        }
        curMax = 0;
        for (int i = L - 1; i > 0; i --) {
            if (height[i] > curMax)
                curMax = height[i];
            maxR[i - 1] = curMax;
        }
        int total = 0;
        for (int i = 0; i < L; i ++) {
            if (maxL[i] > height[i] && maxR[i] > height[i])
                total += min(maxL[i], maxR[i]) - height[i];
        }
        return total;
    }
};

int main() {
    vector<int> height = {0,1,0,2,1,0,1,3,2,1,2,1};
    Solution s;
    cout << s.trap(height) << endl;
}
