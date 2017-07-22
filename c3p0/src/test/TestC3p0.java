package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import c3p0.C3P0ConnentionProvider;

public class TestC3p0 {
	public static void main(String[] args) {
		for(int i=0;i<30;i++){
			new Thread(new C3P0()).start();
		}
	}
}

class C3P0 implements Runnable{

	@Override
	public void run() {
		try {
			Connection connection = C3P0ConnentionProvider.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from students where id = '1' ");
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			System.out.println(Thread.currentThread().getName()+":"+resultSet.getString("name")); 
			
			try {
				Thread.sleep(10*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
