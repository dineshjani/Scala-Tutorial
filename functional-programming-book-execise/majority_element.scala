object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        nums.tail.foldLeft((nums(0),1)){
            case (x,y) if (x._1!=y && x._2==1) => (y,1)
            case (x,y) if(x._1!=y) => (x._1,x._2-1)
            case (x,y) => (y,x._2+1)
}._1
        
    }
}