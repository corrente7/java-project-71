### Hexlet tests and linter status:
[![Actions Status](https://github.com/corrente7/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/corrente7/java-project-71/actions)
<a href="https://codeclimate.com/github/corrente7/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/b01f5688189f75e47de2/maintainability" /></a>
<a href="https://codeclimate.com/github/corrente7/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/b01f5688189f75e47de2/test_coverage" /></a>
[![.github/workflows/main.yml](https://github.com/corrente7/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/corrente7/java-project-71/actions/workflows/main.yml)
# Name: # 
JSON and YAML compare tool

# Description and usage: # 
Student project in Hexlet school. 
Compares two JSON files and two YAML files.
Outputs the differences between files in 3 formats: stylish, plain, json. Default format is "stylish".

# Usage: # 
./build/install/app/bin/app -f json filepath1.json filepath2.json
./build/install/app/bin/app filepath1.yml filepath2.yml
./build/install/app/bin/app -f plain filepath1.json filepath2.json
