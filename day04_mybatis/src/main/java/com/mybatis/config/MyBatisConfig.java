package com.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisConfig {
//	sqlSession을 만들기 위해 세션 팩토리가 필요함
	private static SqlSessionFactory sqlSessionFactory;
	 
//	 팩토리는 딱 한번 프로그램이 시작할 떄 만들면 됨
//	 → static 초기화 블록으로 생성
	static {
		 try {
	//		 설정 파일의 경로 저장
			 String resource = "./com/mybatis/config/config.xml";
			 
	//		 Resources 클래스를 이용하여 리소스를 읽어들여 Reader 객체 생성
			 Reader reader = Resources.getResourceAsReader(resource);
			 
	//		 세션 팩토리 필더에게 팩토리를 지어달라고 요청 ⇢ build()
	//		 공장을 짓기 위해 설계도가 필요함
	//		 설계도는 설정값을 저장하고 있는 reader임
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			System.out.println("MyBatisConfig.java 초기화 문제 발생");
			e.printStackTrace();
		}
	}

//	sqlSessionFactory의 접근 제한자가 private이므로 getter를 만들어줌
//	static 변수이므로 getter에도 static이 붙는 것을 확인 가능
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
