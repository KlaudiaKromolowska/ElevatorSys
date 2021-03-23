import java.util.Scanner

import scala.util.control.Breaks._

object Main extends App {
  val system = ElevatorSysConf()
  val scan: Scanner = new Scanner(System.in)
  var whatToDo: Int = 0
  println(
    "Show me what you want to do! \n 1 - Call the elevator \n 2 - Show status of elevators \n 3 - Update elevator status \n 4 - Make simulation step \n 5 - End program"
  )
  startSystem()

  def startSystem(): Unit = {
    breakable(while (true) {
      whatToDo = scan.nextInt()
      whatToDo match {
        case 1 => makePickUp()
        case 2 =>
          println("This is status of your elevator system: ")
          println(system.status())
        case 3 => updateOfSystem()
        case 4 =>
          println("Step has been made, your elevators have been moved!")
          system.step()
        case 5 => break
        case _ =>
          println("Could you repeat that again?")
          startSystem()

      }
      println(
        "Do you want to do something more before the step? If the answer is 'yes' type 1, 2 or 3."
      )
    })
    println("Thank you for using this Elevator System :)")
  }

  def makePickUp(): Unit = {
    println("What floor are you standing at?")
    val floor = scan.nextInt()
    println(
      "Do you want to go UP or DOWN? If UP: write '1', if DOWN: write '-1'"
    )
    var direct = scan.nextInt()
    while (direct != 1 && direct != -1) {
      println("That is not the right direction! Type the direction again.")
      direct = scan.nextInt()
    }
    system.pickup(floor, direct)
    println(
      "You called elevator on the " + floor + " floor. The direction is: " + direct + ". "
    )
  }

  def updateOfSystem(): Unit = {
    println("Which one elevator would you like to update?")
    val numOfElev = scan.nextInt()
    if (numOfElev > 16 || numOfElev < 0) {
      println("You do not have that elevator!")
      updateOfSystem()
    }
    println("Which floor should it be on?")
    val floor = scan.nextInt()
    println("Which floor should be target?")
    val targetFloor = scan.nextInt()
    system.update(numOfElev, floor, targetFloor)
    println(
      "You have updated elevator nr: " + numOfElev + ". It is on floor number " + floor + " now and is going to " + targetFloor + " floor."
    )
  }

}
