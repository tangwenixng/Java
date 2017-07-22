## MySQL存储过程的查询
1. 查询存储过程名称：
 > show procedure status from db='db_name';
 
 > select name from mysql.proc where db='db_name';
 
 2. 查询存储过程的内容
 > SHOW CREATE PROCEDURE 数据库.存储过程名;
 
 ## MySQL存储过程的修改
 > ALTER PROCEDURE;
 
 ## MySQL存储过程的删除
 > delete procedure;
 
 ## MySQL存储过程的控制语句
 
 1. 变量作用域  
 当执行到end。变量时，内部变量消失
 ```
mysql > DELIMITER //  
mysql > CREATE PROCEDURE proc3()  
     -> begin 
     -> declare x1 varchar(5) default 'outer';  
     -> begin 
     -> declare x1 varchar(5) default 'inner';  
     -> select x1;  
     -> end;  
     -> select x1;  
     -> end;  
     -> //  
mysql > DELIMITER ; 
 ```
 2. 条件语句
 
    2.1 if-then -else语句  
    ```
    mysql > DELIMITER //  
    mysql > CREATE PROCEDURE proc2(IN parameter int)  
         -> begin 
         -> declare var int;  
         -> set var=parameter+1;  
         -> if var=0 then 
         -> insert into t values(17);  
         -> end if;  
         -> if parameter=0 then 
         -> update t set s1=s1+1;  
         -> else 
         -> update t set s1=s1+2;  
         -> end if;  
         -> end;  
         -> //  
    mysql > DELIMITER ; 
    ```
    2.2 case语句
    ```
    mysql > DELIMITER //  
    mysql > CREATE PROCEDURE proc3 (in parameter int)  
         -> begin 
         -> declare var int;  
         -> set var=parameter+1;  
         -> case var  
         -> when 0 then   
         -> insert into t values(17);  
         -> when 1 then   
         -> insert into t values(18);  
         -> else   
         -> insert into t values(19);  
         -> end case;  
         -> end;  
         -> //  
    mysql > DELIMITER ; 
    ```
    2.3 while ···· end while：
    ```
    mysql > DELIMITER //  
    mysql > CREATE PROCEDURE proc4()  
         -> begin 
         -> declare var int;  
         -> set var=0;  
         -> while var<6 do  
         -> insert into t values(var);  
         -> set var=var+1;  
         -> end while;  
         -> end;  
         -> //  
    mysql > DELIMITER ;
    ```
    2.4 loop ·····end loop:
    ```
    mysql > DELIMITER //  
    mysql > CREATE PROCEDURE proc6 ()  
         -> begin 
         -> declare v int;  
         -> set v=0;  
         -> LOOP_LABLE:loop  
         -> insert into t values(v);  
         -> set v=v+1;  
         -> if v >=5 then 
         -> leave LOOP_LABLE;  
         -> end if;  
         -> end loop;  
         -> end;  
         -> //  
    mysql > DELIMITER ; 
    ```