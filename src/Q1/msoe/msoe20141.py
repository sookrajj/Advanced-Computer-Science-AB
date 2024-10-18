def doublelets():
  str = Input(print("Enter a word"))
  num = 0
  for lcv in range(0, len(str)-1):
    if str[lcv] == str[lcv+1]:
      num += 1

  print("The number of double letters in: ", str, " is ", str(num))


def main():
  doublelets()

if __name__ == "__main__"
  main()
  
