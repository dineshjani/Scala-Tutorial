/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {

        def recur(l1: ListNode, l2: ListNode): ListNode = (l1, l2) match {
            case (null, null) => null
            case (null, _) => l2
            case (_, null) => l1
            case (l1, l2) if l1.x <= l2.x =>
                new ListNode(l1.x, recur(l1.next, l2))
            case (l1, l2) =>
                new ListNode(l2.x, recur(l1, l2.next))
        }

        recur(list1, list2)
    }
}

// Example usage
class ListNode(var x: Int = 0, var next: ListNode = null)

object Main extends App {
    def printList(node: ListNode): Unit = {
        var current = node
        while (current != null) {
            print(s"${current.x} ")
            current = current.next
        }
        println()
    }

    val list1 = new ListNode(1, new ListNode(2, new ListNode(4)))
    val list2 = new ListNode(1, new ListNode(3, new ListNode(4)))

    val mergedList = Solution.mergeTwoLists(list1, list2)
    printList(mergedList)
}
