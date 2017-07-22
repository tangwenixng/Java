# javaIO
以后遇到 java_IO 的问题 
都会更新到这个库里的

java.io包分为四大抽象类：

	-  InputStream 
		- FileInputStream
	- OutputStream
	-  Reader
		- BufferedReader
		- InputStreamReader
	-  Writer

 ```
 InputStream inputStream=new FileInputStream(file);
 InputStreamReader reader=new InputStreamReader(inputStream);
 BufferedReader rd=new BufferedReader(reader);
```
