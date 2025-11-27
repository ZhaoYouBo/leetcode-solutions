#include <vector>
#include <unordered_map>
using std::vector;

class Solution {
public:
    /**
     * 两数之和 - 哈希表解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    vector<int> twoSum(vector<int>& nums, int target) {
        // 哈希表：key存储数组元素值，value存储该元素的索引
        std::unordered_map<int, int> myMap;

        // 遍历数组
        for (int i = 0; i < nums.size(); i++)
        {
            // 计算目标差值，并在哈希表中查找
            auto iter = myMap.find(target - nums[i]);

            if (iter != myMap.end())  // 找到配对的数
            {
                // 返回两个索引：之前找到的数的索引 和 当前索引
                return { iter->second, i };
            }
            else  // 未找到配对
            {
                // 将当前元素及其索引存入哈希表，供后续查找使用
                myMap.insert(std::pair<int, int>(nums[i], i));
            }
        }

        return {};
    }
};