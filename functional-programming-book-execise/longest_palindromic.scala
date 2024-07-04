object Solution {
    def longestPalindrome(s: String): Int = {
      val newMap = s.toList.foldLeft(Map.empty[Char,Int]){
          case (mp,ch) => mp + (ch -> (mp.getOrElse(ch,0)+1))
}
        val odd = newMap.values.count(_ % 2 != 0)
        if(odd!=0) s.length()-odd+1 else s.length()
        
    }
}