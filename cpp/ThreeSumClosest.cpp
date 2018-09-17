#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class ThreeSumClosest {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int minDiff = 0x7FFFFFFF;
        int closest;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; i ++) {
            int j = i + 1, k = nums.size() - 1;
            while (j < k) {
                int v = nums[i] + nums[j] + nums[k];
                int diff = v - target;
                if (diff < 0) {
                    j ++;
                    diff = -diff;
                } else if (diff > 0)
                    k --;
                else
                    return v;
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = v;
                }
            }
        }
        return closest;
    }
};

int main() {
    /*
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     *
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    int n[] = {-1, 2, 1, -4};
    vector<int> nums(n, n + sizeof(n)/sizeof(n[0]));
    int target = 1;
    ThreeSumClosest t;
    int v = t.threeSumClosest(nums, target);
/*
    for (vector<int>::iterator it = nums.begin(); it != nums.end(); ++it)
        cout << *it << ' ';
    cout << endl;
*/
    cout << v << endl;

    return 0;
}
