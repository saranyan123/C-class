#include <iostream>
#include <string>
#include <vector>
#include <sstream>

class Solution {
public:
    std::string simplifyPath(std::string path) {
        std::vector<std::string> stack;
        std::stringstream ss(path);
        std::string component;
        while (std::getline(ss, component, '/')) {
            if (component == "" || component == ".") {
        
                continue;
            } else if (component == "..") {
      
                if (!stack.empty()) {
                    stack.pop_back();
                }
            } else {
           
                stack.push_back(component);
            }
        }

   
        if (stack.empty()) {
            return "/";
        }

        std::string result = "";
        for (const std::string& dir : stack) {
            result += "/" + dir;
        }

        return result;
    }
};
