# Decimal-Binary-Hex-Converter
![Converter](https://user-images.githubusercontent.com/70422090/169673542-72d1823c-9b30-42ba-884e-1b5b5f02a2f5.jpg)


<h2>Project Description</h2>
<p>This <b>Java</b> based GUI converter takes in a user inputted value and converts it to the other two equivalent values. I decided to do this
project to understand the logic behind the various converters I utilized in my undergraduate studies. During an error filled input, the screens will lock out and 
force the user to press the clear button to restart operations. Additionally, after a successful attempt the screen will also lock out to maintain the 
integrity of the values that need to be referenced. <b>HTML</b> was utilized for the formatting of the error messages. Below are the methods that were used and their descriptions</p>

<h2>toDecimal</h2>
<p>This method takes in a <b>String</b> binary number and converts it into the proper decimal equivalent. A <b>for-loop</b> is used to read the binary
number from right to left and utlizies the <b>Math.pow(base,exponent)</b> functionality of the <b>Math</b> class to properly calculate the equivalent decimal number.
The result is then set in the Decimal text box.</p>

<h2>tohexaDecimal</h2>
<p>This method takes in a <b>String</b> binary number and converts it into the proper hexadecimal equivalent. A <b>while-loop</b> and the method <b>???</b> are repeatedely used to convert the last four bits of the binary number into hexadecimal. Each iteration of the <b>while-loop</b> the converted bits are placed into a <b>Stack</b> and the binary string is shortened by the last 4 bits. Once this process is complete, the binary string is checked to see if there are less than 4 bits remaining. If so, the remaining bits are padded with 0's to ensure that the method <b>???</b> can properly convert it and is ultimately placed in the <b>Stack</b>. The <b>Stack</b> is then repeatedely popped into an empty <b>String</b>. The result is set in the HexaDecimal text box.</p>
