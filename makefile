compile:
	javac src/*.java

run: compile
	java -classpath src Main "${INPUT}"

clean:
	rm src/*.class