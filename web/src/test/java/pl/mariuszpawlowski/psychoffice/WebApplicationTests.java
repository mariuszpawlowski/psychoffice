package pl.mariuszpawlowski.psychoffice;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = WebApplication.class)
//@WebAppConfiguration
public class WebApplicationTests {

	@Test
	public void sample() {
		String admin = new BCryptPasswordEncoder().encode("pass");
		System.out.println(admin);


	}

}
