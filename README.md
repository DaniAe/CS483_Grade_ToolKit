# CS483 Assignment 3A - Grade ToolKit

Authors: Jonathan Dargakis & Andrew Dominguez

## Description
This code is a grade toolkit with 6 different methods for calculating different kinds of grades that you might need during your academic career.

## Usage
1. compile the GradeToolkit.java file
    - Warning! this might reveal one of the bugs, so make sure to fix this before continuing!
2. run the GradeToolkit class


```
Javac GradeToolkit.java
java GradeToolkit
```
  
## Examples
```
jmdargakis@harry:~/SFtesting$ javac GradeToolkit.java
jmdargakis@harry:~/SFtesting$ java GradeToolkit
Welcome to your school toolkit!
 Please select an option:
 1. Calculate GPA
 2. Pass or Fail
 3. Grade to Letter
 4. Calculate Weighted Grade
 5. Calculate QPA
 6. Calculate Final's Grade Needed
------------------------------
Enter option: 3
Enter numeric grade (out of 100): 78
C
```

---

```
jmdargakis@harry:~/SFtesting$ java GradeToolkit
Welcome to your school toolkit!
 Please select an option:
 1. Calculate GPA
 2. Pass or Fail
 3. Grade to Letter
 4. Calculate Weighted Grade
 5. Calculate QPA
 6. Calculate Final's Grade Needed
------------------------------
Enter option: 5
Enter number of classes taken:
4
Enter grade for class 1: (A-F)
Grade entered is invalid. Reenter: (A-F)
A
Enter credits for class 1:
4
Enter grade for class 2: (A-F)
Grade entered is invalid. Reenter: (A-F)
B
Enter credits for class 2:
5
Enter grade for class 3: (A-F)
Grade entered is invalid. Reenter: (A-F)
C
Enter credits for class 3:
3
Enter grade for class 4: (A-F)
Grade entered is invalid. Reenter: (A-F)
C
Enter credits for class 4:
4
Your QPA is: 0.0
Your total credits are: 16
```