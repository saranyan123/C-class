#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> result;
        int i = 0;

        while (i < words.size()) {
            int j = i + 1;
            int lineLen = words[i].length();
         
            while (j < words.size() && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            string line = "";
            int numWords = j - i;

          
            if (j == words.size() || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (line.length() < maxWidth) line += ' ';
                }
                while (line.length() < maxWidth) line += ' ';
            } 
        
            else {
                int totalSpaces = maxWidth;
                for (int k = i; k < j; k++) totalSpaces -= words[k].length();
                
                int spaceSlots = numWords - 1;
                int evenSpace = totalSpaces / spaceSlots;
                int extraSpace = totalSpaces % spaceSlots;

                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (k < j - 1) {
                        int spacesToAdd = evenSpace + (extraSpace-- > 0 ? 1 : 0);
                        line.append(spacesToAdd, ' ');
                    }
                }
            }
            
            result.push_back(line);
            i = j; 
        }

        return result;
    }
};
