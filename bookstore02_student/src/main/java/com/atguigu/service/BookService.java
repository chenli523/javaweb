package com.atguigu.service;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book getBook(String booktitle);
    public int saveBook(Book book);
    public int deleteBookById(String bookId);
    public Book getBookById(String bookId);
    public int updateBookById(Book book);
    public Page<Book> getBooksByPage(String pageNo);
    public Page<Book> getBooksByPageAndPrice(String pageNo, String min, String max);
}
