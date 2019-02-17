package com.andyfan.tx.models;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class User implements Serializable {

    public User(Long id, Date ctime, Date mtime, String name, Integer age, Boolean sex) {
        this.id = id;
        this.ctime = ctime;
        this.mtime = mtime;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    private Long id;

    private Date ctime;

    private Date mtime;

    private String name;

    private Integer age;

    private Boolean sex;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}