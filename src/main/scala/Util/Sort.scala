package Util

import scala.collection.mutable

object Sort {
  def quickSort(arr: mutable.ArrayBuffer[Int]): Unit = {

    def swap(f: Int, b: Int) = {
      val temp: Int = arr(f)
      arr(f) = arr(b)
      arr(b) = temp
    }

    def partition(start: Int, end: Int): Int = {
      val pivot = arr(end)
      var f = start
      var b = end

      while(true) {
        while(f <= end && arr(f) < pivot) {
          f += 1
        }
        while(b >= start && arr(b) > pivot) {
          b -= 1
        }
        if(f > b) {
          return b
        } else {
          swap(f, b)
          f += 1
          b -= 1
        }
      }

      -1
    }

    def sort(start: Int, end: Int): Unit = {
      if(start >= end) return
      val part = partition(start, end)
      sort(start, part)
      sort(part + 1, end)
    }

    sort(0, arr.length - 1)

  }


  def quickSort[T](arr: mutable.ArrayBuffer[T], lessThan: (T, T) => Boolean, greaterThan: (T, T) => Boolean): Unit = {

    def swap(f: Int, b: Int) = {
      val temp = arr(f)
      arr(f) = arr(b)
      arr(b) = temp
    }

    def partition(start: Int, end: Int): Int = {
      val pivot = arr(end)
      var f = start
      var b = end
      while(true) {
        while(f <= end && lessThan(arr(f), pivot)) {
          f += 1
        }
        while(b >= start && greaterThan(arr(b), pivot)) {
          b -= 1
        }
        if(f > b) {
          return b
        } else {
          swap(f, b)
          f += 1
          b -= 1
        }
      }

      -1
    }

    def sort(start: Int, end: Int): Unit = {
      if(start >= end) return
      val part = partition(start, end)
      sort(start, part)
      sort(part + 1, end)
    }

    sort(0, arr.length - 1)

  }
}
