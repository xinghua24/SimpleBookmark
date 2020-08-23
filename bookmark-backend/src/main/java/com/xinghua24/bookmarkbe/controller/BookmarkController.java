package com.xinghua24.bookmarkbe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinghua24.bookmarkbe.entity.Bookmark;
import com.xinghua24.bookmarkbe.service.BookmarkService;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
	private BookmarkService bookmarkService;
	
    public BookmarkController(BookmarkService bookmarkService) {
		this.bookmarkService = bookmarkService;
	}

	@GetMapping("")
    public List<Bookmark> getAllBookmarks() {
        return bookmarkService.getAllBookmarks();
    }
}
