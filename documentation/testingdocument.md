# Testing

Testing has been done with JUnit testing library, and tests can be ran from terminal with command 
`gradle test`. Checkstyle is also ran from terminal, with command `gradle check`. Test status can also
be seen from the CircleCI status badge in the repository in GitHub and coverage is right next to it
as CodeCov badge.

# Performance testing

Performance testing at this point is a bit vague to the author (read: me), but solution at this point
is that when something is encrypted or decrypted the application will show how long the action took.
In a way I see that that is quite neat way, as you can tell quite quickly with bigger inputs that what
is the cost for the action done. 
