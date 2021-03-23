import java.util.Scanner

case class Elevator(n: Int) {

  var state: ElevatorConf = ElevatorConf(0, List.empty)

  def sortTargetFloors(): Unit = {
    if (currentDirection == -1) {
      state = state.copy(
        targetFloors = state.targetFloors
          .filter(_ < state.currentFloor)
          .sortWith(_ > _) ::: state.targetFloors
          .filter(_ > state.currentFloor)
          .sorted
      )
    } else {
      state = state.copy(
        targetFloors = state.targetFloors
          .filter(_ > state.currentFloor)
          .sorted ::: state.targetFloors
          .filter(_ < state.currentFloor)
          .sortWith(_ > _)
      )
    }
  }

  def makeStep(): Unit = {
    if (state.ifUp) state = state.copy(currentFloor = state.currentFloor + 1)
    if (state.ifDown) state = state.copy(currentFloor = state.currentFloor - 1)

    if (state.targetFloors.nonEmpty && state.currentFloor == state.targetFloors.head) {
      state = state.copy(
        targetFloors =
          state.targetFloors.filterNot(f => f == state.currentFloor)
      )
      println(
        "You have just entered the elevator number: " + n + ". What floor do you want to go?"
      )
      addFloor()
    }
  }

  def addFloor(): Unit = {
    val scan: Scanner = new Scanner(System.in)
    var floor: Int = 0
    floor = scan.nextInt()
    if (currentDirection == 0 || (currentDirection == 1 && floor > state.currentFloor) || (currentDirection == -1 && floor < state.currentFloor)) {
      move(floor)
    } else {
      println("You wanted to go up! Change target floor!")
      addFloor()
    }
    println(
      "Does anyone want to choose another floor? If 'yes' type 'yes' and add target floor number in next line, otherwise type anything else"
    )
    val anyoneMore = scan.next()
    if (anyoneMore == "yes") addFloor()
  }

  def elevStatus: (Int, Int, List[Int]) =
    (n, state.currentFloor, state.targetFloors)

  def update(currentFloor: Int, targetFloor: Int): Unit =
    state = ElevatorConf(currentFloor, List(targetFloor))

  def pickUpCost(targetFloor: Int, direction: Int): Int = {
    if (state.targetFloors.isEmpty) {
      math.abs(targetFloor - state.currentFloor)
    } else {
      if (currentDirection == direction) {
        if (targetFloor < state.targetFloors.last)
          1
        else
          math.abs(targetFloor - state.targetFloors.last)
      } else {
        math.abs(targetFloor - state.currentFloor) + math.abs(
          state.targetFloors.last - targetFloor
        )
      }

    }
  }

  def currentDirection: Int =
    if (state.ifUp) 1 else if (state.ifDown) -1 else 0

  def move(targetFloor: Int): Unit =
    state = state.copy(targetFloors = state.targetFloors :+ targetFloor)

}
