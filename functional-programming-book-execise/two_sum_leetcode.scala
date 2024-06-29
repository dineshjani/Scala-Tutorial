object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val result = nums.zipWithIndex.foldLeft((Map.empty[Int, Int], Option.empty[Array[Int]]))              {
      case ((map, Some(arr)), _) => (map, Some(arr)) 
      case ((map, None), (num, index)) =>
        map.get(target - num) match {
          case Some(complementIndex) => (map, Some(Array(complementIndex, index)))
          case None => (map + (num -> index), None)
        }
    }
    result._2.getOrElse(Array.empty[Int]) 
    }
}

// zipwithindex return tuple with num,index
// foldleft (acc) fun this func btake one argument acc and another inoput from list and return acc
// Map.empty Option.empty[Array[int]]