#include <stdio.h>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Solution {
public:
	//Attempt1: 40ms 
	//This solution is problematic cause using map will override the first element's index if there're duplicates 
	//But it appears to be correct as it says there'd be only one solution
	vector<int> twoSum(vector<int> &numbers, int target) {
		map<int, int> numbersMap;
		for (auto idx = 0; idx != numbers.size(); ++idx) 
			numbersMap.insert(pair<int, int>(numbers[idx], idx + 1));

		for (auto idx = 0; idx != numbers.size(); ++idx) {
			int remaining = target - numbers[idx];
			auto findTarget = numbersMap.find(remaining);
			if (findTarget != numbersMap.end()) {
				int secondIdx = findTarget->second;
				if (idx + 1 != secondIdx) {
					vector<int> result{ idx + 1, secondIdx };
					sort(result.begin(), result.end());
					return result;
				}
			}
		}
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
	Solution s;
	vector<int> ret = s.twoSum(numbers, -8);

	return 0;
}
