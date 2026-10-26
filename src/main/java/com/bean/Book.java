package com.bean;

public class Book {
    private Integer id;
    private String bookname;
    private String author;
    // 删除原来的price，新增status
    private String status;

    public Book() {
    }

    // 带参构造，去掉price，加上status
    public Book(Integer id, String bookname, String author, String status) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // status的get、set
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
