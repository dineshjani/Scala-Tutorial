object Solution {
    def containsDuplicate(nums: Array[Int]): Boolean = {
        nums.foldLeft((false,Map.empty[Int,Int])){
            case ((true,mp),_) => (true,mp)
            case((false,mp),ele) if(mp.get(ele))!=None => (true,mp)
            case  ((false,mp),ele) => (false,mp + (ele -> mp.getOrElse(ele,1))      )
}._1
    }
}

// def containsDuplicate(nums: Array[Int]): Boolean = {
// 	nums.size != nums.toSet.size
// }