object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
        val magazineMap = magazine.toList.foldLeft(Map.empty[Char, Int]) {
            case (map, char) => map + (char -> (map.getOrElse(char, 0) + 1))
        }
        
        ransomNote.toList.foldLeft((magazineMap, true)) {
            case ((map, true), char) =>
                map.get(char) match {
                    case Some(count) if count > 0 => (map + (char -> (count - 1)), true)
                    case _ => (map, false)
                }
            case (acc, _) => acc
        }._2
}
}


// + operator to add in map
// get or getOrElse
//Map.empty[Char,Int]