# PropellerAds test project: Selenide + Allure + JUnit4
This is a test project for PropellerAds interview. The goal is to cover search results by test cases:
+ Testing website - yandex.ru
+ Enter word "propellerads" in search query, press "Enter"
+ Receive search results
+ Testing the output for correct information
__________________________________________________________________________________________________________________________________________________________________________________
## Used instruments 
+ Java 11
+ Selenide 5.18.1
+ Maven 3.8.1
+ JUnit4
+ Allure 2.13.8
__________________________________________________________________________________________________________________________________________________________________________________
## Description
Project consists of test suits for Chrome, Firefox and Opera. It's run locally and also could be run in CI (e.g. Jenkins) with the following Maven commands:
'''java
mvn clean test -Dtest=ChromeTestSuite
mvn clean test -Dtest=FirefoxTestSuite
mvn clean test -Dtest=OperaTestSuite
'''
In local Jenkins job Allure reports was set up as post build step
