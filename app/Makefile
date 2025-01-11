.PHONY:
	build

build:
	./gradlew clean
	./gradlew installDist
run-dist:
	./build/install/app/bin/app file1.json file2.json
check:
	gradle checkstyleMain
	gradle checkstyleTest

