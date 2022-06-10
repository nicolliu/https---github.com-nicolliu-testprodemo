# https---github.com-nicolliu-testprodemo

Main method consists 2 options :
1. Convert human number to roman number
2. Convert galaxy number to human number

********************************************************************************************************************************************

A. Convert human number to roman number algorithm

1. The number parameter enters a static method of integertoRomanConverter
2. The number then will be divided by 1000, 100, 10, one digit
3. If after divide process resulted more or equals (1.00 of double value), then it will enter if statements.
4. Divided by 1000 : only returns how many "M" printed;
5. Divided by 100 : enter if statements for value equals 9, 5, 4, and less
6. Divided by 10 : enter if statements for value equal 9, 5, 4, and less
7. The rest will also enter if statements for value equal 9, 5, 4, and less.
9. The results of those division are concatenated and resulted roman number.

********************************************************************************************************************************************

B. Convert galaxy number to human number

1. The galaxy number parameter enters a static method of galaxytoIntegerConverter
2. The number then will be changed into lowered case , then be splitted by space (" ") and be trimmed (in case if there is accidental extra space);
3. The string array then will enter for loop for further checking.
4. If the string equals gold, silver, or iron, then it will set a temporary value (tempvalue) as the value of each.

Gold : 14,450.0 
Silver : 17.0
Iron : 195.5

5. The other will enter a value converter for glob, pish, tegj, etc, if at least one of them is invalid, then it will exit the method and return "I have no idea what you are talking about"
6. For valid entries, it will be converted directly into number value as the roman number it represents, and be collected in a new array string.
7. The new array string now consists all number value of each array;
8. Enter a new for loop and declare a new temporary value of double.
9. For each loop, the system will compare between the value of new array string current index and the next index.
10. If the current index value is equal or bigger than the next index value, then add current index value to temporary double value, else it will directly count 2 index values at once (currentvalue + (nextindex - currentindex)) and added another increment for loop 
11. If the next index already hit out of bounds, it will enter catch and add current index value to the temporary double value.
12. if the tempvalue double for gold, silver, iron is exist ( more than default 1), it will concat a "Credit" string at the back of result
13. The rest are returning the value to the main and print the result on syso.
