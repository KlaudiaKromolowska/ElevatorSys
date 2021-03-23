case class ElevatorSysConf(numberOfElevators: Int = 16) extends ElevatorSys {
  val elevators: List[Elevator] =
    (0 until 16).toList.map(n => Elevator(n))

  override def pickup(targetFloor: Int, direction: Int): Unit = {
    val correctElev = elevators.minBy(_.pickUpCost(targetFloor, direction))
    correctElev.move(targetFloor)
  }
  override def update(id: Int, currentFloor: Int, targetFloor: Int): Unit = {
    for (i <- 0 until 16) {
      if (i == id) elevators(i).update(currentFloor, targetFloor)
    }
  }
  override def step(): Unit = {
    elevators.foreach(_.makeStep())
    elevators.foreach(_.sortTargetFloors())
  }
  override def status(): List[(Int, Int, List[Int])] = {
    elevators.map(_.elevStatus)
  }

}
