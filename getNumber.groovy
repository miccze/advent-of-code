List sumPerLine = []
new File("puzzle-input.txt").eachLine { line ->
  List digits = []
  Map letterDigits = [:]
  char[] c_array = line.toCharArray()
  c_array.each { c ->
    if (Character.isDigit(c)){
      digits.add(c)
    }
  }
  if(line.contains('one')) {
    def index = line.indexOf('one')
    letterDigits[index] = "1"
    def result = index != line.LastIndexOf("tyt") && index != -1; // do it with regexp
  }  
  if(line.contains('two')) {
    def index = line.indexOf('two')
    letterDigits[index] = "2"
  }
  if(line.contains('three')) {
    def index = line.indexOf('three')
    letterDigits[index] = "3"
  }
  if(line.contains('four')) {
    def index = line.indexOf('four')
    letterDigits[index] = "4"
  }
  if(line.contains('five')) {
    def index = line.indexOf('five')
    letterDigits[index] = "5"
  }
  if(line.contains('six')) {
    def index = line.indexOf('six')
    letterDigits[index] = "6"
  }
  if(line.contains('seven')) {
    def index = line.indexOf('seven')
    letterDigits[index] = "7"
  }
  if(line.contains('eight')) {
    def index = line.indexOf('eight')
    letterDigits[index] = "8"
  }
  if(line.contains('nine')) {
    def index = line.indexOf('nine')
    letterDigits[index] = "9"
  }
  if(line.contains('zero')) {
    letterDigits[indexOf('zero', 0)] = "0"
  }
  println(letterDigits)
  Map sorted = letterDigits.sort { a,b -> a.key <=> b.key }
  println(sorted)
  List sortedLetterDigits = sorted.values().toArray()
  println("${sortedLetterDigits} and size ${sortedLetterDigits.size()}")

  println("First digit is ${digits[0]} and last digit is ${digits[-1]} in line: ${line}")
  def sum = "${digits[0]}${digits[-1]}"
  def letterSum = "00"
  if (sortedLetterDigits.size() != 0) {
    println("First letterDigit is ${sortedLetterDigits[0]} and last digit is ${sortedLetterDigits[-1]} in line: ${line}")
    letterSum = "${sortedLetterDigits[0]}${sortedLetterDigits[-1]}"
  }
  println("Sum is ${sum} and ${letterSum}")
  sum = Integer.parseInt(sum)
  letterSum = Integer.parseInt(letterSum)
  sumPerLine.add(sum)
  sumPerLine.add(letterSum)
}
println(sumPerLine)
println(sumPerLine.size())
def finalSum = 0
sumPerLine.each{
  finalSum += it
}
// def finalSum = sumPerLine.sum()
println(finalSum)