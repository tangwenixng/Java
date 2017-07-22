### toUnsignedLong
```java
/**
* 如果x>=0,返回x
* 如果x<0,返回 (2^32-x)
*/
public static long toUnsignedLong(int x) {
    return ((long) x) & 0xffffffffL;
}
```

### toUnsignedString
```java
/**
* 如果x>=0,返回x
* 如果x<0,返回 (2^32-x)
*/
public static String toUnsignedString(int i) {
    return Long.toString(toUnsignedLong(i));
}
```

### parseInt
```java
public static int parseInt(String s, int radix)
                throws NumberFormatException
{
    if (s == null) {
        throw new NumberFormatException("null");
    }
    //当进制radix<2
    if (radix < Character.MIN_RADIX) {
        throw new NumberFormatException("radix " + radix +
                                        " less than Character.MIN_RADIX");
    }
    //当进制radix>36
    if (radix > Character.MAX_RADIX) {
        throw new NumberFormatException("radix " + radix +
                                        " greater than Character.MAX_RADIX");
    }

    int result = 0;//这是最后要返回的结果
    boolean negative = false;//符号标志
    int i = 0, len = s.length();//len--输入字符串s的长度
    int limit = -Integer.MAX_VALUE; //  -(2^31-1)
    int multmin;
    int digit;

    if (len > 0) {
        char firstChar = s.charAt(0);//字符串的第一个字符，用于判断是不是负数
        if (firstChar < '0') { // Possible leading "+" or "-"   '0' == 48
            if (firstChar == '-') {  //字符 '-' ==  45
                negative = true;
                limit = Integer.MIN_VALUE; //如果是负数，那么 limit =  -2^31
            } else if (firstChar != '+') // '+' == 43
                throw NumberFormatException.forInputString(s);
               //如果输入的字符串是 '+'  或者 '-'
            if (len == 1) // Cannot have lone "+" or "-"
                throw NumberFormatException.forInputString(s);
            i++;//待会循环时，就会跳过符号位，从数字开始。
        }
        multmin = limit / radix;//这里为什么这么处理？很难懂
        //下面这个循环是核心，但是超级难懂，以后有机会再回来看吧~~~~~~~~~~
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            digit = Character.digit(s.charAt(i++),radix); //把字符转换成 int值
            if (digit < 0) {
                throw NumberFormatException.forInputString(s);
            }
            if (result < multmin) {
                throw NumberFormatException.forInputString(s);
            }
            result *= radix;
            if (result < limit + digit) {
                throw NumberFormatException.forInputString(s);
            }
            result -= digit;
        }
    } else {
        throw NumberFormatException.forInputString(s);
    }
    return negative ? result : -result;
}
```

### valueOf
```java
//调用的还是上面的parseInt
public static Integer valueOf(String s, int radix) throws NumberFormatException {
    return Integer.valueOf(parseInt(s,radix));
}
```
