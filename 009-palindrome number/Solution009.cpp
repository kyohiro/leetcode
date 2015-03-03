#include <stdio.h>

//Attempt1: 126ms
class Solution009 {
public:
  bool isPalindrome(int x) {
    if (x < 0)
      return false;

    int p = x;
    long y = 0;
    while (p > 0) {
      y = y * 10 + p % 10;
      p /= 10;
    }

    return x == y;
  }
};
