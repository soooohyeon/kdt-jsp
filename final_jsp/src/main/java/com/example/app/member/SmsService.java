package com.example.app.member;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsService {
//	Cool SMS 내용 전달
//	private static final String API_KEY = "NCSTNKNU4C7NQECE";
//	private static final String API_SECRET = "A7BUXEGXRG6VCQYHLTG5L1IRZCCRX5LI";
//	private static final String FROM_NUMBER = "번호";
	
	   private static final String API_KEY = "NCSPNNVBVPVPRTVX";
	   private static final String API_SECRET = "LSISNFQLHSZJU90NCZRQ2VA7HBK7ASZN";
	   private static final String FROM_NUMBER = "01075812581";
	
	public String sendVerificationSms(String to) throws CoolsmsException {
//		공식문서(Spring 기준)에 작성되어있는 방식 / 아래 방식처럼 작성된다는것만 알아두면 됨
		System.out.println("SMS Service ================= " + to);
		Message coolsms = new Message(API_KEY, API_SECRET);
		String verificationCode = generateVerificationCode();
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", to);
		params.put("from", FROM_NUMBER);
		params.put("type", "SMS");
		params.put("text", "인증번호는 [" + verificationCode + "] 입니다.");
		
		JSONObject obj = (JSONObject)coolsms.send(params);
		System.out.println("문자 발송 완료");
		System.out.println(obj.toString());
		
		return verificationCode;
	}
	
//	인증번호 생성 메소드
//	해당 클래스 파일 내에서만 사용할 메소드라 private으로 메소드 선언
	private String generateVerificationCode() {
		Random random = new Random();
//		String 타입으로 생성하게 되면 + 연산(문자열 연결)이 발생될 때마다 메모리 할당과 해제를 발생시킴
//		덧셈 연산이 많아지게 될 경우 성능 저하됨↓
		StringBuilder code = new StringBuilder();
//		인증번호 6자리로 생성
		for (int i = 0; i < 6; i++) {
//			0 ~ 10 난수 반환 후 저장
			code.append(random.nextInt(10));
		}
		return code.toString();
	}
	
}
