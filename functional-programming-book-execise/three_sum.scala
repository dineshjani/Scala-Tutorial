object Solution {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
    def twoSum(nums: List[Int], target: Int, first: Int): List[List[Int]] = {
    def skipLeftDuplicates(left: Int, lastValue: Int): Int = {
      if ((left < nums.length) && (nums(left) == lastValue)) {
          skipLeftDuplicates(left + 1, lastValue)
      }
      else left
    }

    def skipRightDuplicates(right: Int, lastValue: Int): Int = {
          if (right >= 0 && nums(right) == lastValue) skipRightDuplicates(right - 1, lastValue)
          else right
        }
      @annotation.tailrec
      def loop(nums: List[Int], left: Int, right: Int, acc: List[List[Int]]): List[List[Int]] = {
        if (left >= right) acc
        else {
          val sum = nums(left) + nums(right)
          if (sum == target) {
              val newLeft = skipLeftDuplicates(left + 1, nums(left))
              val newRight = skipRightDuplicates(right - 1, nums(right))
              val newAcc = acc :+ List(first, nums(left), nums(right))
                      loop(nums, newLeft, newRight, newAcc)
          } else if (sum < target) {
            loop(nums, left + 1, right, acc)
          } else {
            loop(nums, left, right - 1, acc)
          }
        }
      }
      loop(nums, 0, nums.length - 1, List())
    }

    @annotation.tailrec
    def threeSumRec(nums: List[Int], result: List[List[Int]]): List[List[Int]] = nums match {
      case Nil => result
      case head :: tail =>
        if (result.nonEmpty && head == result.head.head) {
          threeSumRec(tail, result)
        } else {
          val twoSumResult = twoSum(tail, -head, head)
          threeSumRec(tail,  twoSumResult ++ result)
        }
    }

    val sortedNums = nums.sorted.toList
    threeSumRec(sortedNums, List())
    }
}




//  // Move the left pointer to skip duplicates
//             val newLeft = Stream.from(left + 1).dropWhile(i => i < nums.length && nums(i) == nums(left)).headOption.getOrElse(right + 1)
//             // Move the right pointer to skip duplicates
//             val newRight = Stream.from(right - 1, -1).dropWhile(i => i >= 0 && nums(i) == nums(right)).headOption.getOrElse(left - 1)
