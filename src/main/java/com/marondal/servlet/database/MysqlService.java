package com.marondal.servlet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class MysqlService {

    private String url;
    private String id;
    private String password;

    // 접속 관리 객체 
    private Connection connection;
    private Statement statement;

    //클래스를 설계하는 입장에서 
  	//해당 클래스의 객체가 하나이상 만들어 지지 않도록 관리한다.
  	//하나의 객체를 공유해서 사용하도록한다.
  	//single pattern
    //static 맴버변수 : 객체 생성없이 사용할 수 있는 맴버변수
    private static MysqlService mysqlService = null;
    
//   private MysqlService() {
//	   
//   }
    
    // 싱글턴 
    public static MysqlService getInstance() {//static: 객체 생성없이 호출가능
        if(mysqlService == null) {
            mysqlService = new MysqlService();
        }
        return mysqlService;
    }

    public MysqlService() {
        this.url = "jdbc:mysql://localhost:3306/dulmury_123";
        this.id = "root";
        this.password = "root";
    }

    // 접속 메소드 
    public boolean connect() {
    	
    	//데이터베이스 접속이 되어 있는 경우 접속과정이 진행되지 않음
    	try {
			if(connection != null && !connection.isClosed()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // mysql 접속 url 
            // mysql id
            // mysql 비밀 번호
            this.connection = DriverManager.getConnection(
                    this.url,
                    this.id,
                    this.password);

            // 쿼리를 수행하기 위한 객체 
            this.statement = connection.createStatement();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
    }

    // 쿼리 수행 메소드 
    // 업데이트 insert, update, delete
    public int update(String query) throws SQLException {
        return this.statement.executeUpdate(query);
    }
    // 쿼리 select
    public List<Map<String, Object>> ResultSet select(String query) {
    	
    	Statement statement;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			List<Map<String, Object>> ResultList = new ArrayList<>();
			
			while(resultSet.next()) {
				
				Map<String, Object> resultMap = new HashMap<>();
				resultMap.put("id", resultSet.getInt("id"));
				resultMap.put("name", resultSet.getInt("name"));
				resultMap.put("url", resultSet.getInt("url"));
				
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				
				List<String> columnList = new ArrayList<>();
				
				for(int i = 1; i <= columnCount; i++) {
					columnList.add(rsmd.getColumnName(i));
				}
				
				List<String> resultList = new ArrayList<>();
				
				while(resultSet.next()) {
					Map<String, Object> resultMap = new HashMap<>();
					
				}
				
				
			}
			
	    	statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    // 접속 끊기 메소드 
    public void disconnect() throws SQLException {
        this.statement.close();
        this.connection.close();
    }
}