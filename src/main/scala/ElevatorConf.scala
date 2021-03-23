case class ElevatorConf(currentFloor: Int, targetFloors: List[Int]) {
  def ifUp: Boolean = ifMoving && currentFloor < targetFloors.head
  def ifMoving: Boolean = targetFloors.nonEmpty
  def ifDown: Boolean = ifMoving && currentFloor > targetFloors.head
}
