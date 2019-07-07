#include <iostream>
#include <vector>
#include "Trie.h"

class Solution {
public:
    std::string longestWord(std::vector<std::string>& words) {
        Trie root;
        for (auto &&word: words)
            root.insert(word, 0);

        root.setData("0");
        return dfs(&root);
    }
private:
    std::string dfs(Trie * ptr) {
        std::string ans = ptr->getData();
        if (ans.empty())
            return "";
        if (ans == "0")
            ans = "";
        
        for (auto &&pair: ptr->getMap()) {
            std::string str = dfs(pair.second);
            if (str.size() > ans.size() ||
                    (str.size() == ans.size() && str.compare(ans) < 0))
                ans = str;
        }
        return ans;
    }
};

int main(int argc, const char * argv[]) {
    std::vector<std::string> words({"a", "banana", "app", "appl", "ap", "apply", "apple"});
    Solution s;
    std::cout << s.longestWord(words) << std::endl;
    return 0;
}
