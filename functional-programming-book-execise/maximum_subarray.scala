object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
     nums.tail.foldLeft((nums(0), nums(0))) { case ((currentMax, globalMax), num) =>
            val newCurrentMax = Math.max(num, currentMax + num)
            val newGlobalMax = Math.max(globalMax, newCurrentMax)
            (newCurrentMax, newGlobalMax)
        }._2
    }
}