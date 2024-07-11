./mvnw build-helper:parse-version versions:set \
-DnewVersion=\${parsedVersion.nextMajorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion}
./mvnw clean package
version=$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)
echo "sha before"
shasum target/spring-boot-$version.jar
jar -uf target/spring-boot-$version.jar appd
echo "sha after"
shasum target/spring-boot-$version.jar
#zip -r java-sample-app-$version.zip target/spring-boot-$version.jar appd
