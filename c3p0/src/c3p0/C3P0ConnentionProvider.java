package c3p0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class C3P0ConnentionProvider {
	private static final String JDBC_DRIVER = "driverClass";  
    private static final String JDBC_URL = "jdbcUrl";  
    
    private static DataSource ds;
    
    static{
    	initDBSource();
    }
    
	private static void initDBSource(){
    	Properties c3p0Pro = new Properties();
    	try {
			c3p0Pro.load(new FileInputStream("c3p0.properties"));
			System.out.println("加载配置文件完成。。。");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	String driverClass = c3p0Pro.getProperty(JDBC_DRIVER);
    	String jdbcUrl = c3p0Pro.getProperty(JDBC_URL);
    	if(driverClass!=null){
    		try {
    			//加载驱动文件
				Class.forName(driverClass);
				System.out.println("加载驱动文件完成....");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    	}

    	
         Properties c3propes = new Properties(); 
         Properties jdbcpropes = new Properties(); 
         for(Object key:  c3p0Pro.keySet()){
        	 String skey = (String)key;  
        	 if(skey.startsWith("c3p0.")){
        		 c3propes.put(skey, c3p0Pro.getProperty(skey));
        	 }else {
				jdbcpropes.put(skey, c3p0Pro.getProperty(skey));
			}
         }
         
         try {
        	 //建立连接池
			DataSource dataSource = DataSources.unpooledDataSource(jdbcUrl,jdbcpropes);
			ds = DataSources.pooledDataSource(dataSource, c3propes);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static synchronized Connection getConnection() throws SQLException{  
        final Connection conn = ds.getConnection();  
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);  
        return conn;  
    } 
}
