# 解压缩包安装
  1、解压后的目录：D:\software\mysql-5.6.10-winx64<br>
  2、设置环境变量<br>
  3、修改my-default.ini文件：
    ```
    basedir = D:\software\mysql-5.6.10-winx64
    datadir = D:\software\mysql-5.6.10-winx64\data
    sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES 
    ```
    <br>
  4、进入D:\software\mysql-5.6.10-winx64\bin目录，一定要以管理员身份运行 ```mysqld -install ```<br>
  5、成功后，启动服务：net start mysql
  
# mysql-create-user
mysql5.6 新建用户语句

```
GRANT ALL PRIVILEGES ON *.* TO mercator@localhost IDENTIFIED BY 'password' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO mercator@'%' IDENTIFIED BY 'password' WITH GRANT OPTION;
```

mercator 用户可以从任何地方连接服务器。
如果我们增加localhost条目，对localhost的匿名用户条目在我们从本地主机连接时由mysql_install_db创建的条目将优先考虑，因为它有更特定的Host字段值


mysql5.6 修改用户密码

```
use mysql;
update user set password = password('123456') where user='root';
flush privileges;
```


mysql建表语句：

```
create table server_3dml(
  id int not null auto_increment,
  jobNumber varchar not null,
  name varchar(32) not null,
  createTime date not null,
  primary key (id)
 )ENGINE=InnoDB DEFAUlT CHARSET=utf8;
 ```
 
 查看表结构：   desc server_3dml;
