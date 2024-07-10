object Solution {
    def evalRPN(tokens: Array[String]): Int = {
       val operators = Set("+", "-", "*", "/")
       def recur(actualList: List[String],stack:List[Int]):Int = {
           actualList match {
               case Nil => stack.head
               case head::tail if(operators.contains(head)) => {
                   // println(stack)
                   // println(head)
                   stack match {
                             case b :: a :: stackTail => {
                                    val result = head match {
                                        case "+" => a + b
                                        case "-" => a - b
                                        case "*" => a * b
                                        case "/" => a / b
                                      }
                                     recur(tail, result :: stackTail)
                             }
                case _ => throw new IllegalArgumentException("Invalid RPN expression")
                   }
}
               case head::tail => recur(tail,head.toInt::stack)
           }
}
        recur(tokens.toList,List.empty)
    }
}