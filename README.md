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
./build/install/app/bin/app
![Скриншот 2023-05-31 19 00 03](https://github.com/corrente7/java-project-71/assets/68503914/4311efcd-8ad6-48ae-8508-e2da06324fbd)

./build/install/app/bin/app filepath1.yml filepath2.yml
![Скриншот 2023-05-31 18 58 08](https://github.com/corrente7/java-project-71/assets/68503914/c6b29951-fc10-493f-bd42-8bcb150db583)

./build/install/app/bin/app -f json filepath1.json filepath2.json
![Скриншот 2023-05-31 18 57 42](https://github.com/corrente7/java-project-71/assets/68503914/e424e99f-3296-4b76-899d-b578bab52135)

./build/install/app/bin/app -f plain filepath1.json filepath2.json
![Скриншот 2023-05-31 18 59 22](https://github.com/corrente7/java-project-71/assets/68503914/8a0af0f3-865f-496c-a0ef-7891a480e65b)
