package org.softleader;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
@WebAppConfiguration
public class AppTest {

	private static final Logger log = LoggerFactory.getLogger(AppTest.class);

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

		score += part1();
		score += part2_1();
		score += part2_2();
		score += part3();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("========================================================================================================");
		System.out.println("你的分數是" + score + "分");
		System.out.println("請記得執行mvn source:jar");
		System.out.println("將 thymeleaf-exam- firstname.lastname -sources.jar 與 thymeleaf-exam- firstname.lastname .jar");
		System.out.println("寄到 steven.wang@softleader.com.tw");
		System.out.println("========================================================================================================");
		System.out.println();
		System.out.println();
		System.out.println();
	}

	private int part1() {
		int score = 0;
		try {
			ResultActions resultActions = mvc.perform(get("/")).andExpect(status().isOk());
			if (log.isDebugEnabled()) {
				resultActions.andDo(print());
			}
			score += 20;
		} catch (Throwable e) {}
		return score;
	}

	private int part2_1() {
		int score = 0;
		try {
			ResultActions resultActions = mvc.perform(get("/")).andExpect(status().isOk());
			if (log.isDebugEnabled()) {
				resultActions.andDo(print());
			}

			String content = resultActions.andReturn().getResponse().getContentAsString();
			Document doc = Jsoup.parse(content);

			if ("/css/bootstrap.css".equals(doc.select("link").attr("href"))) {
				score += 5;
			}

			if (doc.select("div").hasClass("container")) {
				score += 2;
			}

			if (doc.select(".container > h1").hasClass("text-muted")) {
				score += 2;
			}

			if ("User login".equals(doc.select(".container > h1").text())) {
				score += 2;
			}

			if ("/signin".equals(doc.select(".container > form").attr("action"))) {
				score += 5;
			}

			if (doc.select(".container > form > div").hasClass("form-group")) {
				score += 2;
			}

			if ("Username".equals(doc.select(".container > form > .form-group > label").text())) {
				score += 2;
			}

			if (doc.select(".container > form > .form-group > input").hasClass("form-control")) {
				score += 2;
			}

			if ("username".equals(doc.select(".container > form > .form-group > .form-control").attr("name"))) {
				score += 2;
			}

			if (doc.select(".container > form > button").hasClass("btn") && doc.select(".container > form > .btn").hasClass("btn-success")) {
				score += 2;
			}

			if (doc.select(".container > form > .btn-success > span").hasClass("glyphicon")
					&& doc.select(".container > form > .btn-success > .glyphicon").hasClass("glyphicon-log-in")) {
				score += 2;
			}

			if ("Login".equals(doc.select(".container > form > .btn-success").text())) {
				score += 2;
			}
		} catch (Throwable e) {}
		return score;
	}

	private int part2_2() {
		int score = 0;
		try {
			ResultActions resultActions =
					mvc.perform(post("/signin").param("username", "aaa")).andExpect(status().isOk())
							.andExpect(content().string(containsString("The username is invalid.")));
			if (log.isDebugEnabled()) {
				resultActions.andDo(print());
			}

			score += 5;

			String content = resultActions.andReturn().getResponse().getContentAsString();
			Document doc = Jsoup.parse(content);

			if (doc.select(".container > .alert-danger").hasClass("alert")) {
				score += 5;
			}
		} catch (Throwable e) {}
		return score;
	}

	private int part3() {
		int score = 0;
		try {
			ResultActions resultActions =
					mvc.perform(get("/users")).andExpect(status().isOk()).andExpect(content().string(containsString("ronan.yang")))
							.andExpect(content().string(containsString("tim.lee"))).andExpect(content().string(containsString("jammy.wang")))
							.andExpect(content().string(containsString("kat.huang"))).andExpect(content().string(containsString("jerry.chiang")))
							.andExpect(content().string(containsString("glen.chuang"))).andExpect(content().string(containsString("caty.tasi")))
							.andExpect(content().string(containsString("wilson.wang"))).andExpect(content().string(containsString("zoe.liu")))
							.andExpect(content().string(containsString("van.lin")));

			if (log.isDebugEnabled()) {
				resultActions.andDo(print());
			}

			score += 20;

			String content = resultActions.andReturn().getResponse().getContentAsString();
			Document doc = Jsoup.parse(content);

			if ("/css/bootstrap.css".equals(doc.select("link").attr("href"))) {
				score += 2;
			}

			if (doc.select(".table").hasClass("table-striped")) {
				score += 4;
			}

			if (doc.select(".table-striped").select("tr").size() == 11) {
				score += 6;
			}

			if (doc.select(".table-striped").select(".danger").size() == 5) {
				score += 8;
			}
		} catch (Throwable e) {}
		return score;
	}
}
