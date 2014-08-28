package org.softleader;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
@WebAppConfiguration
public class Score {

	@Autowired
	WebApplicationContext ctx;

	MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void calculateScore() {
		int score = 0;

		try {
			index();
			score += 25;
		} catch (Exception e) {
			System.out.println("You are not yet finish create index page");
		}

		try {
			signinSuccess();
			score += 25;
		} catch (Exception e) {
			System.out.println("You are not yet finish create index page");
		}

		try {
			signinError();
			score += 25;
		} catch (Exception e) {
			System.out.println("You are not yet finish create index page");
		}

		try {
			getUserPage();
			score += 25;
		} catch (Exception e) {
			System.out.println("You are not yet finish create list page");
		}

		System.out.println("Your score is " + score);
	}

	private void index() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk()).andDo(print());
	}

	private void signinSuccess() throws Exception {
		mvc.perform(post("/signin").param("username", "ronan.yang")).andExpect(status().isFound()).andDo(print());
	}

	private void signinError() throws Exception {
		mvc.perform(post("/signin").param("username", "aaa")).andExpect(status().isOk())
				.andExpect(content().string(containsString("The username is invalid."))).andDo(print());
	}

	private void getUserPage() throws Exception {
		mvc.perform(get("/users")).andExpect(status().isOk()).andExpect(content().string(containsString("ronan.yang")))
				.andExpect(content().string(containsString("tim.lee"))).andExpect(content().string(containsString("jammy.wang")))
				.andExpect(content().string(containsString("kat.huang"))).andExpect(content().string(containsString("jerry.chiang")))
				.andExpect(content().string(containsString("glen.chuang"))).andExpect(content().string(containsString("caty.tasi")))
				.andExpect(content().string(containsString("wilson.wang"))).andExpect(content().string(containsString("zoe.liu")))
				.andExpect(content().string(containsString("van.lin"))).andDo(print());
	}
}
