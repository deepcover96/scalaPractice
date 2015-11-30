package Employment

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/*
 * Created by Wilfredo Ruiz on 11/19/15.
 * wil.ruiz@gmail.com
 * (602)-721-2985
 */

/**
  * Singleton object for managing employees.
  */
object EmployeeManager {
  private val employees: mutable.ListBuffer[Employee] = ListBuffer()
  private var idIndex = 0

  /**
    * Sorts all employees in buffer
    * Uses Quick Sort Algorithm which averages O(n * log n) time
    */
  def sortByFirstName(): Unit = {
    def swap(f: Int, b: Int) = {
      val temp: Employee = employees(f)
      employees(f) = employees(b)
      employees(b) = temp
    }

    /**
      * Partition in two, which means move items that is <= pivot to left of partition,
      * and items >= to pivot to the right of partition
      * @param start This partition's start index
      * @param end This partition's end index
      * @return The index of the partition (last element of left partition)
      */
    def partition(start: Int, end: Int): Int = {
      val pivot = employees(end).getFullName
      var f = start
      var b = end
      while (true) {
        while (f <= end && employees(f).getFullName < pivot) {
          f += 1
        }
        while (b >= start && employees(b).getFullName > pivot) {
          b -= 1
        }
        if (f > b) {
          return b
        } else {
          swap(f, b)
          f += 1
          b -= 1
        }
      }

      -1
    }

    /**
      * Partition array in two parts and recursively sort each partition
      * return when partition is one character wide
      * @param start This partition's start index
      * @param end This partition's end index
      */
    def sort(start: Int, end: Int): Unit = {
      if (start >= end) return
      val part = partition(start, end)
      sort(start, part)
      sort(part + 1, end)
    }

    sort(0, employees.length - 1)
  }

  /**
    * Increments counter, ensuring a unique id for each employee
    * @return unique badge number
    */
  private def makeBadge(): Int = {
    idIndex += 1
    idIndex
  }

  /**
    * Gets the total count of employees
    * @return number of employees
    */
  def employeeCount(): Int = {
    employees.length
  }

  /**
    * Add a single person to list of employees
    * @param firstName First name of employee to add to workforce
    * @param lastName Last name of employee to add to workforce
    */
  def addEmployee(firstName: String, lastName: String): Unit = {
    val badgeNumber = makeBadge()
    employees += new Employee(firstName, lastName, badgeNumber)
  }

  /**
    * Prints the list of employees
    */
  def printEmployees(): Unit = {
    for (e <- employees) {
      println(e.getFullName)
    }
  }

  /**
    * Gets a copy of employee list
    * @return Immutable List of employees
    */
  def getCopyOfEmployees: List[Employee] = {
    employees.toList
  }
}

