Steps to reproduce the bug:

1. Clone this repo and cd inside
2. `scala-cli clean; scala-cli watch.scala`
3. Change the file `exercises/wef` and save it. The process you ran in step (2) will not notice the change.
4. Now go to `watch.scala` and comment out line 28, `val userIsDone = ...`, and run the command in step (2).
5. Change the file `exercises/wef` and save it. The process you ran in step (4) now will notice the change and output the path to the file to the terminal.