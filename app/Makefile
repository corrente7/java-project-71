.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

run:
	gradle run

test:
	gradle test

report:
	gradle jacocoTestReport

lint:
	gradle checkstyleMain

build-run: build run

.PHONY: build