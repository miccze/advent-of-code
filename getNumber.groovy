

List sumPerLine = []
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
new File("puzzle-input.txt").eachLine { line ->
  List digits = []
  Map letterDigits = [:]
  char[] c_array = line.toCharArray()
  c_array.each { c ->
    if (Character.isDigit(c)){
      def index = line.indexOf(c.toString())
      letterDigits[index] = c
    }
  }
  wordsAndValues.each { word, value -> 
    Map indexes = [:]
    indexes = checkIfWordIsInsideLine(line, word, value)
    if (!indexes.isEmpty() ) {
      letterDigits << indexes
    }
  }

  Map sorted = letterDigits.sort { a,b -> a.key <=> b.key }
  println("${letterDigits} and sorted ${sorted}")
  List sortedLetterDigits = sorted.values().toArray()
  println("${sortedLetterDigits} and size ${sortedLetterDigits.size()}")

  println("First digit is ${sortedLetterDigits[0]} and last digit is ${sortedLetterDigits[-1]} in line: ${line}")
  def sum = "${sortedLetterDigits[0]}${sortedLetterDigits[-1]}"
  println("Sum is ${sum}")
  sum = Integer.parseInt(sum)
  sumPerLine.add(sum)
}
println(sumPerLine)
println(sumPerLine.size())
// def finalSum = 0
// sumPerLine.each{
//   finalSum += it
// }
def finalSum = sumPerLine.sum()
println(finalSum)


def checkIfWordIsInsideLine(String line, String word, String value) {
  Map map = [:]
  def matcher = (line =~ /$word/)
  if (matcher.find()) {
    def index = line.indexOf(word)
    map[index] = value
    if (matcher.count > 1) {
      def index2 = line.lastIndexOf(word)
      map[index2] = value
    }
  }
  return map
}

