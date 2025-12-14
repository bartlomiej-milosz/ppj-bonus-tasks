#!/bin/bash
javac -d out src/models/*.java src/utils/*.java src/service/*.java src/Main.java && java -cp out Main
