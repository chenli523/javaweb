package com.atguigu.dao;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

import java.util.List;

public interface BookDao {
//    select id,title,author,price,stock,img_path from books
    public List<Book> getAllBooks();
    public Book getBook(String booktitle);
    public int saveBook(Book book);
    public int deleteBookById(String bookId);
    public Book getBookById(String bookId);
    public int updateBookById(Book book);
    public int updateBookById(int stock, int sales, int id);
    public Page<Book> getBooksByPage(Page<Book> page);
    public Page<Book> getBooksByPageAndPrice(Page<Book> page, double min, double max);
}
