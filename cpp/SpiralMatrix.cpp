#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int csteps[] = {1, 0, -1, 0};
        int rsteps[] = {0, 1, 0, -1};
        vector<int> res;
        size_t R = matrix.size();
        if (R == 0)
            return res;
        size_t C = matrix[0].size();
        if (C == 0)
            return res;

        vector<bool> visited(R * C, false);
        int dir = 0, steps = 0, r = 0, c = 0;
        
        while (steps < R * C) {
            res.push_back(matrix[r][c]);
            visited[r * C + c] = true;
            
            int tr = r + rsteps[dir % 4];
            int tc = c + csteps[dir % 4];
            if (!(tr >= 0 && tr < R &&
                tc >= 0 && tc < C &&
                !visited[tr * C + tc])) {
                dir++;
                tr = r + rsteps[dir % 4];
                tc = c + csteps[dir % 4];
            }
            r = tr, c = tc;
            steps++;
        }
        return res;
    }
};

int main() {
    Solution s;
    //vector<vector<int>> matrix = {{1,2,3,4,5,6,7,8,9,10}};
    vector<vector<int>> matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    vector<int> res = s.spiralOrder(matrix);
    for (auto n: res)
        cout << n << ' ';
    cout << endl;
}
