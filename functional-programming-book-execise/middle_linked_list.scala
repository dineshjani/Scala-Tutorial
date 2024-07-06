/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def middleNode(head: ListNode): ListNode = {
        def recur(slow: ListNode,fast: ListNode): ListNode = {
            (slow,fast) match {
                case (slow,null) => slow
                case (slow,fast) if fast.next == null => slow
               case (slow,fast) => recur(slow.next,fast.next.next)         
}
        }
        recur(head,head)
    }
}