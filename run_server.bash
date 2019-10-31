#!/usr/bin/env bash

rm ./*.class

javac -classpath ".:sqlite-jdbc-3.27.2.1.jar" ./*.java

java -classpath ".:sqlite-jdbc-3.27.2.1.jar" Main
