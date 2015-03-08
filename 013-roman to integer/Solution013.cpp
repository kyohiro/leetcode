#include <stdio.h>
#include <map>

class Solution013 {
//Attempt1: 85ms
public:
  int romanToInt(string s) {
    std::map<char, int> symbolMap = {{'M', 1000}, {'D', 500}, {'C', 100}, {'L', 50}, {'X', 10}, {'V', 5}, {'I', 1}};

    int result = 0;
    for (auto i = 0; i != s.length(); ++i) {
      if (i != s.length() - 1 && symbolMap[s[i]] < symbolMap[s[i + 1]]) {
        result += symbolMap[s[i + 1]];
        result -= symbolMap[s[i]];
        ++i;
      }
      else {
        result += symbolMap[s[i]];
      }
    }

    return result;
  }
};
