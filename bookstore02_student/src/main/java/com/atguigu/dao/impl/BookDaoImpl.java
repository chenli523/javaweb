package com.atguigu.dao.impl;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;

import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> getAllBooks() {
        String sql = "select id,title,author,price,sales, stock,img_path as imgPath from books";
        return getBeanList(sql);
    }

    @Override
    public Book getBook(String booktitle) {
        String sql = "select id,title,author,price,sales, stock,img_path as imgPath from books where title = ?";
        return getBean(Book.class, sql,booktitle);
    }

    @Override
    public int saveBook(Book book) {
        String sql = "insert into books values(null, ?, ?, ?, ?, ?, ?)";
        return update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(String bookId) {
        String sql = "delete from books where id = ?";
        return update(sql, bookId);
    }

    @Override
    public Book getBookById(String bookId) {
        String sql = "select id,title,author,price,sales, stock,img_path as imgPath from books where id = ?";
        return getBean(Book.class, sql, bookId);
    }

    @Override
    public int updateBookById(Book book) {
        String sql = "update books set title=?,author=?,price=?,sales=?, stock=?,img_path=? where id = ?";
        return update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(),book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public int updateBookById(int stock, int sales, int id) {
        String sql = "update books set stock = ?, sales = ? where id = ?";
        return update(sql, stock, sales, id);
    }

    @Override
    public int[] updateBatchBookById(Object[][] params) {
        String sql = "update books set stock = ?, sales = ? where id = ?";
        return updateBatch(sql, params);
    }

    @Override
    public Page<Book> getBooksByPage(Page<Book> page) {
        String sql1 = "select count(1) from books";
        int totalRecord = Integer.parseInt(getSingleValue(sql1) + "");
        page.setTotalRecord(totalRecord);
        page.setTotalPageNo(page.getTotalPageNo());

        String sql = "select id,title,author,price,sales, stock,img_path as imgPath from books limit ?,?";
        List<Book> allBooks = getBeanList(sql, (page.getPageNo()-1)*Page.PAGE_SIZE, Page.PAGE_SIZE);
        page.setList(allBooks);
        return page;
    }

    @Override
    public Page<Book> getBooksByPageAndPrice(Page<Book> page, double min, double max) {
        String sql1 = "select count(1) from books where price between ? and ?";
        int totalRecord = Integer.parseInt(getSingleValue(sql1, min, max) + "");
        page.setTotalRecord(totalRecord);
        page.setTotalPageNo(page.getTotalPageNo());

        String sql = "select id,title,author,price,sales, stock,img_path as imgPath from books where price between ? and ? limit ?,?";
        List<Book> allBooks = getBeanList(sql, min, max, (page.getPageNo()-1)*Page.PAGE_SIZE, Page.PAGE_SIZE);
        page.setList(allBooks);
        return page;
    }
}
