.PHONY: build run-dist report

build:
    ./gradlew clean
    ./gradlew installDist
    ./gradlew checkstyleMain
    ./gradlew checkstyleTest

run-dist:
        ./build/install/app/bin/app file1.json file2.json

report:
        ./gradlew jacocoTestReport

