class Solution017 {
//Attempt1: 2ms
public:
  vector<string> letterCombinations(string digits) {
    if (digits.length() == 0)
      return {};
    auto first = (int)digits[0] - 50;
      if (digits.length() == 1)
      return valuemap[first];
    else {
      vector<string> results;
      vector<string> sub = letterCombinations(digits.substr(1));
      for (auto i = 0; i < valuemap[first].size(); ++i) {
        for (auto j = 0; j < sub.size(); ++j) {
          results.push_back(valuemap[first][i] + sub[j]);
        }
      }
      return results;
    }
  }

private:
  vector<vector<string>> const valuemap {
    { "a", "b", "c" },
    { "d", "e", "f" },
    { "g", "h", "i" },
    { "j", "k", "l" },
    { "m", "n", "o" },
    { "p", "q", "r", "s" },
    { "t", "u", "v" },
    { "w", "x", "y", "z" } };
};
