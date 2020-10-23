# Implementation

### Complexities

#### Letters to numbers

##### Encrypting

```
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
```

This leads to a complexity of `O(n*m)`, where `n` is the lenght of the message and `m` is the size of
the alpabets used. Worst case scenarios happen when `m>n`, where time complexity compared to `n` can rise
quite large. But reality this is not so complex as it sounds, as alpabets used aren't too large. In this
program's case `m=78`, so complexity will boil down to `O(n*m), n>m` and `O(n^k), n<=m, k>=2, n^k<=m`

##### Decrypting

```
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
```
Complexity on this is the same as calculated above.

#### Knapsack Cryptosystem

##### Encrypting

```
convert string message to chararray charMessage
convert charMessage to charBinary form (opened below: convertToBinary() )
convert each binary form letter to int and place to intMessage[]
convert intMessage[] to slicedMessage[][] (opened below: slice())
divide charBinary with 8 to calculate letter count
for each letter in message
  add encrypted value of letter as string to the message (opened below: sliceToString())
return message

// convertToBinary

for each char in message
  convert to binary string
  if binary length < 8
    add zeros to beginning
  add binary form char to a string
convert resulted string to chararray
return chararray

// slice 

initiate public key from private key => int[8]
int numberSlot = 0
int tableSlot = 0
int tableAmount = amount of letters
int[][] result = int[tableAmount][8]

for i=0, i< message length, i++
  if numberSlot >=8
    numberSlot = 0
    tableSlot++
  result[tableSlot][numberSlot] = message[i] * publicKey[i]
  numberSlot++
return result

// sliceToString

int total = 0
for each number value in letter
  total+=value
return total as string

```

This results as a complexity of `O(n+8n+8n+8n)=O(25n)` where n is the lenght of the message. 

##### Decrypting

```
String[] messageSlots = String[messages number values]
intSlots[] = int[messageSlots length]
for each number in messageSlots
  parse to int and insert to intSlots[]

for each number in intSlots[]
  inverse number public key calculation
  decryptedMessage+= string value of inversed number (Opened below: decryptSlot())

convert decryptedMessage to readable form (Opened below: convertToString())

return decrypted message

// decryptSlot

int helper = inversed number
String decrypted = "";
boolean[] indexes = new boolean[privateKey.length]

for i = privateKey.length - 1, i >= 0, i--
  if helper >= privateKey[i]
    indexes[i] = true
    helper -= privateKey[i]
   else 
    indexes[i] = false
for i = 0, i < indexes.length, i++
  if indexes[i]
    decrypted += "" + 1
  else
    decrypted += "" + 0
return decrypted

// convertToString

converted = ""
int helper = 0
binaryForm = ""
  for i = 0, i <= message.length, i++
    if i == message.length)
      converted += char value from the binary converted to normal number
      break
     if helper >= 8
       helper = 0
       converted += char value from the binary converted to normal number
       binaryForm = ""
     binaryForm += message.charAt(i);
     helper++
return converted
```

This leads to time complexity of `O(16n+8n+n) = O(25n)`

#### RSA

##### Encrypting

```
convert message to chararray charMessage
convert charMessage to int[] intMessage with twoCharsToInt (explained below)

for each int in intMessage 
  convert int to bigInteger toEncrypt
  bigInteger modPow = toEncrypt^e % n
  long encryptedLong = modPow
  encryptedMessage += encryptedLong +" "

return encryptedMessage

// twoCharsToInt

int[] intMessage = new int[]

if charMessage length % 2 == 0
  intMessage length = charMessage / 2
else
  intMessage length = charMessage / 2 + 1

int charAmount = 0
int helper = 0
combineChar = ""

for int i = 0, i < charMessage length, i++
  convert charMessage[i] to int charValue 
  charToCorrectLength = charValue + ""
  while charToCorrectLength length < 3
    charToCorrectLength = "0" + charToCorrectLength
  combineChar += charToCorrectLength
  charAmount++
  if charAmount >= 2 or i == charMessage length -1
    intMessage[helper] = combineChar parsed to integer
    helper++
    charAmount = 0
    combineChar = ""

return intMessage
```

This will lead to a time complexity of `O(4n)` in the worst case. 

##### Decrypting

```
String[] messageSplit = split encrypted message with each " "
String[] decryptedSplit = String[messageSplit length]

for int i=0, i< messageSplit length, i++
  BigInt split = new BigInt(messageSplit[i])
  BigInt modPow = split^privatekey%publickey
  decrypted = modPow
  decryptedSplit[i] += decrypted + ""

for int i=0, i<decryptedSplit length, i++
  decrypted += asciiToLetter(decryptedSplit[i])

return decrypted

// asciiToLetter

letters = ""

if message length <= 3
  letter += (char) message
else
  while message length < 6
    message = "0" + message
  letters += (char) message substring(0,3)
  letters += (char) message substring(3)

return letters

```

This leads to time complexity of `O(4n)` in the worst case.

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
