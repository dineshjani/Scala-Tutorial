
case class PointObj(c: Double, point: Array[Int])

object Solution {
    def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
       val pq = scala.collection.mutable.PriorityQueue.empty[PointObj](Ordering.by(_.c))        
        
        points.foreach { point =>
            val a = Math.pow(point.head, 2)
            val b = Math.pow(point.last, 2)
            val c = Math.sqrt(a + b)
            
            pq.enqueue(PointObj(c, point))
            if (pq.length > k) pq.dequeue
        }
        
        pq.dequeueAll.map(_.point).toArray
    }
}