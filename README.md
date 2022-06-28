# Decimal-Binary-Hex-Converter
  
![Converter](https://user-images.githubusercontent.com/70422090/169673542-72d1823c-9b30-42ba-884e-1b5b5f02a2f5.jpg)
![error](https://user-images.githubusercontent.com/70422090/170619243-26007040-88d1-4a48-b3a0-6dde113fb944.jpg)
![Success](https://user-images.githubusercontent.com/70422090/170619579-d8fa7988-48e2-494e-8a0e-4dcbfaa93e54.jpg)

<h2>Project Description</h2>
<p>This <b>Java</b> based GUI converter takes in a user inputted value and converts it to the other two equivalent values. I decided to do this
project to understand the logic behind the various converters I utilized in my undergraduate studies. During an error filled input, the screens will lock out and 
force the user to press the clear button to restart operations. Additionally, after a successful attempt the screen will also lock out to maintain the 
integrity of the values that need to be referenced. <b>HTML</b> was utilized for the formatting of the error messages. M.test is a JUnit test that tests the proper functionality of the methods used. Value Converter.JAR is an executable JAR file that can run the GUI from your desktop without the need of opening an IDE. Below are the methods that were used and their descriptions</p>

<h2>toDecimal</h2>
<p>This method takes in a <b>String</b> binary number and converts it into the proper decimal equivalent. A <b>for-loop</b> is used to read the binary
number from right to left and utlizies the <b>Math.pow(base,exponent)</b> functionality of the <b>Math</b> class to properly calculate the equivalent decimal number.The result is then set in the Decimal text box.</p>

<h2>toBinary</h2>
<p>This method takes in a <b>String</b> and an <b>int</b>. The <b>String</b> can be either a <b>Decimal</b> or a <b>HexaDecimal</b> number depending on the <b>int</b> (1 = decimal, 3 = hexadecimal). In the decimal scenerio, the decimal number is repeatedly modded and the remainder is the binary digit and will be structured from right to left. The newly created binary number is then used as an input for the method <b>tohexaDecimal</b>. In the hexadecimal scenerio, the hex number has individual <b>characters</b> converted using the <b>binaryConversion</b> method from right to left. The resulting <b>binary</b> number then has any padded zeros removed from the left side of the <b>binary</b> number. The newly created binary number is then used as an input for the method <b>toDecimal</b>.

<h2>tohexaDecimal</h2>
<p>This method takes in a <b>String</b> binary number and converts it into the proper hexadecimal equivalent. A <b>while-loop</b> and the method <b>hexConversion</b> are repeatedely used to convert the last four bits of the binary number into hexadecimal. Each iteration of the <b>while-loop</b>, the converted bits are placed into a <b>Stack</b> and the binary string is shortened by the last 4 bits. Once this process is complete, the binary string is checked to see if there are less than 4 bits remaining. If so, the remaining bits are padded with 0's to ensure that the method <b>hexConversion</b> can properly convert it and is ultimately placed in the <b>Stack</b>. The <b>Stack</b> is then repeatedely popped into an empty <b>String</b>. The result is set in the HexaDecimal text box.</p>

<h2>binaryConversion</h2>
<p>This method takes in a hex <b>character</b> and converts it into the proper 4 bit binary equivalent. A switch is used to account for all possible scenerios of <b>characters</b>.</p>

<h2>hexConversion</h2>
<p>This method takes in a <b>String</b> 4 bit binary value and convets it into its eqivalent HexaDecimal value. A switch is used to account for all possible scenerios of 4 bit binary inputs.</p>

<h2>errorLock</h2>
<p>This method locks out all text boxes in both failures and sucessful conversions. The only way to unlock the text boxes is through the use of the <b>Clear</b> button.</p>


