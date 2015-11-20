package Employment

/*
 * Created by Wilfredo Ruiz on 11/19/15.
 * wil.ruiz@gmail.com
 * (602)-721-2985
 */

/**
  * Simple person class
  * @param firstName Employee first name class parameter
  * @param lastName Employee last name class parameter
  * @param badgeNumber Unique badge number
  */
class Employee(firstName: String, lastName: String, badgeNumber: Int) {
  private val fullName: String = firstName + " " + lastName + " (" + "%07d".format(badgeNumber) + ")"

  def getFullName: String = {
    fullName
  }
  def getFirstName: String = {
    firstName
  }
  def getLstName: String = {
    lastName
  }
}
