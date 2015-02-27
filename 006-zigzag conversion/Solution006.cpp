#include <stdio.h>

//Attempt1: 26ms
class Solution006 {
public:
    string convert(string s, int nRows) {
      if (s.length() == 0 || nRows < 0)
        return "";
      if (nRows == 1)
        return s;

      string ret;
      int offset = 2 * nRows - 2;
      for (int j = 0; j < nRows; ++j) {
        for (int i = j; i < s.length(); i += offset) {
          ret.append(1, s[i]);
          if (j != 0 && j != nRows - 1 && i + 2 * nRows - 2 - 2 * j < s.length())
            ret.append(1, s[i + 2 * nRows - 2 - 2 * j]);
        }
      }
      return ret;
    }

};
