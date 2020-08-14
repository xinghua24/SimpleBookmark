package com.xinghua24.bookmarkbe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
    @GetMapping("")
    public String getBookmarks() {
        return "Bookmarks";
    }
}
