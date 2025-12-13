#!/bin/bash
javac -d out src/model/*.java src/utils/*.java src/service/*.java src/Main.java && java -cp out Main
