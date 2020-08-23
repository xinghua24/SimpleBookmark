package com.xinghua24.bookmarkbe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xinghua24.bookmarkbe.entity.Bookmark;
import com.xinghua24.bookmarkbe.repository.BookmarkRepository;

@Service
public class BookmarkService {
	private BookmarkRepository bookmarkRepository;

	public BookmarkService(BookmarkRepository bookmarkRepo) {
		this.bookmarkRepository = bookmarkRepo;
	}
	
	public List<Bookmark> getAllBookmarks() {
		return bookmarkRepository.findAll();
	}
}
