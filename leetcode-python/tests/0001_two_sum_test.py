import importlib.util
from pathlib import Path
import unittest

PROJECT_ROOT = Path(__file__).resolve().parents[1]
MODULE_PATH = PROJECT_ROOT / "solutions" / "0001_two_sum.py"
spec = importlib.util.spec_from_file_location("solutions.two_sum_0001", MODULE_PATH)
two_sum_module = importlib.util.module_from_spec(spec)
spec.loader.exec_module(two_sum_module)
Solution = two_sum_module.Solution


class TestTwoSum(unittest.TestCase):
    """Two Sum 问题的单元测试"""

    def setUp(self):
        """每个测试前初始化 Solution 实例"""
        self.solution = Solution()

    def test_example_case(self):
        """测试 LeetCode 官方示例：[2,7,11,15], target=9"""
        self.assertEqual(self.solution.twoSum([2, 7, 11, 15], 9), [0, 1])

    def test_unsorted_with_duplicates(self):
        """测试无序数组：[3,2,4], target=6"""
        self.assertEqual(self.solution.twoSum([3, 2, 4], 6), [1, 2])

    def test_duplicate_values(self):
        """测试重复值：[3,3], target=6"""
        self.assertEqual(self.solution.twoSum([3, 3], 6), [0, 1])

    def test_minimum_array(self):
        """测试最小数组（2个元素）：[1,2], target=3"""
        self.assertEqual(self.solution.twoSum([1, 2], 3), [0, 1])

    def test_negative_numbers(self):
        """测试负数：[-3,4,3,90], target=0"""
        self.assertEqual(self.solution.twoSum([-3, 4, 3, 90], 0), [0, 2])

    def test_with_zero(self):
        """测试包含零的情况：[0,4,3,0], target=0"""
        self.assertEqual(self.solution.twoSum([0, 4, 3, 0], 0), [0, 3])

    def test_large_numbers(self):
        """测试大数值：[1000000000, 2, 1000000000], target=2000000000"""
        self.assertEqual(self.solution.twoSum([1000000000, 2, 1000000000], 2000000000), [0, 2])


if __name__ == '__main__':
    unittest.main()