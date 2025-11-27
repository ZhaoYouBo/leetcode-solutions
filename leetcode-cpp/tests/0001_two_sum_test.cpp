#include <cassert>
#include <iostream>
#include <string>
#include <vector>

#include "../solutions/0001_two_sum.cpp"

namespace
{
    void ExpectVecEq(const std::vector<int>& expected,
        const std::vector<int>& actual,
        const std::string& caseName)
    {
        assert(expected.size() == actual.size() && "结果长度不一致");
        for (size_t i = 0; i < expected.size(); ++i)
        {
            assert(expected[i] == actual[i] && "结果值不一致");
        }
        std::cout << "[PASS] " << caseName << std::endl;
    }

    void RunCase(const std::string& caseName,
        std::vector<int> nums,
        int target,
        const std::vector<int>& expected)
    {
        Solution solution;
        auto actual = solution.twoSum(nums, target);
        ExpectVecEq(expected, actual, caseName);
    }

    void RunTest()
    {
        RunCase("示例用例", { 2, 7, 11, 15 }, 9, { 0, 1 });
        RunCase("重复数字", { 3, 3 }, 6, { 0, 1 });
        RunCase("无序数组", { 3, 2, 4 }, 6, { 1, 2 });
        RunCase("包含负数", { -3, 4, 3, 90 }, 0, { 0, 2 });
        RunCase("较长数组", { 1, 5, 3, 6, 9, 4, 8 }, 10, { 0, 4 });

        std::cout << "全部测试通过" << std::endl;
    }
}

int main()
{
    RunTest();
    return 0;
}