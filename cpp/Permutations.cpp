#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        backtrack(0, nums, res);
        return res;
    }
private:
    void backtrack(int idx, vector<int>& nums, vector<vector<int>> &res) {
        if (idx == nums.size()) {
            res.push_back(nums);
            return;
        }
        for (int i = idx; i < nums.size(); i ++) {
            swap(nums[i], nums[idx]);
            backtrack(idx + 1, nums, res);
            swap(nums[i], nums[idx]);
        }
    }
};

int main() {
    Solution s;
    vector<int> nums = {1,2,3};
    auto res = s.permute(nums);
    for (auto &v: res) {
        cout << '[';
        for (int n: v) {
            cout << n << ' ';
        }
        cout << ']' << endl;
    }
}
