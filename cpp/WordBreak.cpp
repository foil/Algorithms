#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
/*    private:
        static bool bt(string s, int start, vector<string>& wordDict) {
            if (start == s.size())
                return true;

            for (string d: wordDict) {
                if (s.compare(start, d.size(), d) == 0) {
                    if (bt(s, start + d.size(), wordDict))
                        return true;
                }
            }
            return false;
        }*/
    public:
        bool wordBreak(string s, vector<string>& wordDict) {
            vector<bool> dp(s.size() + 1, false);
            dp[0] = true;
            unordered_set<string> uSet(wordDict.begin(), wordDict.end());
            for (int i = 1; i <= s.size(); i ++) {
                for (int j = 0; j < i; j ++) {
                    if (dp[j] && uSet.find(s.substr(j, i - j)) != uSet.end()) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.size()];
        }
};

int main() {
    Solution s;
    vector<string> dict1({"leet", "code"});
    cout << s.wordBreak("leetcode", dict1) << endl;
    vector<string> dict2({"apple", "pen"});
    cout << s.wordBreak("applepenapple", dict2) << endl;
    vector<string> dict3({"cats", "dog", "sand", "and", "cat"});
    cout << s.wordBreak("catsandog", dict3) << endl;

    string str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

    vector<string> dict4({"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"});
    cout << s.wordBreak(str, dict4) << endl;
}
