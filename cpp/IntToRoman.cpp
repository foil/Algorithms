
#include <iostream>
using namespace std;

class Solution {
public:
    string intToRoman(int num) {
        printf("%d\n", num);
        string s = "";
        while (num > 0) {
            if (num >= 1000) {
                s += "M";
                num -= 1000;
            } else if (num >= 900) {
                s += "CM";
                num -= 900;
            } else if (num >= 500) {
                s += "D";
                for (int i = 0; i < (num - 500) / 100; i ++)
                    s += "C";
                num = num % 100;
            } else if (num >= 400) {
                s += "CD";
                num -= 400;
            } else if (num >= 100) {
                int d = num / 100;
                for (int i = 0; i < d; i ++)
                    s += "C";
                num = num % 100;
            } else if (num >= 90) {
                s += "XC";
                num -= 90;
            } else if (num >= 50) {
                s += "L";
                for (int i = 0; i < (num - 50) / 10; i ++) {
                    s += "X";
                }
                num = num % 10;
            } else if (num >= 40) {
                s += "XL";
                num -= 40;
            } else if (num >= 10) {
                int d = num / 10;
                for (int i = 0; i < d; i ++)
                    s += "X";
                num = num % 10;
            } else if (num >= 9) {
                s += "IX";
                num -= 9;
            } else if (num >= 5) {
                s += "V";
                for (int i = 0; i < (num - 5); i ++)
                    s += "I";
                num = 0;
            } else if (num >= 4) {
                s += "IV";
                num = 0;
            } else {
                for (int i = 0; i < num; i ++)
                    s += "I";
                num = 0;
            }
        }
        return s;
    }
};
int main() {
    Solution s;
    string str = s.intToRoman(60);
    cout << str << endl;
}
