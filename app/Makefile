.PHONY: build

setup:
	./app/gradlew -p ./app/ install

clean:
	./app/gradlew -p ./app/ clean

build:
	./gradlew build

run:
	./app/gradlew -p ./app/ run

test:
	./app/gradlew -p ./app/ test

lint:
	./app/gradlew -p ./app/ checkstyleMain

report:
	./app/gradlew -p ./app/ jacocoTestReport

install:
	./app/gradlew -p ./app/ install