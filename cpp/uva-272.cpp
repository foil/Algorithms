#include <iostream>
#include <sstream>
using namespace std;

int main() {
    string in = "\"To be or not to be,\" quoth the Bard, \"that\n"
        "is the question\".\n"
        "The programming contestant replied: \"I must disagree.\n"
        "To `C' or not to `C', that is The Question!\"";
    string out = "``To be or not to be,'' quoth the Bard, ``that\n"
        "is the question''.\n"
        "The programming contestant replied: ``I must disagree.\n"
        "To `C' or not to `C', that is The Question!''";

    istringstream is(in);
    bool quoted = false;
    string res = "";
    for (string line; getline(is, line); ) {
        for (string::iterator i = line.begin(); i < line.end(); i ++)
            if (*i == '"') {
                res += quoted? "''": "``";
                quoted = !quoted;
            } else
                res += *i;
        res += '\n';
    }
    
    cout << res ;
    return 0;
}
