# Cipherer, desktop application for ciphering messages.

[![codecov](https://codecov.io/gh/ArttuJanhunen/cipherer/branch/master/graph/badge.svg)](https://codecov.io/gh/ArttuJanhunen/cipherer)
[![CircleCI](https://circleci.com/gh/ArttuJanhunen/cipherer.svg?style=svg)](https://circleci.com/gh/ArttuJanhunen/cipherer)

This application is created for University of Helsinki Data Structure Lab course.
Idea of this application is to provide means for encrypting and decrypting messages and possibly .txt files.

### Shortcuts

[Project specification](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/projectspesification.md)

[Implementation](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/implementationdocument.md)

[Testing](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/testingdocument.md)

#### Week reports

* [Week 1](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/weeklyreports/week1.md)
* [Week 2](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/weeklyreports/week2.md)
* [Week 3](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/weeklyreports/week3.md)
* [Week 4](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/weeklyreports/week4.md)
### Project at this point

Project can be run from terminal with command `gradle run` in project folder and it has a user interface. It has two ciphering algorithms
and it supports letters and some special characters. If you don't use "'" with letters to numbers you can write normal letters
which you can encrypt and decrypt. You can try it for example with a sentence like "This message will
be encrypted and decrypted successfully.". With knapsack cryptosystem all characters should be supported. 
RSA ciphering is also available. Program will also tell you the time it took to perform encryption or
decryption for the message. 
