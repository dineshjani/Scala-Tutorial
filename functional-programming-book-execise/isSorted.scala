object isSortedOrNot {
      def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
        def checkIsSorted(as:Array[A]):Boolean = {
            if (as.length <=1){
                true}
            else if(ordered(as.head, as.tail.head)){
                checkIsSorted(as.tail)
            }
            else {
                false
            }
        }
         
        checkIsSorted(as)
      }


 
    def main(args: Array[String]): Unit = {
    val strArray2 = Array("apple", "cherry", "banana")
  val isStrArray2Sorted = isSorted(strArray2, (a: String, b: String) => a <= b)
  println(isStrArray2Sorted) // Output: false
      val intArray2 = Array(1,2,3)
  val isIntArray2Sorted = isSorted(intArray2, (a: Int, b: Int) => a <= b)
  println(isIntArray2Sorted) // Output: true
    }
}