package com.example.jpa.daomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 用户实体定义
 *
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/9 14:42
 */
@Entity
@Table(name = "USER2")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String address;

//    @Column
//    private Long bookid;
//
//    @OneToMany
//    @JoinColumn(name = "bookid")
//    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public Long getBookid() {
//        return bookid;
//    }
//
//    public void setBookid(Long bookid) {
//        this.bookid = bookid;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
