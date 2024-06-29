import scala.annotation.tailrec
object headReplace {

    def replaceHeadEle[A]( list: List[A], ele: A):List[A] = {
        val newList = list match {
            case Nil => List(ele)
            case head::tail => ele::tail
        }
        newList
    }

        def dropNElement[A]( list: List[A], n: Int):List[A] = {


            def dropElement(list: List[A],  n: Int): List[A] = {
                print(list)
                if (n<=0){
                     list    // agar hum else use nhi karenge tab yha se ye return nhi hoga and pattern matchinh ma gusega
                }
                else {
 list match {
            case Nil => Nil
            case head::tail => dropElement(tail, n-1)
        }
                }
            }
                dropElement(list,n)

    }

         def dropWhile[A](list:List[A], f:A=> Boolean):List[A] = {
            list match {
                case head::tail if f(head) => dropWhile(tail, f)
                case l => l
            }
         }

def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
  def fold(as: List[A], z: B): B = {
    as match {
      case Nil => z
      case head :: tail => f(head, fold(tail, z))
    }
  }
  fold(as, z)
}

def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
  @tailrec
  def fold(as: List[A], acc: B): B = {
    as match {
      case Nil => acc
      case head :: tail => fold(tail, f(acc, head))
    }
  }
  fold(as, z)
}

def sum2(ns: List[Int]): Int =
  foldRight(ns, 0)((x, y) => x + y)

  def product(ns: List[Int]): Int =
  foldRight(ns, 1)((x, y) => x * y)

    def getLength(ns: List[Int]): Int =
  foldRight(ns, 0)((_, acc) => acc+1)

      def getLengthFoldLeft(ns: List[Int]): Int =
  foldLeft(ns, 0)((acc, _) => acc+1)

  def reverseListFoldLeft(ns: List[Int]): List[Int] =

  foldLeft(ns, List())((acc, head) => head::acc)

    def append[A](l: List[A], r: List[A]): List[A] = foldRight(l, r)((l,r)=>l::r)


  def flattenList[A](ns: List[List[A]]):List[A] = {
    foldRight(ns, List())((x,y)=> append(x,y))
  }



    def main(args: Array[String]): Unit = {
       val c = List(1,2,3,5,6,7)
       val list = replaceHeadEle(c, 29)
       println(list)
       val newList = dropNElement(list,2)
       println(newList)
       val dropList = dropWhile(newList, a=> a%2!=0)
       print(dropList)
       val sum = sum2(dropList)
       println(sum)
       val product1 = product(dropList)
       println(product1)
       val len = getLength(dropList)
       println(len)
       val len2 = getLengthFoldLeft(dropList)
       println(len2)
       val rvList = reverseListFoldLeft(dropList)
       println(rvList)
       val flatList = flattenList(List(List(1,2,3,4),List(3,4)))
       println(flatList)
    }
}