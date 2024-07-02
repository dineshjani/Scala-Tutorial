/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution extends VersionControl {
     def firstBadVersion(n: Int): Int = {
        def findVersion(low:Int,high:Int): Int = {
            val mid = low + ((high - low) / 2) // avoid overflow
            isBadVersion(mid) match {
                case true if low>=high => mid
                case true => findVersion(low,mid)
                case _ => findVersion(mid+1,high)
                
}
}
        findVersion(0,n)
        
    }
}