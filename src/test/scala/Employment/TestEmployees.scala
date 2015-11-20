package Employment

import org.scalatest.FlatSpec

/*
 * Created by Wilfredo Ruiz on 11/19/15.
 * wil.ruiz@gmail.com
 * (602)-721-2985
 */

class TestEmployees extends FlatSpec {
  "Singleton class" should "Sort collection of Employee objects using employee's first name." in {
    assert(EmployeeManager.employeeCount() == 0)

    // edge case with no records
    EmployeeManager.sortByFirstName()
    assert(EmployeeManager.employeeCount() == 0)

    // edge case with 1 record
    EmployeeManager.addEmployee("Jefferson", "Pierce")
    EmployeeManager.sortByFirstName()
    assert(EmployeeManager.employeeCount() == 1)

    // Populate with the rest of employees.  We also have some people with the same first and last names.
    EmployeeManager.addEmployee("Steve", "Austin")
    EmployeeManager.addEmployee("Barda", "Free")
    EmployeeManager.addEmployee("Steven", "Rogers")
    EmployeeManager.addEmployee("John", "Smith")
    EmployeeManager.addEmployee("Billy", "Batson")
    EmployeeManager.addEmployee("Selina", "Kyle")
    EmployeeManager.addEmployee("Piotr", "Rasputin")
    EmployeeManager.addEmployee("John", "Smith")
    EmployeeManager.addEmployee("Scott", "Summers")
    EmployeeManager.addEmployee("Barbara", "Gordon")
    EmployeeManager.addEmployee("Sean", "Cassidy")
    EmployeeManager.addEmployee("John", "Smith")
    EmployeeManager.addEmployee("John", "Ruiz")

    assert(EmployeeManager.employeeCount() == 14)

    // Sort
    EmployeeManager.sortByFirstName()

    val employees: List[Employee] = EmployeeManager.getCopyOfEmployees

    // Verify Order Using Name
    for(i <- 0 to employees.length - 2) {
      assert(employees(i).getFullName < employees(i+1).getFullName)
      assert(employees(i).getFirstName <= employees(i+1).getFirstName)
    }


    EmployeeManager.printEmployees()
    // Results in ...
    //    Barbara Gordon (0000011)
    //    Barda Free (0000003)
    //    Billy Batson (0000006)
    //    Jefferson Pierce (0000001)
    //    John Ruiz (0000014)
    //    John Smith (0000005)
    //    John Smith (0000009)
    //    John Smith (0000013)
    //    Piotr Rasputin (0000008)
    //    Scott Summers (0000010)
    //    Sean Cassidy (0000012)
    //    Selina Kyle (0000007)
    //    Steve Austin (0000002)
    //    Steven Rogers (0000004)
  }
}
