package Util


object Search {
  def binarySearch(arr: List[Int], num: Int): Option[Int] = {
    if (arr.isEmpty) return None

    var start: Int = 0
    var end: Int = arr.length - 1

    // begin search from center
    var pivot: Int = arr.length / 2

    while (start <= end) {
      val n = arr(pivot)
      if (n == num) {
        return Some(pivot)
      } else if (num < n) {
        end = pivot - 1
        pivot = end / 2
      } else {
        start = pivot + 1
        pivot = start + (end - pivot) / 2
      }
    }
    None
  }


  def binarySearchRecursive(arr: List[Int], num: Int): Option[Int] = {
    if (arr.isEmpty) return None

    def findMatch(start: Int, end: Int, pivot: Int): Option[Int] = {
      if (start > end) return None
      val n = arr(pivot)

      if (n == num) {
        Some(pivot)
      } else if (num < n) {
        findMatch(start, pivot - 1, end / 2)
      } else {
        findMatch(pivot + 1, end, start + (end - pivot) / 2)
      }
    }

    findMatch(0, arr.length - 1, arr.length / 2)
  }
}
