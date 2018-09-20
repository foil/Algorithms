/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/
#include <iostream>
#include <vector>
using namespace std;

class SearchInRotatedSortedArr {
public:
    int search(vector<int>& nums, int target) {
        return SearchInRotatedSortedArr::partition(0, (int)nums.size() - 1, nums, target);
    }
private:
    static int partition(int s, int e, vector<int>& A, int t) {
        if (s == e)
            return A[s] == t? s: -1;
        else if (s > e)
            return -1;

        int m = (s + e) / 2;
        int res = -1;
        if (A[m] < A[e]) {
            res = bs(m, e, A, t);
            e = m - 1;
        } else {
            res = bs(s, m, A, t);
            s = m + 1;
        }
        if (res != -1)
            return res;

        if (A[e] > A[s])
            return bs(s, e, A, t);

        return partition(s, e, A, t);
    }
    static int bs(int s, int e, vector<int>& A, int t) {
        while (s <= e) {
            int m = (s + e) / 2;
            if (A[m] < t)
                s = m + 1;
            else if (A[m] > t)
                e = m - 1;
            else
                return m;
        }
        return -1;
    }
};

int main() {
    SearchInRotatedSortedArr s;
    vector<int> nums = {4,5,6,7,0,1,2};
    int i = s.search(nums, 7);
    cout << i << endl;
    nums.resize(0);
    i = s.search(nums, 7);
    cout << i << endl;
}
