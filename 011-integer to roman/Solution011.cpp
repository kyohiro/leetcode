class Solution011 {
//Attempt1: 56ms
public:
  string intToRoman(int num) {
    std::vector<std::string> symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    std::vector<int> values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    std::string result;
    for (int i = 0; num != 0; ++i) {
      while (num > values[i]) {
        num -= values[i];
        result += symbols[i];
      }
    }

    return result;
  }
};
