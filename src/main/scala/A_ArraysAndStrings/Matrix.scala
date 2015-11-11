package A_ArraysAndStrings

/*
 * Created by Administrator on 8/9/15.
 */
object Matrix {
  /**
   * Prints an N*M matrix
   * @param matrix 2D array to print
   */
  def printMatrix(matrix:Array[Array[Int]]): Unit = {
    val maxX = matrix.length - 1
    val maxY = matrix(0).length - 1

    for(y <- 0 to maxY) {
      for(x <- 0 to maxX) {
        print(matrix(x)(y))
      }
      println()
    }
    println()
  }

  /**
   * Fill the matrix with incremental values along the y axis
   * @param matrix 2D matrix to populate
   * @param valStart Starting value
   */
  def populateMatrix(matrix:Array[Array[Int]], valStart:Int = 0): Unit = {
    val maxX = matrix.length - 1
    val maxY = matrix(0).length - 1
    for(y <- 0 to maxY) {
      for(x <- 0 to maxX) {
        matrix(x)(y) = y + valStart
      }
    }
  }
}
