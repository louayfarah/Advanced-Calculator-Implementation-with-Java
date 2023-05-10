# Advanced-Calculator-Implementation-with-Java

Welcome to the Advanced Calculator Implementation project. This Java program accepts one of three words: **DOUBLE, INTEGER, STRING**. Then, it accepts an integer **N**, the total number of commands. Finally, **N commands** are inputted. Each command should be performed as follows:

. The **"+"** command means the calculator should either sum up two numbers or concatenate two strings, and print the result to the output.

. The **"−"** command means the calculator should either subtract two numbers and print the result to the output, or print "Unsupported operation for strings".

. The **"∗"** command means calculator should either multiply two numbers and print the result to the screen, or for strings, it should repeat the first argument amount of times given in the second argument (a positive integer number), otherwise print "Wrong argument type".

. The **"/"** command means the calculator should either divide two numbers and print the result to the output or print "Unsupported operation for strings".

Any operation for DOUBLE or INTEGER calculators that will contain inapplicable symbols as operands, should print **"Wrong argument type"** and continue work with the next operation.

For any other inapplicable operation, the message **"Wrong operation type"** should be printed to the output.

In case of wrong calculator type on the first line, the output should contain only **"Wrong calculator type"**. In case when the specified number of commands is incorrect, the output should contain only **"Amount of commands is Not a Number"** and exit from the program.

In case when the calculator tries to divide by zero, the output should contain only **"Division by zero"** and continue work with the next operation.


The UML class diagram below demonstrates the set of classes which were implemented:
![image](https://github.com/louayfarah/Advanced-Calculator-Implementation-with-Java/assets/86551620/b7d868a8-cca6-410e-873d-19936264b945)
