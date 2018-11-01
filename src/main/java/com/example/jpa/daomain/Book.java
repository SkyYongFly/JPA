package com.example.jpa.daomain;

import javax.persistence.*;

/**
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/11/1 10:10
 */
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookid;

    @Column
    private String bookname;

    @Column
    private String description;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
