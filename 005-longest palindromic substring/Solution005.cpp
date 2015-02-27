#include <stdio.h>

//Attempt1: 108ms
class Solution005 {
public:
  string longestPalindrome(string s) {
    if (s.length() == 0)
      return "";

    string longest = s.substr(0, 1);
    for (int i = 0; i < s.length() - 1; ++i) {
      string palindrome = getPalindromeAround(s, i, i);
      if (palindrome.length() > longest.length())
        longest = palindrome;
      palindrome = getPalindromeAround(s, i, i + 1);
      if (palindrome.length() > longest.length())
        longest = palindrome;
    }

    return longest;
  }

private:
  string getPalindromeAround(String s, int l, int r) {
    if (s[l--] != s[r++])
      return "";

    while (l >= 0 && r <= s.length() - 1) {
      if (s[l] != s[r])
        break;
      else --l, ++r;
    }

    return s.substr(l + 1, r - l - 1);
  }

};
