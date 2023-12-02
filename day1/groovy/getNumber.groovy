

List sumPerLine = []

new File("../puzzle-input.txt").eachLine { line ->
  def sum = main(line)
  sumPerLine.add(sum)
}
println(sumPerLine)
println(sumPerLine.size())
def finalSum = sumPerLine.sum()
println(finalSum)


def main(String line) {
  Map wordsAndValues = [
    'one':'1',
    'two':'2',
    'three':'3',
    'four':'4',
    'five':'5',
    'six':'6',
    'seven':'7',
    'eight':'8',
    'nine':'9'
  ]

  Map indexesOfNumbers = [:]
  wordsAndValues.each { word, value -> 
    Map indexesOfWordNumbers = [:]
    indexesOfWordNumbers = checkIfWordIsInsideLine(line, word, value)
    if (!indexesOfWordNumbers.isEmpty() ) {
      indexesOfNumbers << indexesOfWordNumbers
    }
    Map digitIndexes = [:]
    digitIndexes = checkIfWordIsInsideLine(line, value)
    if (!digitIndexes.isEmpty()) {
      indexesOfNumbers << digitIndexes
    }
  }
  Map sorted = indexesOfNumbers.sort { a,b -> a.key <=> b.key }
  // println("${indexesOfNumbers} and sorted ${sorted}")
  List sortedIndexesOfNumbers = sorted.values().toArray()
  // println("${sortedindexesOfNumbers} and size ${sortedindexesOfNumbers.size()}")

  println("First digit is ${sortedIndexesOfNumbers[0]} and last digit is ${sortedIndexesOfNumbers[-1]} in line: ${line}")
  def sum = "${sortedIndexesOfNumbers[0]}${sortedIndexesOfNumbers[-1]}"
  println("Sum is ${sum}")
  sum = Integer.parseInt(sum)
}

def checkIfWordIsInsideLine(String line, String word, String value=null) {
  def countedValue = value==null ? word : value
  Map map = [:]
  def matcher = (line =~ /$word/)
  if (matcher.find()) {
    def index = line.indexOf(word)
    map[index] = countedValue
    if (matcher.count > 1) {
      def index2 = line.lastIndexOf(word)
      map[index2] = countedValue
    }
  }
  return map
}


assert main("two5two3334two") == 22
assert main("1two5three4") == 14
assert main("onetwo3") == 13
assert main("1twothree") == 13
assert main("5") == 55
assert main("5l") == 55
assert main("one") == 11
assert main("two555two5") == 25

assert main("two1nine") == 29
assert main("eightwothree") == 83
assert main("abcone2threexyz") == 13
assert main("xtwone3four") == 24
assert main("4nineeightseven2") == 42
assert main("zoneight234") == 14
assert main("7pqrstsixteen") == 76

List testValues = [29, 83, 13, 24, 42, 14, 76]
assert testValues.sum() == 281