#!/bin/sh
DIR="$(cd "$(dirname "$0")" && pwd)"
java -jar "$DIR/.mvn/wrapper/maven-wrapper.jar" "$@"
