.PHONY:
	build

build:
	gradle clean
	gradle installDist
	gradle checkstyleMain
	gradle checkstyleTest

run-dist:
	./build/install/app/bin/app file1.json file2.json

report:
	./app/gradlew -p ./app/ jacocoTestReport
