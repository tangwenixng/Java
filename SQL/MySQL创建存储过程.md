## 格式
> create procedure 过程名([过程参数]) [特性] 过程体  
例子：  
```
delimiter //
create procedure procl(OUT　ｓ int)
begin
select count(*) into s from user
end
//
delimiter ;
```
1. DELIMITER是分割符的意思,如果我们没有声明分割符，那么编译器会把存储过程当成SQL语句进行处理。  
2. 这里的输出参数是s,类型是int,如果有多个参数用","分割开。
3. 过程体的开始与结束使用BEGIN与END进行标识。

## 声明分割符
---
如果是用MySQL的Administrator管理工具时，可以直接创建，不再需要声明

## 参数
---
有三种参数类型,IN,OUT,INOUT  
1. IN 例子:
```
delimiter //
create procedure demo_in_parameter(IN　p_in int)
begin
select p_in;
set p_in = 2;
select p_in;
end
//
delimiter ;
```
执行结果：
```
set @p_in=1;
call demo_in_parameter(@p_in)
+------+  
| p_in |  
+------+  
|   1  |   
+------+  
 
+------+  
| p_in |  
+------+  
|   2  |   
+------+ 
mysql> SELECT @p_in;  
+-------+  
| @p_in |  
+-------+  
|  1    |  
+-------+ 
```
p_in在存储过程中虽然被修改了，但并不影响@p_in的值

2. OUT例子：
```
delimiter //
create procedure demo_out_parameter(OUT　p_out int)
begin
select p_out;
set p_out=2;
select p_out;
end
//
delimiter ;
```
执行结果：
```
mysql > SET @p_out=1;  
mysql > CALL demo_out_parameter(@p_out);  
+-------+  
| p_out |   
+-------+  
| NULL  |   
+-------+  
 
+-------+  
| p_out |  
+-------+  
|   2   |   
+-------+  
 
mysql> SELECT @p_out;  
+-------+  
| p_out |  
+-------+  
|   2   |  
+-------+  
```

3. INOUT例子：
```
DELIMITER //   
CREATE PROCEDURE demo_inout_parameter(INOUT p_inout int)   
-> BEGIN 
-> SELECT p_inout;  
-> SET p_inout=2;  
-> SELECT p_inout;   
-> END;  
-> //   
mysql > DELIMITER ;
```
执行结果：
```
mysql > SET @p_inout=1;  
mysql > CALL demo_inout_parameter(@p_inout) ;  
+---------+  
| p_inout |  
+---------+  
|    1    |  
+---------+  
 
+---------+  
| p_inout |   
+---------+  
|    2    |  
+---------+  
 
mysql > SELECT @p_inout;  
+----------+  
| @p_inout |   
+----------+  
|    2     |  
+----------+
```

## 变量
---
1. 变量定义
> declare variable_name [,name2....] datatype [default value]
例子：
```
DECLARE l_int int unsigned default 4000000;  
DECLARE l_numeric number(8,2) DEFAULT 9.95;  
DECLARE l_date date DEFAULT '1999-12-31';
```
2. 变量赋值
> set variable_name = 表达式值

3. 用户变量

    3.1 MySQL客户端
    ```
    mysql > SELECT 'Hello World' into @x;  
    mysql > SELECT @x;  
    +-------------+  
    |   @x        |  
    +-------------+  
    | Hello World |  
    +-------------+  
    mysql > SET @y='Goodbye Cruel World';  
    mysql > SELECT @y;  
    +---------------------+  
    |     @y              |  
    +---------------------+  
    | Goodbye Cruel World |  
    +---------------------+  
     
    mysql > SET @z=1+2+3;  
    mysql > SELECT @z;  
    +------+  
    | @z   |  
    +------+  
    |  6   |  
    +------+  
    ```
    3.2 存储过程中使用
    
    ```
    mysql > CREATE PROCEDURE GreetWorld( ) SELECT CONCAT(@greeting,' World');  
    mysql > SET @greeting='Hello';  
    mysql > CALL GreetWorld( );  
    +----------------------------+  
    | CONCAT(@greeting,' World') |  
    +----------------------------+  
    |  Hello World               |  
    +----------------------------+ 
    ```
    ①用户变量名一般以@开头
    ②滥用用户变量会导致程序难以理解及管理
    
## 注释
---
双模杠：--  
c风格： 一般用于多行注释
