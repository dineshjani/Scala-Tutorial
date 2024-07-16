object Solution {
    def permute(nums: Array[Int]): List[List[Int]] = {
        def permutation(nums: List[Int], start: Int, end: Int): List[List[Int]] = {
      if (start == end) {
        List(nums)
      } else {
        (start to end).toList.flatMap { i =>
          val swappedNums = swap(nums, start, i)
          permutation(swappedNums, start + 1, end)
        }
      }
    }

        def swap(nums: List[Int], i: Int, j: Int): List[Int] = {
          if (i == j) nums
          else {
            nums.updated(i, nums(j)).updated(j, nums(i))
          }
        }

        permutation(nums.toList, 0, nums.length - 1)
    }
}