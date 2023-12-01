List sumPerLine = []
new File("puzzle-input.txt").eachLine { line ->
  List digits = []
  char[] c_array = line.toCharArray()
  c_array.each { c ->
    if (Character.isDigit(c)){
      digits.add(c)
    }
  }
  println("First digit is ${digits[0]} and last digit is ${digits[-1]} in line: ${line}")
  def sum = "${digits[0]}${digits[-1]}"
  println("Sum is ${sum}")
  sum = Integer.parseInt(sum)
  sumPerLine.add(sum)
}
println(sumPerLine)
println(sumPerLine.size())
def finalSum = 0
sumPerLine.each{
  finalSum += it
}
// def finalSum = sumPerLine.sum()
println(finalSum)