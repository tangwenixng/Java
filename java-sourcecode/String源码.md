# 成员变量
```java
private final char value[];//这个char数组很重要，大多数方法都是操作这个数组
private int hash; // Default to 0  哈希值
```
# 构造器
----
看几个关键的构造器就OK了
```java
//默认构造器，相当于 String s = "";
public String() {
    this.value = "".value;
}
//这是最常用的一个构造器
//主要是初始化上面两个成员变量
 public String(String original) {
    this.value = original.value;
    this.hash = original.hash;
}
//也算常用吧
public String(char value[]) {
    //把value[] 数组的值拷贝到成员变量里面
    //说道这里，必须看一下copyOf()方法里的arraycopy（）;
    this.value = Arrays.copyOf(value, value.length);
}
//这是一个本地方法
//作用是 从src的起始位置srcPos  拷贝 长度length 个字符  到目标数组destPost(拷贝的起始位置是destPos)
System.arraycopy(Object src,int srcPos,Object dest,int destPos,int length);

//StringBuilder后面再讲解
 public String(StringBuilder builder) {
    this.value = Arrays.copyOf(builder.getValue(), builder.length());
}
```

### 简单的一组
```java
//返回char[]数组的长度
 public int length() {
    return value.length;
}
public boolean isEmpty() {
    return value.length == 0;
}
public char charAt(int index) {
    if ((index < 0) || (index >= value.length)) { //数组越界
        throw new StringIndexOutOfBoundsException(index);
    }
    return value[index];
}
/**
* 把字符串 srcBegin到srcEnd 这几个字符 拷贝到目标数组dst[] 的第dstBegin处
*/
 public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
    if (srcBegin < 0) {
        throw new StringIndexOutOfBoundsException(srcBegin);
    }
    if (srcEnd > value.length) {
        throw new StringIndexOutOfBoundsException(srcEnd);
    }
    if (srcBegin > srcEnd) {
        throw new StringIndexOutOfBoundsException(srcEnd - srcBegin);
    }
    System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
}

public boolean equals(Object anObject) {
    if (this == anObject) { //如果比较的自身，肯定相等
        return true;
    }
    //先比较两者的长度
    //然后再按顺序比较每个字符是否相等，只要一个不相等就返回false
    if (anObject instanceof String) { //类型检测
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
/**
* 把每个字符转换成int值，然后按照下面的公式叠加
*  s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
*/
public int hashCode() {
    int h = hash; //成员变量起到缓存的作用，因为String是不可变对象，只在第一次会计算hash值
    if (h == 0 && value.length > 0) {
        char val[] = value;

        for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}

/**
* 本质上也是 一个一个字符比较
*/
public boolean startsWith(String prefix, int toffset) {
    char ta[] = value;
    int to = toffset;
    char pa[] = prefix.value;
    int po = 0;
    int pc = prefix.value.length;
    // Note: toffset might be near -1>>>1.
    //解释一下toffset > value.length - pc  
    //假如 字符串 str="abcdefgh" prefix="efgh" toffset=5 ， 很明显了吧
    if ((toffset < 0) || (toffset > value.length - pc)) {
        return false;
    }
    while (--pc >= 0) {
        if (ta[to++] != pa[po++]) {
            return false;
        }
    }
    return true;
}

//理解了上面的，这个就很容易了
public boolean endsWith(String suffix) {
    return startsWith(suffix, value.length - suffix.value.length);
}
```
