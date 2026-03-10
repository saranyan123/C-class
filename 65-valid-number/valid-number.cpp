#include <string>
#include <cctype>

class Solution {
public:
    bool isNumber(std::string s) {
        bool seenDigit = false;
        bool seenDot = false;
        bool seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];

            if (std::isdigit(c)) {
                seenDigit = true;
            } 
            else if (c == '+' || c == '-') {
              
                if (i > 0 && s[i - 1] != 'e' && s[i - 1] != 'E') {
                    return false;
                }
            } 
            else if (c == 'e' || c == 'E') {
            
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; 
            } 
            else if (c == '.') {
         
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } 
            else {
         
                return false;
            }
        }

        return seenDigit;
    }
};
