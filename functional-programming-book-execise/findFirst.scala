object findFirstObj {
      def findFirst[A](as: Array[A], func: (A) => Boolean): Boolean = {
        def checkFindFirst(as:Array[A]):Boolean = {
            if (as.length ==0){
                false}
            else if(!func(as.head)){
                checkFindFirst(as.tail)
            }
            else {
                return true
            }
        }
         
        checkFindFirst(as)
      }


 
    def main(args: Array[String]): Unit = {
    val strArray2 = Array("apple", "cherry", "banana")
    val isPresent = findFirst(strArray2, (a)=> a=="apple")
    println(isPresent)
        val notPresent = findFirst(strArray2, (a)=> a=="appleNOT")
    println(notPresent)
    }
}