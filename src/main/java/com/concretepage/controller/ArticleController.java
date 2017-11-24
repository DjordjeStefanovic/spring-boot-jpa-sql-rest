package com.concretepage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Article;
import com.concretepage.service.IArticleService;

@Controller
@RequestMapping("user")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	@GetMapping("article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@GetMapping("article")
	public ResponseEntity<List<Article>> getAllArticles() {
		System.out.println("@GetMapping(\"article\"): getAllArticles");
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}
	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	//@RequestMapping(value = "/viewList", method = RequestMethod.GET)
	@RequestMapping(value = "/viewList", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView viewList() {
		System.out.println("index page request.");

		//model.addAttribute("return", articleService.getAllArticles());

		//return "forward:/resources/viewList.html";
		//String res = "forward:/resources/viewList.html";

		//return "viewList.html";
		ModelAndView modelAndView = new ModelAndView("viewList");
		return modelAndView;
	}

	@GetMapping("/error")
	public ResponseEntity<Void>  error(Model model) {
		System.out.println("/error happened");
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}