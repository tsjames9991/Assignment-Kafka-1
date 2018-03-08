import org.apache.log4j.Logger

package object serde {
  val ROLLNUMBER = 50
  val student: Student = Student(ROLLNUMBER, "Sudeep James Tirkey")
  val TIMEOUT = 5000
  val Log = Logger.getLogger(this.getClass)

  case class Student(id: Int, name: String) {
    override def toString: String = {
      s"$id : $name"
    }
  }
}
