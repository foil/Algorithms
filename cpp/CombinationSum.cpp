#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    static void bt(vector<int>& candidates, int i, int target, vector<vector<int>>& vec, vector<int>& subVec) {
        if (target <= 0) {
            if (target == 0)
                vec.push_back(subVec);
            return;
        }
        while (i < candidates.size()) {
            auto c = candidates[i];
            subVec.push_back(c);
            bt(candidates, i, target - c, vec, subVec);
            subVec.pop_back();
            i ++;
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> vec;
        vector<int> subVec;
        bt(candidates, 0, target, vec, subVec);
        return vec;
    }
};

int main() {
    Solution s;
    vector<int> candidates = {1,2,3};
    int target = 3;
    auto vec = s.combinationSum(candidates, target);
    for (auto subVec: vec) {
        for (auto n: subVec)
            cout << n << " ";
        cout << endl;
    }
}
