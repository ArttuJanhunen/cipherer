# Project specification

### Degrees and languages

* Bachelor's degree in computer science
* Language for this project is english
* Programming language for this project is Java

### Problem to solve

Basically this isn't a problem that is being solved, but the idea for this project is to create a way
to encrypt and decrypt messages. Idea is that you can play around with it or that you can send emails
or messages that can be then decrypted in the other end. Also if this project gets to the point where
it reads from a file, it can be used to create text files that have a little more privacy. 

### Data structures

Structures in this project will be tables and two-dimensional matrixes, as ciphering is done on 
character level.

### Algorithms

Algorithms in use will be my own implementations for different ciphering styles, for example:
* [Columnar transposition](http://rumkin.com/tools/cipher/coltrans.php)
* [Letter numbers](http://rumkin.com/tools/cipher/numbers.php)
* [One time pad](http://rumkin.com/tools/cipher/otp.php)

### Program inputs

Program will receive its input from user through a text field and then produce encryption on decryption
from that input. Another possibility would be to read from .txt files and produce wanted output from
there. That said, this program aims to be a desktop application. 

### Expected time complexities

* Columnar transposition: O(n^2)
* Letter numbers: O(n)
* One time pad: O(n)


### Sources

[Cipher tools](http://rumkin.com/tools/cipher/index.php)

