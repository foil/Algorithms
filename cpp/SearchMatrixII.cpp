#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int h = matrix.size();
        if (h == 0)
            return false;
        int w = matrix[0].size();
        if (w == 0)
            return false;
        vector<vector<bool>> visited(h);
        for (int i = 0; i < w; i ++) {
            vector<bool> vv(w);
            visited.push_back(vv);
        }
        int y = h - 1, x = 0;
        while (true) {
            visited[y][x] = true;
            int v = matrix[y][x];
            cout << y << x << v << endl;
            if (v == target)
                return true;
            else if (v > target) {
                bool up = false, left = false;
                if (y - 1 >= 0 && !visited[y-1][x])
                    up = true;
                if (x - 1 >= 0 && !visited[y][x-1])
                    left = true;
                if (!up && !left)
                    return false;
                else if (up && !left)
                    y -= 1;
                else if (!up && left)
                    x -= 1;
                else {
                    if (matrix[y-1][x] > matrix[y][x-1])
                        y -= 1;
                    else
                        x-= 1;
                }
            } else {
                bool down = false, right = false;
                if (y + 1 < h && !visited[y+1][x])
                    down = true;
                if ((x + 1 < w) && (!visited[y][x+1]))
                    right = true;
                if (down && right) {
                    if (matrix[y+1][x] < matrix[y][x+1])
                        y += 1;
                    else
                        x += 1;
                } else if (down && !right)
                    y += 1;
                else if (!down && right)
                    x += 1;
                else 
                    return false;
            }
        }
        return false;
    }
};

int main() {
    Solution s;
    vector<int> v({1,1});
    vector<vector<int>> vv;
    vv.push_back(v);
    cout << s.searchMatrix(vv, 2) << endl;
    return 0;
}
