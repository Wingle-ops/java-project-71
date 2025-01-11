.PHONY:
	build

build:
	gradle clean
	gradle installDist
	$(MAKE) check
run-dist:
	./build/install/app/bin/app file1.json file2.json
check:
	gradle checkstyleMain
	gradle checkstyleTest

