**以下代码基于jdk1.8，jdk1.7源码没这么多层封装，所以更易于理解，但核心实现都是formatUnsignedInt()**
-------
先来看一组方法：
```
  toHexString(int):String
  toOctalString(int):String
  toBinaryString(int):String
  ```

它们的内部实现如下：
```java
 public static String toHexString(int i) {
     return toUnsignedString0(i, 4);
 }
public static String toOctalString(int i) {
    return toUnsignedString0(i, 3);
}
public static String toBinaryString(int i) {
     return toUnsignedString0(i, 1);
}
```
你应该发现了吧！它们的实现细节都在`toUnsignedString0(int,int)`里面。
所以我们来看下`toUnsignedString0(int,int)`内部代码：
```java
private static String toUnsignedString0(int val, int shift) {
        // assert shift > 0 && shift <=5 : "Illegal shift value";
       //计算这个int转换成二进制后占多少bit（123-->>7)
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
        //用于确定最后生成的字符串有几个字符
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];
        //具体解析出每个字符是什么
        formatUnsignedInt(val, shift, buf, 0, chars);

        // Use special constructor which takes over "buf".
        return new String(buf, true);
}
```
为了讲解内部代码，我们通过Debug模式具体分析一个例子：
举例：**Integer.numberOfLeadingZeros(123);**

1. 首先会执行第一句`int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);`<br>
那么`Integer.numberOfLeadingZeros(val)`会返回什么呢？<br>
看Debug图：

![图1.png](/img/1.JPG)
numberOfLeadingZeros(123)返回的是25。为什么是25呢？<br>
因为123的二进制是 `0000 0000 0000 0000 0000 0000 0111 1011`。  
**数一数前面有多少个0?**<br>
所以numberOfLeadingZeros(val)的作用是 **返回二进制首部开始0的个数**

2. 所以 `int mag = 32-25=7`。
第二行`int chars = Math.max(((mag + (shift - 1)) / shift), 1);`等于
`int chars = Math.max((7+3)/4,1)=2`

3. 继续看 **formatUnsignedInt()** 内部：
(这个方法是核心，用心理解)
```
static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;//2^shift (此例子是2^4)
        int mask = radix - 1; //(16进制-->>15  8进制-->>7)
        do {
            //val&mask  相当于  val%(mask+1)  这里是 123%16
            buf[offset + --charPos] = Integer.digits[val & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }
```
进入此函数后，mask=15(二进制：0111 1111)。
```
第一次do...while
buf[1] = Integer.digits[123&15]  //'b'98
123>>>4 //此时val =7
....省略第二次

最后的 char[] buf = ['7','b']
```
所以最后toHexString 的结果就是 123--->>> 7b
