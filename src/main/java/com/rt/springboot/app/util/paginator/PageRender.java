package com.rt.springboot.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;
	
	private int totalPages;
	
	private int numElementsByPages;
	
	private int actualPage;
	
	private List<PageItem> pages;

	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();
		
		numElementsByPages = page.getSize();
		totalPages = page.getTotalPages();
		actualPage = page.getNumber() + 1;
		
		int from, upto;
		if(totalPages <= numElementsByPages) {
			from = 1;
			upto = totalPages;
		} else {
			if(actualPage <= numElementsByPages/2) {
				from = 1;
				upto = numElementsByPages;
			} else if (actualPage >= totalPages - numElementsByPages/2) {
				from = totalPages - numElementsByPages + 1;
				upto = numElementsByPages;
			} else {
				from = actualPage - numElementsByPages/2;
				upto = numElementsByPages;
			}
		}
		for(int i=0 ; i<upto ; i++) {
			pages.add(new PageItem(from + i, actualPage == from + 1));
		}
	}

	public String getUrl() { return url; }

	public int getTotalPages() { return totalPages; }

	public int getActualPage() { return actualPage; }

	public List<PageItem> getPages() { return pages; }
	
	public boolean isFirst() { return page.isFirst(); }
	
	public boolean isLast() { return page.isLast(); }
	
	public boolean isHasNext() { return page.hasNext(); }
	
	public boolean isHasPrevious() { return page.hasPrevious(); }
	
	
}
