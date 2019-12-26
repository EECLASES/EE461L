cd homework2
cd jpf-core
touch temp.gradle
printf "apply plugin: 'jacoco'\n" >> temp.gradle
cat build.gradle >> temp.gradle
printf "jacocoTestReport {\n\treports {\n\t\txml.enabled false\n\t\tcsv.enabled false\n\t\thtml.destination file(\"\${buildDir}/jacocoHtml\")\n\t}\n}" >>temp.gradle
mv temp.gradle build.gradle
./gradlew build
./gradlew jacocoTestReport
cd build
cp -r jacocoHtml ../../../
cd ../../../jacocoHtml
mv index.html test-coverage.html
