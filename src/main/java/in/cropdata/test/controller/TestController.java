/**
 * 
 */
package in.cropdata.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author newuser
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Value("${health.check.message}")
	private String healthCheckMessage;

	@GetMapping("/health-check")
	public String healthCheck() {
		return healthCheckMessage ;
	}

}
