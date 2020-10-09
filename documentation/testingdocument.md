# Testing

Testing has been done with JUnit testing library, and tests can be ran from terminal with command 
`gradle test`. Checkstyle is also ran from terminal, with command `gradle check`. Test status can also
be seen from the CircleCI status badge in the repository in GitHub and coverage is right next to it
as CodeCov badge.

# Performance testing

Performance testing can be found from the GUI starting menu under the performance testing button. 
Testing starts when user pushes "Start" -button. In the test all three ciphering methods will encrypt
and decrypt messages that are 1000, 5000 and 10 000 words long. Word in this case is "Test!". Running
performance test will take some time, so sit back and relax for couple of minutes. Progress of the tests
can be observed from the console, as this application is not too reactive. When round 3 is done, it means
that the tests are completed. Resulting times are visible in the GUI, in their respective places.


