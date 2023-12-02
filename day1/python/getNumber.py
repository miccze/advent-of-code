f = open("../puzzle-input.txt", "r")
lines = f.readlines()

dict = {}
for line in lines:
  line = line.replace("\n", "")
  print(line)
  for character in line:
    if character.isdigit():
      print()
      index=line.find(character)
      dict[index] = character
  print(dict)
