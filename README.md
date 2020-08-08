# String Calculator 
Given a string formatted like `//[delimiter]\n[delimiter separated numbers]` or `[delimiter separated numbers]`,
the string calculator adds all the numbers together.

All features and bonus features is implemented.

## How to Run
`INPUT="1,2,3,4" make run`

Passes `"1,2,3,4"` to the calculator and returns `10` which is the sum.

> Since we are passing in command-line arguments, escape characters are treated differently on the command-line compared
> to Java. For example '\n' is treated as a single escape character in Java, whereas, `\\n` is the command-line equivalent.


## Cleanup 

`make clean`

Removes all the compiled Java classes


> Tested and ran on Ubuntu 18.04 LTS
