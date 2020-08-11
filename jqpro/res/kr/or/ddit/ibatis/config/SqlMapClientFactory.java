package kr.or.ddit.ibatis.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	
	private static SqlMapClient smc;
	
	static{
		
		Reader rd;
		
		try{
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/SqlMapConfig.xml"); // 웹에서는 다써주는게 좋다
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
		}catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패");
			e.printStackTrace();
		}
		
	}
	
	public static SqlMapClient getClient(){
		return smc;
	}
}
