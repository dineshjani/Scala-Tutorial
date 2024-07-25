object Solution {
    def reorganizeString(s: String): String = {
   val freqMap = s.groupBy(identity).view.mapValues(_.length).toMap

    def recur(map: Map[Char, Int], list: List[Char], exclude: Char): List[Char] = {
      if (map.isEmpty) list
      else {
        val validMap = map.view.filterKeys(_ != exclude)
        if (validMap.isEmpty) return Nil 
        val maxChar = validMap.maxBy(_._2)._1

        val newList = maxChar :: list

        val updatedMap = map.get(maxChar) match {
          case Some(count) if count == 1 => map - maxChar
          case Some(count) => map + (maxChar -> (count - 1))
          case None => map
        }

        recur(updatedMap, newList, maxChar)
      }
    }

    val resultList = recur(freqMap, List.empty, '\u0000')
    if (resultList.length == s.length) resultList.reverse.mkString("")
    else ""
}
}