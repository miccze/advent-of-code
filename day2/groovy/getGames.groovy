import java.util.regex.Pattern


maxRedCubes = 12
maxGreenCubes = 13
maxBlueCubes = 14
possibleGames = []
powerOfGames = []
runTests()

new File("../puzzle-input.txt").eachLine { line ->
  determinePossibleGames(line)
}
println(possibleGames)
def sum = possibleGames.sum()
println("final sum is: ${sum}")

def sumOfPowerOfGames = powerOfGames.sum()
println("Sum of powerOfGames is: ${sumOfPowerOfGames}")


void runTests() {
  println("tests")
}

def determinePossibleGames(String line) {
  def (game, gameResults) = line.split(":")
  println("gameId is: ${game} and gameResults are: ${gameResults}")
  def gameID = Integer.parseInt(game.split(" ")[1])
  println(gameID)

  List getSets = gameResults.split(";")
  println(getSets)

  def greens = getCubesInColor(getSets, 'green')
  boolean greenPossible = validateIfPossible(greens, maxGreenCubes)

  def reds = getCubesInColor(getSets, 'red')

  boolean redsPossible = validateIfPossible(reds, maxRedCubes)

  def blues = getCubesInColor(getSets, 'blue')
  boolean bluesPossible = validateIfPossible(blues, maxBlueCubes)

  if (bluesPossible && redsPossible && greenPossible){
    println("${gameID} is in")
    possibleGames.add(gameID)
  }

  //Second star
  def powerOfSetOfCubes =  greens.max() * blues.max() * reds.max()
  powerOfGames.add(powerOfSetOfCubes)
}

def getCubesInColor(List sets, String color) {
  List cubesInColor = []
  def pattern = ~ /^[\s](\d{1,2})[\s]$color$/
  sets.each { set ->
    List cubesInSet = set.split(",")
    cubesInSet.each { cubes -> 
      def matcher = (cubes =~ pattern)
      if (matcher.count > 0) {
        def allColoredCubes = matcher.findAll({pattern})
        def cubeNumber = matcher[0][1]
        cubesInColor.add(Integer.parseInt(cubeNumber))
      }
    }
  }
  println("Cubes in ${color} are: ${cubesInColor}")
  return cubesInColor
}

def validateIfPossible(List cubesNumber, Integer maxNumberOfCubes) {
  def isPossible = cubesNumber.every { cubeNumber ->
    cubeNumber <= maxNumberOfCubes
  }
  return isPossible
}