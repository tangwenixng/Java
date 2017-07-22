源码：
```java
package com.twx;

public class TestClass {
    private int m;

    public int inc() {
        return m + 1;
    }
}
```

编译后生成的class 字节码：
```
cafe babe 0000 0033 0013 0a00 0400 0f09
0003 0010 0700 1107 0012 0100 016d 0100
0149 0100 063c 696e 6974 3e01 0003 2829
5601 0004 436f 6465 0100 0f4c 696e 654e
756d 6265 7254 6162 6c65 0100 0369 6e63
0100 0328 2949 0100 0a53 6f75 7263 6546
696c 6501 000e 5465 7374 436c 6173 732e
6a61 7661 0c00 0700 080c 0005 0006 0100
1163 6f6d 2f74 7778 2f54 6573 7443 6c61
7373 0100 106a 6176 612f 6c61 6e67 2f4f
626a 6563 7400 2100 0300 0400 0000 0100
0200 0500 0600 0000 0200 0100 0700 0800
0100 0900 0000 1d00 0100 0100 0000 052a
b700 01b1 0000 0001 000a 0000 0006 0001
0000 0006 0001 000b 000c 0001 0009 0000
001f 0002 0001 0000 0007 2ab4 0002 0460
ac00 0000 0100 0a00 0000 0600 0100 0000
0a00 0100 0d00 0000 0200 0e
```


class文件格式

| 类型 | 名称 | 数量 |
| --- | ---- | ----| 
| u4 | magic | 1 |
| u2 | minor_version | 1 |
| u2 | major_version | 1 |
| u2 | constant_pool_count | 1 |
| cp_info | constant_pool | constant_pool_count-1 |



1. 魔数 `cafe babe`
1. version `0000 0033`
1. 常量池容量计数器(constant_pool_count) `0013` 共18个 1~19  第0位置保留
1. **常量池(constant_pool)**

常量池的项目类型

| 类型 | 标志 | 描述 |
| --- | ---- | ----| 
| CONSTANT_Utf8_info | 1 | ---- |
| CONSTANT_Integer_info | 3 | ---- |
| CONSTANT_Float_info | 4 | ---- |
| CONSTANT_Long_info | 5 | ---- |
| CONSTANT_Double_info | 6 | ---- |
| CONSTANT_Class_info | 7 | ---- |
| CONSTANT_String_info | 8 | ---- |
| CONSTANT_Fieldref_info | 9 | ---- |
| CONSTANT_Methodref_info | 10 | --- |
| CONSTANT_InterfaceMethodref_info | 11 | ---- |
| CONSTANT_NameAndType_info | 12 | ---- |
| CONSTANT_MethodHandle_info | 15 |---- |
| CONSTANT_MethodType_info | 16 | ---- |
| CONSTANT_InvokeDynamic_info | 18 | ---- |

CONSTANT_Methodref_info结构

| 类型 | 名称 | 数量 |
| --- | ---- | ----| 
| u1 | tag | 1 |
| u2 | index | 指向声明方法的类描述符CONSTANT_Class_info的索引项 | 
| u2 | index | 指向名称及类型描述符CONSTANT_NameAndType_info的索引项 |

CONSTANT_Fieldref_info结构

| 类型 | 名称 | 数量 |
| --- | ---- | ----| 
| u1 | tag | 1 |
| u2 | index | 指向声明方法的类描述符CONSTANT_Class_info的索引项 | 
| u2 | index | 指向名称及类型描述符CONSTANT_NameAndType_info的索引项 |

CONSTANT_Class_info

| 类型 | 名称 | 数量 |
| --- | ---- | ----|  
| u1 | tag | 1 |
| u2 | index | 指向全限定名常量项的索引 | 

CONSTANT_Utf8_info

| 类型 | 名称 | 数量 |
| --- | ---- | ----| 
| u1 | tag | 1 |
| u2 | length | 字符串占用的字节数 | 
| u1 | bytes | 长度为lenght的字符串
	
	
	1. 第一项常量的 tag是 `0a` 属于 CONSTANT_Methodref_info,index指向索引项为`0004`的CONSTANT_Class_info
	index 指向 索引项为`000f` 的CONSTANT_NameAndType_info
	2. 第二项常量的 tag是 `09`,指向CONSTANT_Fieldref_info表。index指向索引项为`0003`的CONSTANT_Class_info
	index 指向 索引项为`0010` (16) 的CONSTANT_NameAndType_info
	3. 第三项常量的 tag是 `07`,指向CONSTANT_Class_info表。index指向第`0011` (17)个常量项
	4. 第四项常量的tag是`07' ,指向CONSTANT_Class_info表。index指向第`0012` (18)个常量项
	5. 第五项常量的tag是`01' ,指向CONSTANT_Utf8_info表。长度length `0001`,bytes `6d` (109--字母m)
	6. 第六项常量的tag是`01' ,指向CONSTANT_Utf8_info表。长度length `0001`,bytes `49` (73--字母I)
	7. 第七项常量的tag是`01' ,指向CONSTANT_Utf8_info表。长度length `0006`个字符；bytes `3c 696e 6974 3e` 转为字符串是'<init>'
	8. 第八项常量的tag是`01' ,指向CONSTANT_Utf8_info表。长度length `0003`,bytes `2829 56` 转为字符串是 ()V
	9. 第九项常量的tag是`01' ,指向CONSTANT_Utf8_info表。长度length `0004`,bytes `436f 6465` 转为字符串是 Code
	10. 第九项常量的tag是`01' ,指向CONSTANT_Utf8_info表。长度length `000f`,bytes `4c 696e 654e 756d 6265 7254 6162 6c65` 转为字符串是 		LineNumberTable
	11. 第八项常量的tag是`01' ,指向CONSTANT_Utf8_info表。长度length `0003`,bytes `69 6e63` 转为字符串是 inc
	剩下的7个就不写了
	
