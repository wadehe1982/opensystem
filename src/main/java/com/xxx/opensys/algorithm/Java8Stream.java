package com.xxx.opensys.algorithm;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.ToString;

public class Java8Stream {
	
	
	public static void main(String[] args) {
		
		List<String> tags1 = Lists.newArrayList("java","pc","algorithm");
		Article article1 = new  Article("java", "1", tags1);
		
		List<String> tags2 = Lists.newArrayList("java","science","test");
		Article article2 = new Article("java", "2", tags2);
		
		List<String> tags3 = Lists.newArrayList("java","fish","hhhh");
		Article article3 = new Article("java", "3", tags3);
		
		List<String> tags4 = Lists.newArrayList("yyyy","fish","xxxx");
		Article article4 = new Article("xxx", "4", tags4);
		
		List<Article> articles = Lists.newArrayList(article1,article2,article3,article4);

		System.out.println(articles.stream().collect(Collectors.groupingBy(Article::getAuthor)));
		
		System.out.println(articles.stream().flatMap(article -> article.getTags().stream()).collect(Collectors.toSet()));
		
	}
	@ToString
	public static class Article {
		 
        private final String title;
        private final String author;
        private final List<String> tags;
 
        private Article(String title, String author, List<String> tags) {
            this.title = title;
            this.author = author;
            this.tags = tags;
        }
 
        public String getTitle() {
            return title;
        }
 
        public String getAuthor() {
            return author;
        }
 
        public List<String> getTags() {
            return tags;
        }
    }

}
