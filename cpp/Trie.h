#ifndef TRIE_H
#define TRIE_H
#include <unordered_map>
//#include <unique_ptr>

class Trie {
private:
    std::unordered_map<char, Trie*> map;
    std::string data;
public:
    Trie() {}
    void setData(std::string d) {
        data = d;
    }
    std::string getData() {
        return data;
    }

    void insert(std::string str, int idx) {
        char c = str[idx];
        Trie* ptr;
        auto got = map.find(c);
        if (got == map.end()) {
            ptr = new Trie;
            map.insert(std::make_pair(c, ptr));
        } else {
            ptr = got->second;
        }

        if (idx == str.size() - 1)
            ptr->setData(str);
        else
            ptr->insert(str, idx + 1);
    }
    const std::unordered_map<char, Trie*>& getMap() const {
        return map;
    }
};
#endif
