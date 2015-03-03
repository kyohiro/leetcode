#include <stdio.h>

//Attempt1: 16ms
class Solution008 {
public:
  int atoi(string str) {
    if (str.length() == 0)
      return 0;

    bool isNegative = false;
    int idx = 0;
    while (idx != str.length() && str[idx] == ' ')
      ++idx;
    str = str.substr(idx);

    if (str[0] == '-') {
      isNegative = true;
      str = str.substr(1);
    }
    else if (str[0] == '+')
      str = str.substr(1);

    long result = 0;
    idx = 0;
    while(idx != str.length()) {
      char c = str[idx++];
      int asc = (int)c;
      if (asc < 48 || asc > 57)
        break;
      else {
        result = result * 10 + asc - 48;
        if (!isNegative && result > INT_MAX)
          return INT_MAX;
        else if (isNegative && result - 1 > INT_MAX)
          return INT_MIN;
      }
    }

    return isNegative ? -1 * (int)result : (int)result;
  }
};
