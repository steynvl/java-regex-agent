#!/bin/bash

# remove old class files and create jar
mvn clean && mvn package

# rename and move jar to lib directory
mv target/java-regex-agent-1.0-SNAPSHOT.jar lib/regex-instrument.jar

printf "\n-----------\n"
printf "JAR file generated and moved to lib/regex-instrument.jar.\n"
