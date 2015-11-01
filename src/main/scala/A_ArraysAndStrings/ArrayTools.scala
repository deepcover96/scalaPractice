package A_ArraysAndStrings

import scala.collection.mutable

object ArrayTools {

  /**
   * 1.1
   * Implement an algorithm to determine if a string has all unique characters.
   * Do this without additional data structures.
   * Lets assume all ASCII characters
   * Max O:  n
   * @param str string to check if all characters are unique
   * @return true if all characters are unique, false otherwise
   */
  def containsAllUniqueCharacters(str: String): Boolean = {
    val arr: Array[Char] = str.toCharArray

    // Larger than ASCII table, automatic fail
    if(arr.length > 256) return false

    // Fill array of size 256 with zeros
    val charStore: Array[Int] = Array.fill[Int](256)(0)

    for (c <- arr) {
      val asciiValue: Int = c.toInt
      if(charStore(asciiValue) > 0)
        return false
      else
        charStore(asciiValue) = 1
    }

    true
  }

  /**
   * 1.1a
   * Implement an algorithm to determine if a string has all unique characters.
   * Do this without additional data structures.
   * If our character set is limited to under 64-bit, we can use a single variable to represent the bitmap
   * Lets assume lower-case characters from a-z.  We can then use an Int (32-bit)
   * This solution will use bit manipulation which will save space
   * Max O:  n
   * @param str string to check if all characters are unique
   * @return true if all characters are unique, false otherwise
   */
  def containsAllUniqueCharactersBitwise(str: String): Boolean = {
    val arr: Array[Char] = str.toLowerCase.toCharArray

    //since we are assuming a-z, we know the max characters
    if (arr.length > 26) return false

    // Bit map of 32, we only need 26
    var charMap: Int = 0

    for (c <- arr) {
      // bit moved to the nth place, to make 'a' start at the 1st place, subtract 97
      val newMap: Int = 1 << (c.toInt - 97)

      // AND them to ensure uniqueness
      if((charMap & newMap) > 0)
        return false
      else
        charMap = charMap | newMap // OR them to add to the map
    }

    true
  }


  /**
   * 1.2
   * Reverses a null-terminated string
   * Do this without creating a new structure
   * Max O: n/2
   * @param arr the string to reverse
   * @return the passed in string reversed
   */
  def reverseString(arr: mutable.ArrayBuffer[Char]): String = {
    var front: Int = 0
    var back : Int = arr.length - 2 // last char not including null

    for (i <- 0 to back/2) {
      val temp: Char = arr(front)

      arr(front) = arr(back)
      arr(back) = temp
      front += 1
      back -= 1
    }

    arr.mkString("").dropRight(1)  // we'll drop the last character to make the test pass
  }

  /**
   * 1.3
   * Given two strings, returns true if the strings are permutations of one another
   * Max O: 2n
   * @param str1 string one
   * @param str2 string two
   * @return true if permutation, false otherwise
   */
  def isPermutation(str1: String, str2: String): Boolean = {

    def updateMap(c: Char, map: mutable.Map[Char, Int]): Unit = {
      if (map.contains(c))
        map(c) = map(c) + 1
      else
        map += (c -> 1)
    }

    if (str1.length != str2.length) return false

    val map1: mutable.Map[Char, Int] = mutable.Map()
    val map2: mutable.Map[Char, Int] = mutable.Map()

    val arr1: Array[Char] = str1.toCharArray
    val arr2: Array[Char] = str2.toCharArray

    for (i <- 0 to str1.length - 1) {
      updateMap(arr1(i), map1)
      updateMap(arr2(i), map2)
    }

    for (i <- 0 to str1.length - 1) {
      val c: Char = arr1(i)

      if (map1.contains(c) && map2.contains(c)) {
        if (map1(c) != map2(c)) return false
      } else {
        return false
      }
    }

    // if we made it here, they are permutations of one another
    true
  }

  /**
   * 1.4
   * Replace spaces in string with %20
   * Using an array of characters, do this in-place.
   * (Assume there is sufficient space a the end of the array.)
   * O: 2n
   * @param str String with spaces
   * @return string with spaces encoded to %20
   */
  def encodeSpaces(str: String): String = {

    // setup
    def createInitialArray(str: String, spaces: Int): mutable.ArrayBuffer[Char] = {
      val additionalSpace = spaces * 2
      val front: Array[Char] = str.toCharArray
      val back: Array[Char] = new Array[Char](additionalSpace) //enough room for all spaces
      val arr: mutable.ArrayBuffer[Char] = mutable.ArrayBuffer[Char]()
      arr ++= front
      arr ++= back
    }

    var spaces: Int = 0
    val end: Int = str.length - 1

    for (i <- 0 to end) {
      if (str(i) == ' ') spaces += 1
    }

    val arr: mutable.ArrayBuffer[Char] = createInitialArray(str, spaces)
    var tail: Int = arr.length - 1

    for (i <- end to 0 by -1) {
      if (arr(i) == ' ') {
        arr(tail) = '0'
        arr(tail - 1) = '2'
        arr(tail - 2) = '%'
        tail -= 3
      } else {
        arr(tail) = arr(i)
        tail -= 1
      }
    }

    arr.mkString
  }

  /**
   * 1.5
   * Compress a string using basic compression (cccaaa = c3a3)
   * @param str the string to compress
   * @return the compressed string or the original string if the compression yielded no advantage
   */
  def basicCompression(str: String): String = {
    if(str == null) return str
    if(str.isEmpty) return str

    val compressed: mutable.StringBuilder = new mutable.StringBuilder()
    var lastChar = str(0)
    var count = 1

    for(i <- 1 to str.length - 1) {
      if (compressed.size >= str.length) {
        return str
      }

      if (str(i) == lastChar) {
        count += 1
      } else {
        compressed.append(lastChar)
        compressed.append(count)
        lastChar = str(i)
        count = 1
      }
    }

    // last character(s) remaining
    compressed.append(lastChar)
    compressed.append(count)

    if (compressed.size >= str.length) {
      str
    }else {
      compressed.toString()
    }
  }

  /**
   * 1.6
   * Pass in a 2D NxN array representing a bitmap image and rotate the image 90 degrees.
   * Do this in-place
   * @param matrix the 2D array to be rotated
   * @return the array with the data manipulated to be rotated 90 degrees.
   */
  def rotateImage(matrix:Array[Array[Int]]): Unit = {

    val maxX = matrix(0).length - 1
    val maxY = matrix.length - 1

    if(maxX != maxY) return
    if(maxX < 2) return

    var start = 0
    var end = maxX

    for(y <- 0 to maxY/2) {
      var i = 0
      for (x <- start to end - 1) {

        // save top
        val temp = matrix(x)(y)

        // top replaced with left
        matrix(x)(y) = matrix(start)(end - i)

        // left replaced with bottom
        matrix(start)(end - i) = matrix(end - i)(end)

        // bottom replaced with right
        matrix(end - i)(end) = matrix(end)(x)

        // right replaced with top
        matrix(end)(x) = temp

        i += 1
      }

      start += 1
      end -= 1
    }
  }



  /**
   * 1.7 (Slightly more efficient as we set the known rows and columns as we go)
   * When given an NxM matrix, if a 0 is present as a value, zeroize the entire row
   * and column that the value exists in.
   * @param matrix the 2D array to perform the zeroize operations on
   */
  def zeroize(matrix:Array[Array[Int]]): Unit = {
    if(matrix.isEmpty) return
    val colMap:mutable.Map[Int,Int] = mutable.Map[Int, Int]()
    val rowMap:mutable.Map[Int,Int] = mutable.Map[Int, Int]()

    var col = 0
    var row = 0

    // O: n*m
    for(x <- matrix) {
      for(y <- x) {
        if(y == 0) {
          // record corresponding row and column so we
          // can go back and addressed the cells that we have passed
          colMap(col) = row
          rowMap(row) = col
        }

        // if we find them along the way, make them zero
        if(colMap.contains(col)) matrix(col)(row) = 0
        if(rowMap.contains(row)) matrix(col)(row) = 0

        row += 1
      }
      col += 1
      row = 0
    }

    // Get values that we have not addressed yet
    // O: p*M (p = number of zeros found)
    for(x <- colMap.keys) {
      for(y <- 0 to colMap(x)) {
        matrix(x)(y) = 0
      }
    }

    // O: p*N
    for(y <- rowMap.keys) {
      for(x <- 0 to rowMap(y)) {
        matrix(x)(y) = 0
      }
    }
  }


  /**
   * 1.8 Returns whether the second string is a substring of the first. Rotations count
   *  Assume the substring method is provided for you.
   * @param s1 original word: (ex: waterlogged)
   * @param s2 potential substring/rotation of s1 (ex: terloggedwa would be correct)
   * @return true if s2 is a substring of s1, including rotation
   */
  def isSubstring(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) return false
    val s1s1 = s1 + s1
    s1s1.contains(s2)
  }
}