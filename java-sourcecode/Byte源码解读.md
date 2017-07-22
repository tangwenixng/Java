
先看**Number**类：
> public abstract class Number implements java.io.Serializable
-------------

它的方法列表如下：
```
intValue:init
longValue:long
floatValue:float
doubleValue:double

byteValue:byte
shortValue:short
```

除了**byteValue()、shortValue()**，其他都是抽象方法。
```java
public byte byteValue() {
    return (byte)intValue();
}
public short shortValue() {
    return (short)intValue();
}
```
--------------------------------------------------

# Byte.java
-----------
好了，接下来看**Byte.java**
> public final class Byte extends Number implements Comparable<Byte>

继承Number 实现Comparable接口


### 构造器：
   **成员变量value （很重要）**
```java
private final byte value;

public Byte(byte value) {
    this.value = value;
}

public Byte(String s) throws NumberFormatException {
    this.value = parseByte(s, 10);
}
```

### parseByte(String s,int radix):byte
  把字符串（仅限数字）解析为字节，但是当字符串s 的值 大于127，或者 小于-128时，会抛异常。
```java
public static byte parseByte(String s, int radix)
    throws NumberFormatException {
    int i = Integer.parseInt(s, radix);
    if (i < MIN_VALUE || i > MAX_VALUE)
        throw new NumberFormatException(
            "Value out of range. Value:\"" + s + "\" Radix:" + radix);
    return (byte)i;
}
```

### toString():
```java
public static String toString(byte b) {
    return Integer.toString((int)b, 10);
}
```

### valueOf(byte b):Byte
```java
public static Byte valueOf(byte b) {
    final int offset = 128;
    return ByteCache.cache[(int)b + offset];
}
```
**注意：ByteCache是一个静态内部类**，定义如下
```java
private static class ByteCache {
    private ByteCache(){}

    static final Byte cache[] = new Byte[-(-128) + 127 + 1];//数组大小是256

    static {
	//依次填充 -128-------127
        for(int i = 0; i < cache.length; i++)
            cache[i] = new Byte((byte)(i - 128));
    }
}
```
 valueOf还有两种重载形式
```java
public static Byte valueOf(String s, int radix)
    throws NumberFormatException {
    return valueOf(parseByte(s, radix));//其实就是调用第一种
}

public static Byte valueOf(String s) throws NumberFormatException {
    return valueOf(s, 10);
}
```
----------------------


接下来就是实现Number抽象类中的方法：
   其实都是把成员变量value强转而已。
```java
public byte byteValue() {
    return value;
}

public short shortValue() {
    return (short)value;
}

public int intValue() {
    return (int)value;
}

public long longValue() {
    return (long)value;
}

public float floatValue() {
    return (float)value;
}

public double doubleValue() {
    return (double)value;
}
```
继续，Comparable接口的方法实现：
```java
public int compareTo(Byte anotherByte) {
    return compare(this.value, anotherByte.value);
}

public static int compare(byte x, byte y) {
    return x - y;
}
```
----------------------

### 我们接着看 **equals hashcode toString** 这3个方法：
```java
public boolean equals(Object obj) {
    if (obj instanceof Byte) {
        return value == ((Byte)obj).byteValue();
    }
    return false;
}

public int hashCode() {
    return (int)value;
}

public String toString() {
    return Integer.toString((int)value);
}
```

