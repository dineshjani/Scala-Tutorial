object Solution {
    def isAnagram(s: String, t: String): Boolean = {
         if (s.length != t.length) {
      false
    } else {
      val countChars = (str: String) =>
        str.toSeq.groupBy(identity).view.mapValues(_.size).toMap

      countChars(s) == countChars(t)
    }
    }
}