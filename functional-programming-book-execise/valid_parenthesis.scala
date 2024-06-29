import scala.annotation.tailrec

object Solution {
    def isValid(s: String): Boolean = {
    val openBrackets = Set('{', '[', '(')
    val closeToOpen = Map('}' -> '{', ']' -> '[', ')' -> '(')
    
    @tailrec
    def recur(chars: List[Char], stack: List[Char]): Boolean = {
      chars match {
        case Nil => stack.isEmpty
        case head :: tail if openBrackets(head) =>
          recur(tail, head :: stack)
        case head :: tail if closeToOpen.contains(head) =>
          stack match {
            case Nil => false
            case top :: rest if top == closeToOpen(head) =>
              recur(tail, rest)
            case _ => false
          }
        case _ :: tail => recur(tail, stack)
      }
    }
    
    recur(s.toList, List.empty)
}
}
                                               
                                               
//import scala.annotation.tailrec
// openBrackets(head) set check membership in scala
// list.empty
//map membership using contains