# Test project: Selenide + Allure + JUnit4 + Maven
This is a test project. The goal is to cover search results by test cases:
+ Testing website - yandex.ru
+ Enter word "selenide" in search query, press "Enter"
+ Receive search results
+ Testing the output for correct information
__________________________________________________________________________________________________________________________________________________________________________________
## Used instruments 
+ Java 11
+ Selenide 5.23.1
+ Maven 3.8.1
+ JUnit4
+ Allure 2.13.8
__________________________________________________________________________________________________________________________________________________________________________________
## Description
Project contains test suite, which can be launched in chosen browser by Maven command -Dselenide.browser=chrome for example. It's run locally and also could be run in CI (e.g. Jenkins) with the following Maven commands:
```
mvn clean test -Dtest=TestSuiteYandexSearch -Dselenide.browser=chrome
mvn clean test -Dtest=TestSuiteYandexSearch -Dselenide.browser=firefox
mvn clean test -Dtest=TestSuiteYandexSearch -Dselenide.browser=opera

```
In local Jenkins job Allure reports was set up as post build step:
```
mvn allure:serve
```
