```java
public static String toString(int i) {
        if (i == Integer.MIN_VALUE)
            return "-2147483648";
        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
        char[] buf = new char[size];
        getChars(i, size, buf);
        return new String(buf, true);
    }
```
同样，为了便于理解，我举个具体的例子
Integer.toString(173)

1. `int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);`
看这一行的stringSize(i)方法

```java
//判断这个value 是几位数
static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
                                      99999999, 999999999, Integer.MAX_VALUE };
```
 173<=sizeTable[0]//false  
 173<=sizeTable[1]//false  
 173<=sizeTable[2]//true  
所以返回3；所以int size = 3;

2. **核心方法getChars(int,int,char[])**
用于获取解析后的字符数组
```java
static void getChars(int i, int index, char[] buf) {
        int q, r;
        int charPos = index;
        char sign = 0;

        if (i < 0) {
            sign = '-';
            i = -i;
        }

        // Generate two digits per iteration
        while (i >= 65536) {
            q = i / 100;
        // really: r = i - (q * 100);
            r = i - ((q << 6) + (q << 5) + (q << 2));
            i = q;
            buf [--charPos] = DigitOnes[r];
            buf [--charPos] = DigitTens[r];
        }

        // Fall thru to fast mode for smaller numbers
        // assert(i <= 65536, i);
        //当传入的值<=65536时
        for (;;) {
            q = (i * 52429) >>> (16+3);
            r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
            buf [--charPos] = digits [r];
            i = q;
            if (i == 0) break;
        }
        if (sign != 0) {
            buf [--charPos] = sign;
        }
    }
```
这个方法很长，现在我们传入的值是173，所以只分析下面这一段代码：
```java
for (;;) {
          //这里的52429是什么？
          //看看2^19的十进制是什么吧！ 2^19=524288
         //知道了吧，52429就是524288/10的近似数
           //所以52429/2^19约等于0.1
         // q = (i * 52429) >>> (16+3);  意思就是 i/10 (本例 173/10=17)
            q = (i * 52429) >>> (16+3);
            r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...官方注解很明显 就是求 i的余数
          //本例 173%10=3
            buf [--charPos] = digits [r];  //digits[3] = '3'
            i = q;
            if (i == 0) break;
        }
```
然后是循环，最后buf[] = ['1','7','3']
