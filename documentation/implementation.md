# Implementation

### Complexities

#### Letters to numbers

##### Encrypting

`
// encryption method
cast given message to char array charMessage
create empty string cryptedMessage
for each char in charMessage
  cryptedMessage += if number is found, then getNumber(char) + "*", else char
return cryptedMessage

// getNumber helper
for each pair object in pair list
  if pair's char value equals given char
    return pair's number value
  else return '-1'
`

This leads to a complexity of `O(n*m)`, where `n` is the lenght of the message and `m` is the size of
the alpabets used. Worst case scenarios happen when `m>n`, where time complexity compared to `n` can rise
quite large. But reality this is not so complex as it sounds, as alpabets used aren't too large. In this
program's case `m=78`, so complexity will boil down to `O(n*m), n>m` and `O(n^k), n<=m, k>=2, n^k<=m`

##### Decrypting

`
// decryption method
create empty string decryptedMessage
split encrypted message when '*' is encountered
for each number string in the splitted message
  decryptedMessage+= if character is found, then getChar(number), else return number
    if error is encountered (something can't be parsed to number), break loop and return error message
return decryptedMessage

// getChar helper
for each pair object in pair list
  if pair's number value equals given number
    return pair's letter value
  else return '§'
`
Complexity on this is the same as calculated above.

#### Knapsack Cryptosystem

##### Encrypting

`

`

### GUI

User interface is graphical and created with java swing library. UI then proceeds to call core methods
to complete the desired actions.

### Input / Output

Input and output are both provided trough UI, and currently input is given via keyboard by the user.
Output is provided to the lower text field as encrypted or decrypted result for the given input.

### Logic

Programs functionality is based in the logic folder, which has the three ciphering methods inside it
along with the helper classes. 

### Class dependency flow

![Structure](https://github.com/ArttuJanhunen/cipherer/blob/master/documentation/pictures/structure.png "Project layout")

### Flaws and improvements

* Program could use fresh key values each time instead of pre-created ones
* Program could read files, as was inteded if there is enough time
* Some special marks aren't supported

### Sources

* [Cipher tools](http://rumkin.com/tools/cipher/index.php)
* [Knapsack source 1](https://en.wikipedia.org/wiki/Merkle%E2%80%93Hellman_knapsack_cryptosystem)
* [Knapsack source 2](https://www.geeksforgeeks.org/knapsack-encryption-algorithm-in-cryptography/)
* [RSA source 1](https://en.wikipedia.org/wiki/RSA_(cryptosystem))
* [RSA source 2](https://www.geeksforgeeks.org/rsa-algorithm-cryptography/)
