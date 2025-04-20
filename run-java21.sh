#!/bin/bash
export JAVA_HOME="/Users/mac/Library/Java/JavaVirtualMachines/ms-21.0.6/Contents/Home"
$JAVA_HOME/bin/java -version
./mvnw "$@"
