# Instructions

When running the program from .jar-file or from from the project folder with `gradle run` program starts.
After starting the program you can either choose to go to the ciphering or the the performance tests.

### Performance tests

Click on "Performance testing" button to enter testing menu. After that you can either start the tests
or exit back to start menu. If you click "Start" you will start the tests, and you can monitor the progress
from console. Tests have three rounds, so after round 3 is done, it will soon print the results to the
GUI for you to see. Clicking "Exit" will take you back to start menu.

### Ciphering

Click on "Start" in the start menu. After that you will see two text areas and some buttons. Initially
ciphering is set on encrypting with letters to numbers method. You can always look what action is currently
in use by reading text above the first text area.

Program works so that you write text to the upper area and click "Convert message" to get the results.
So to encrypt message you will have to write text to upper text area and click "Convert message". 
Result will appear on the bottom text area, and they can be copied by clicking "Copy" button. If you want
to decrypt the encrypted message, you will have to click on "Decrypt" button and paste the ciphered message
to the upper text area. Respectfully, "Encrypt" button will set the method back to encrypting.

"Change method" button will change the method you are using, and the method at hand will be also visible
above the upper text area. 

### Note

* When clicking "Encrypt", "Decrypt" or "Change method" button text areas will be cleared.
* Crypted message will only be decrypted by using the same method as it was encrypted with. 
* This application uses certain hard coded keys, so it should not be used if something is REALLY supposed
to be kept as a secret
