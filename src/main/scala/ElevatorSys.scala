trait ElevatorSys {
  def pickup(floor: Int, direction: Int)
  def update(id: Int, currentFloor: Int, targetFloor: Int)
  def step()
  def status(): List[(Int, Int, List[Int])]
}
