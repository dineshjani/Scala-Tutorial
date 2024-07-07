object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        s.toList.zipWithIndex.foldLeft((Map.empty[Char, Int], -1, 0)) {
      case ((mp, curLeftIndex, ans), (ele, index)) if !mp.contains(ele) =>
        (mp + (ele -> index), curLeftIndex, Math.max(ans, index - curLeftIndex))

      case ((mp, curLeftIndex, ans), (ele, index)) =>
        val newCurLeftIndex = Math.max(mp(ele), curLeftIndex)
        val newAns = Math.max(ans, index - newCurLeftIndex)
        (mp + (ele -> index), newCurLeftIndex, newAns)
    }._3

    }
}