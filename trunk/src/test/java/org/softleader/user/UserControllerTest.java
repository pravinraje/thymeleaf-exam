package org.softleader.user;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.softleader.SpringMvcTest;

public class UserControllerTest extends SpringMvcTest {

	@Test
	public void index() throws Exception {
		mvc.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("ronan.yang")))
			.andExpect(content().string(containsString("tim.lee")))
			.andExpect(content().string(containsString("jammy.wang")))
			.andExpect(content().string(containsString("kat.huang")))
			.andExpect(content().string(containsString("jerry.chiang")))
			.andExpect(content().string(containsString("glen.chuang")))
			.andExpect(content().string(containsString("caty.tasi")))
			.andExpect(content().string(containsString("wilson.wang")))
			.andExpect(content().string(containsString("zoe.liu")))
			.andExpect(content().string(containsString("van.lin")))
			.andDo(print());
	}
}
