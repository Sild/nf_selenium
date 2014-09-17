rm src/*.class
javac -cp libs/selenium-server-standalone-2.39.0.jar:./src src/*.java &&
java -cp libs/selenium-server-standalone-2.39.0.jar:./src Main

