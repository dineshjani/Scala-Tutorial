object VersionComparator {

  def compareVersions(version1: String, version2: String): Int = {
    val splitVersion1 = version1.split("\\.").map(_.toInt).toList
    val splitVersion2 = version2.split("\\.").map(_.toInt).toList

    def compare(v1: List[Int], v2: List[Int]): Int = (v1, v2) match {
      case (Nil, Nil) => 0
      case (Nil, y) => if (y.exists(_ !=0)) -1 else -0
      case (x, Nil) => if (x.exists(_ != 0)) 1 else 0
      case (x :: xs, y :: ys) =>
        if (x < y) -1
        else if (x > y) 1
        else compare(xs, ys)
    }

    compare(splitVersion1, splitVersion2)
  }

  def main(args: Array[String]): Unit = {
    val version1 = "1.2.3.0.0"
    val version2 = "1.2.3"
    val result = compareVersions(version1, version2)

    result match {
      case 1 => println(s"$version1 is greater than $version2")
      case -1 => println(s"$version1 is less than $version2")
      case 0 => println(s"$version1 is equal to $version2")
    }
  }
}
