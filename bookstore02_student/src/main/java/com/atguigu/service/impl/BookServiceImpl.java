package com.atguigu.service.impl;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBook(String booktitle) {
        return bookDao.getBook(booktitle);
    }

    @Override
    public int saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    @Override
    public int deleteBookById(String bookId) {
        return bookDao.deleteBookById(bookId);
    }

    @Override
    public Book getBookById(String bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    public int updateBookById(Book book) {
        return bookDao.updateBookById(book);
    }

    @Override
    public Page<Book> getBooksByPage(String pageNo) {
        Page<Book> page = new Page<>();
        // support page number is null
        int pN = 1;
        try {
            pN = Integer.parseInt(pageNo);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        page.setPageNo(pN);
        return bookDao.getBooksByPage(page);
    }

    @Override
    public Page<Book> getBooksByPageAndPrice(String pageNo, String min, String max) {
        Page<Book> page = new Page<>();
        // support page number is null
        int pN = 1;
        double mn = 0.0;
        double mx = Double.MAX_VALUE;
        try {
            if (min == "") {
                min = "0";
            }
            if (max == "") {
                max = String.valueOf(Double.MAX_VALUE);
            }
            pN = Integer.parseInt(pageNo);
            mn = Double.parseDouble(min);
            mx = Double.parseDouble(max);
            if (Double.compare(mn, mx) > 0) {
                double temp = mn;
                mn = mx;
                mx = temp;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        page.setPageNo(pN);
        return bookDao.getBooksByPageAndPrice(page, mn, mx);
    }
}
