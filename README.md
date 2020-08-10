# String Calculator 
Given a string formatted like `//[delimiter]\n[delimiter separated numbers]` or `[delimiter separated numbers]`,
the string calculator adds all the numbers together.

All features and bonus features is implemented.

## How to Run

1. In the root directory `7shifts/`, run
    
    ```shell script
    $ make compile
   ```
 Which compiles the java files to the class files
 
 2. `cd src`
 
 3. Run
 ```shell script
$ java Main "1,2,3"
```

Which sends the arguement "1,2,3" to the String Calculator

> If using the newline character (`\n`) or special characters (`<([{\^-=$!|]})?*+.>`), you will need to escape it first
>
>For example, `java Main "//\?\#\\n1\?\#2\?\#2"` splits on the delimiter `?#`.


## Cleanup 
1. `cd ..`

2. `make clean`

Removes all the compiled Java classes


> Tested and ran on Ubuntu 18.04 LTS
