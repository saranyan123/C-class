#include <vector>
#include <string>
#include <climits>

using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        if (s.empty() || t.empty()) return "";

        vector<int> targetCount(128, 0);
        for (char c : t) targetCount[c]++;

        vector<int> windowCount(128, 0);
        int left = 0, right = 0;
        int required = 0; 
        for (int i = 0; i < 128; i++) {
            if (targetCount[i] > 0) required++;
        }

        int formed = 0; 
        int minLen = INT_MAX;
        int startIdx = 0;

        while (right < s.length()) {
            char c = s[right];
            windowCount[c]++;

  
            if (targetCount[c] > 0 && windowCount[c] == targetCount[c]) {
                formed++;
            }

     
            while (left <= right && formed == required) {
                c = s[left];

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

     
                windowCount[c]--;
                if (targetCount[c] > 0 && windowCount[c] < targetCount[c]) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == INT_MAX ? "" : s.substr(startIdx, minLen);
    }
};
