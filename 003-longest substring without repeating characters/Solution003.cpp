#include <stdio.h>
#include <string>
#include <algorithm>

class Solution003 {
public:
  //Attemp1: 21ms
  //DP with O(n) time complexity
  int lengthOfLongestSubstring(string s) {
    int lastVisited[256] = {-1};
    fill_n(lastVisited, 256, -1);
    int longest = 0, startingIndex = 0;
    for (int idx = 0; idx < s.length(); ++idx) {
      int lastIndex = lastVisited[s[idx]];
      if (lastIndex >= startingIndex) {
        int newLength = idx - startingIndex;
        longest = longest > newLength ? longest : newLength;
        startingIndex = lastIndex + 1;
      }
      lastVisited[s[idx]] = idx;
    }
    return longest >= s.length() - startingIndex ? longest : s.length - startingIndex;
  }

};

int main() {
  return 0;
}
