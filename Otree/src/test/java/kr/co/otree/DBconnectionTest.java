package kr.co.otree;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 @RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
 public class DBconnectionTest {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	private SqlSessionFactory factory;
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/otree?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
			log.info("MySQL 연결성공: {}",connection);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFactory() {
		log.info("{}",factory);
	}
	
	@Test
	public void testSession() throws Exception{
		
		try(SqlSession session = factory.openSession()) {
			log.info(session.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
