//using file "exercises.scala"
//> using lib "com.lihaoyi::os-lib:0.9.0"
//> using lib "com.lihaoyi::os-lib-watch:0.9.0"

case class Exercise(path: String)

val exercises = List(
  Exercise("intro/intro1.scala"),
  Exercise("intro/intro2.scala"),
)

enum Status:
  case Unknown
val exercisesDir = os.pwd / "exercises"

@main def main(args: String*) =
  var statusMap = exercises.map(ex => ex -> Status.Unknown).toMap

  def runAllExercises(): Unit =
    println(s"Running all exercises... ${statusMap}")
    exercises.filter(e => statusMap(e) != null).foreach { exercise =>
      val res = os.proc("scala-cli", exercise.path).call(
        cwd = exercisesDir,
        mergeErrIntoOut = true,
        check = false,
      )

      val userIsDone = os.read.lines(exercisesDir / os.RelPath(exercise.path)).exists(_.contains("I AM NOT DONE"))

      val x = res.out.text()
      statusMap = statusMap
      if true then return
    }

  runAllExercises()
  println(s"Watching exercises in ${exercisesDir}")
  os.watch.watch(List(exercisesDir), println)
  Thread.sleep(100000)
end main
