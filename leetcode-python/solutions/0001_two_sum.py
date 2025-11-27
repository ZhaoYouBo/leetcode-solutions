class Solution:
    """
    两数之和 - 哈希表解法
    时间复杂度: O(n)
    空间复杂度: O(n)
    """
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        # 创建哈希表，用于存储 {数值: 索引} 的映射关系
        records = dict()

        # 遍历数组，index 为当前索引，value 为当前值
        for index, value in enumerate(nums):
            # 计算差值：target - value
            if target - value in records:
                # 返回两个数的索引：[之前记录的索引, 当前索引]
                return [records[target - value], index]

            # 将当前数值及其索引存入哈希表，供后续查找使用
            records[value] = index

        return []