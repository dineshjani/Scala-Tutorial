object Add {
  // Define a function to add two integers
  def functoadd(a: Int, b: Int): Int = {
    return a + b
  }

  // Main method where execution starts
  def main(args: Array[String]): Unit = {
    // Use string interpolation to print the result
    println(s"sum of given two numbers: ${functoadd(4, 5)}")
  }
}
