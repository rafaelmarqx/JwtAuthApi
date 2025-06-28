@echo off
set MAVEN_OPTS=%MAVEN_OPTS% -Djansi.force=true
set DIR=%~dp0
set MVNW_REPOURL=https://repo.maven.apache.org/maven2
set WRAPPER_JAR=.mvn\wrapper\maven-wrapper.jar
java -jar "%DIR%%WRAPPER_JAR%" %*
