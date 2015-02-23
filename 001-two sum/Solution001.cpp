#include <stdio.h>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Solution001 {
public:
  //Attempt1: 40ms
  //std::map does not accept duplicate keys, so if the answer is two same elements
  //The target found in the map is always the first so that result needs to be reverted
  vector<int> twoSum(vector<int> &numbers, int target) {
    map<int, int> numbersMap;
    for (auto idx = 0; idx != numbers.size(); ++idx)
      numbersMap.insert(pair<int, int>(numbers[idx], idx));

    for (auto idx = 0; idx != numbers.size(); ++idx) {
      int remaining = target - numbers[idx];
      auto findTarget = numbersMap.find(remaining);
      if (findTarget != numbersMap.end()) {
        int secondIdx = findTarget->second;
        if (idx != secondIdx) {
          vector<int> result{ idx + 1, secondIdx + 1 };
          sort(result.begin(), result.end());
          return result;
        }
      }
    }
    
    throw "No valid solution for input.";
  }

  //Attempt2: 33ms
  vector<int> twoSum2(vector<int> &numbers, int target) {
    int size = numbers.size(), l = 0, r = size - 1;

    vector<pair<int, int>> numberPairs;
    for (auto idx = 0; idx != size; ++idx)
      numberPairs.push_back(make_pair(numbers[idx], idx + 1));
    sort(numberPairs.begin(), numberPairs.end());

    while (l < r) {
      int sum = numberPairs[l].first + numberPairs[r].first;
      if (sum < target) ++l;
      else if (sum > target) --r;
      else {
        vector<int> result{ numberPairs[l].second, numberPairs[r].second };
        sort(result.begin(), result.end());
        return result;
      }
    }
  }

};

int main()
{
  vector<int> numbers{ -1, -2, -3, -4, -5 };
  Solution001 s;
  vector<int> ret = s.twoSum(numbers, -8);

  return 0;
}
