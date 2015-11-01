package A_ArraysAndStrings

import scala.collection.mutable


/**
 * Rejected solutions that worked, but were not ideal
 */
object Deprecated {


  /**
   * 1.1 Second Attempt, I used a Map to help
   * max O: n
   */
  def containsAllUniqueCharactersLinearSearch(str: String): Boolean = {
    val arr: Array[Char] = str.toLowerCase.toCharArray

    for (c <- arr) {
      var counter: Int = 0
      for (x <- arr) {
        // found twice in string, we fail
        if (c == x) counter += 1
        if(counter > 1) return false
      }
    }

    true
  }

  /**
   * 1.1 First Attempt, I used a Map to help
   * max O: n
   */
  def containsAllUniqueCharactersUsingMap(str: String): Boolean = {
    val arr: Array[Char] = str.toLowerCase.toCharArray
    val map: mutable.Map[Char, Char] = mutable.Map()

    for (c <- arr) {
      if (map.contains(c))
        return false
      else
        map += (c -> c)
    }

    true
  }


  /**
   * 1.4 First try
   * Depricated, I cou;d have done this with two passes, this one is inefficient
   * Replace spaces in string with %20
   * Using an array of characters, do this in-place.
   * (Assume there is sufficient space a the end of the array.)
   * @param str String with spaces
   * @return string with spaces encoded to %20
   */
  def encodeSpaces(str: String): String = {

    // setup
    def createInitialArray(str: String): mutable.ArrayBuffer[Char] = {
      val additionalSpace = str.length * 2 + 1
      val front: Array[Char] = str.toCharArray
      val back: Array[Char] = new Array[Char](additionalSpace) //enough room for all spaces
      val arr: mutable.ArrayBuffer[Char] = mutable.ArrayBuffer[Char]()
      arr ++= front
      arr ++= back
    }

    val arr: mutable.ArrayBuffer[Char] = createInitialArray(str)
    var tail: Int = str.length - 1
    val end: Int = tail

    // move everything after space over 2 places, then encode space
    def encodeSpace(loc: Int): Unit = {
      for (j <- tail to loc by -1) {
        arr(j + 2) = arr(j)
      }
      arr(loc) = '%'
      arr(loc + 1) = '2'
      arr(loc + 2) = '0'
      tail += 2
    }

    for (i <- end to 0 by -1) {
      if (arr(i) == ' ') {
        encodeSpace(i)
      }
    }

    val result: mutable.StringBuilder = new mutable.StringBuilder(arr.mkString)
    result.setLength(tail + 1)
    result.toString()
  }

  /**
   * 1.5a first attempt
   * Compress a string using basic compression (cccaaa = c3a3)
   * @param str the string to compress
   * @return the compressed string or the original string if the compression yielded no advantage
   */
  def basicCompression(str: String): String = {
    val map: mutable.Map[Char, Int] = mutable.Map[Char,Int]()
    val list: mutable.ListBuffer[Char] = mutable.ListBuffer[Char]()

    def combineElements(): String = {
      val compressed: mutable.StringBuilder = new mutable.StringBuilder()
      for(c <- list) {
        compressed.append(c)
        compressed.append(map(c))
      }
      compressed.toString()
    }

    for(c <- str) {
      if(map.contains(c)) {
        map(c) += 1
      } else {
        map += (c -> 1)
        list += c
      }
    }

    if(list.length >= str.length/2) {
      str
    } else {
      combineElements()
    }
  }

  /**
   * 1.6a First try, not in-place.  I used a copy.
   * Pass in a 2D NxN array representing a bitmap image and rotate the image 90 degrees.
   * Do this in-place
   * @param matrix the 2D array to be rotated
   * @return the array with the data manipulated to be rotated 90 degrees.
   */
  def rotateImage(matrix:Array[Array[Int]]):Array[Array[Int]] = {
    val bitmap = Array.ofDim[Int](5,5)

    val maxX = matrix(0).length - 1
    val maxY = matrix.length - 1

    if(maxX != maxY) return matrix
    if(maxX < 2) return matrix

    var indexX = maxX

    for(y <- 0 to maxY) {
      var indexY = 0
      for(x <- 0 to maxX) {
        bitmap(indexX)(indexY) = matrix(x)(y)
        indexY += 1
      }
      indexX -= 1
    }

    bitmap
  }



  /**
   * 1.7a We iterate through the array and track rows and columns and then come back
   * When given an NxM matrix, if a 0 is present as a value, zeroize the entire row
   * and column that the value exists in.
   * @param matrix the 2D array to perform the zeroize operations on
   */
  def zeroize1(matrix:Array[Array[Int]]): Unit = {
    if(matrix.isEmpty) return
    val colMap:mutable.Map[Int,Int] = mutable.Map[Int, Int]()
    val rowMap:mutable.Map[Int,Int] = mutable.Map[Int, Int]()

    var col = 0
    var row = 0

    // O: n*m
    for(x <- matrix) {
      for(y <- x) {
        if(y == 0) {
          colMap(col) = col
          rowMap(row) = row
        }
        row += 1
      }
      col += 1
      row = 0
    }

    // O: p*M (p = number of zeros found)
    for(x <- colMap.keys) {
      for(y <- matrix(0).indices) {
        matrix(x)(y) = 0
      }
    }

    // O: p*N
    for(y <- rowMap.keys) {
      for(x <- matrix.indices) {
        matrix(x)(y) = 0
      }
    }
  }

  /**
   * 1.8a Returns whether the second string is a substring of the first. Rotations count
   * @param s1 original word: (ex: waterlogged)
   * @param s2 potential substring/rotation of s1 (ex: terloggedwa would be correct)
   * @return true if s2 is a substring of s1, including rotation
   */
  def isSubstring(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) return false

    def matchFirstLetter(c: Char, str: String, i: Int): Int = {
      if(i >= s1.length) return s1.length
      if (str.charAt(i) == c) {
        i
      } else {
        matchFirstLetter(c, str, i + 1)
      }
    }

    def compareStrings(start: Int): Boolean = {
      var s2Index = start
      val maxIndex = s1.length - 1

      for(i <- 0 to maxIndex) {
        if(s1.charAt(i) != s2.charAt(s2Index)) return false
        s2Index += 1
        if(s2Index > maxIndex) {
          s2Index = 0
        }
      }
      true
    }

    val startChar = s1.charAt(0)
    var startIndex = matchFirstLetter(startChar, s2, 0)
    while (startIndex < s1.length) {
      if(compareStrings(startIndex)) {
        return true
      } else {
        startIndex = matchFirstLetter(startChar, s2, startIndex + 1)
      }
    }

    false
  }
}
