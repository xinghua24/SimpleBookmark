package com.xinghua24.bookmarkbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xinghua24.bookmarkbe.entity.Bookmark;

public interface BookmarkListRepository extends JpaRepository<Bookmark, Long>{

}
