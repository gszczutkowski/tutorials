# Allure integration



Project ilustrates how to integrate end-to-end tests writtent in java with [Allure Test Report](http://allure.qatools.ru/)  tool.


### Working with report

Running tests with regular maven command to create the test results.

```sh
$ mvn clean test
```

Generating Allure report. Report will be saved to: target/site/allure-maven/index.html

```sh
$ mvn allure:report
```
Generating report into temp folder. Web server with results will start.

```sh
$ mvn allure:serve
```

