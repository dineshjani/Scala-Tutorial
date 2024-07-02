/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def hasCycle(head: ListNode): Boolean = {
        if(head==null || head.next==null){
            return false
        }
           def recur(slow: ListNode,fast: ListNode):Boolean = {
            (slow,fast) match {
                case (slow,fast) if(fast==null || fast.next==null) => false
                case (slow,fast) if slow==fast => true
                case (slow,fast) => recur(slow.next, fast.next.next)
        }
   }
        recur(head.next,head.next.next)
    }
}