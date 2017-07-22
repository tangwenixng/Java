package com.twx.test;

public class ConnectionManager {
	Connection[] conns;
	public static void main(String[] args) {
		getConnections();
	}
	
	public static Connection[] getConnections(){
		Connection[] conns = new Connection[10];
		for(int i=0;i<10;i++){
			conns[i]=Connection.creat();
		}
		return conns;
	}
}


class Connection{
	private Connection(){}
	static Connection creat(){
		return new Connection();
	}
}
