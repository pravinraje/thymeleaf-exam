package org.softleader.home;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.softleader.SpringMvcTest;

public class HomeControllerTest extends SpringMvcTest {

	@Test
	public void index() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void signinSuccess() throws Exception {
		mvc.perform(
			post("/signin").param("username", "ronan.yang"))
				.andExpect(status().isFound())
				.andDo(print());
	}

	@Test
	public void signinError() throws Exception {
		mvc.perform(
			post("/signin").param("username", "aaa"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("The username is invalid.")))
				.andDo(print());
	}
}
