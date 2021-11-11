package br.com.erudio.data.vo.v1;

import com.mysql.cj.log.Log;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BookVO implements Serializable {
    private static final long serialVersionUI = 1L;

    private Long id;
    private String author;
    private Date launch_date;
    private Double price;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookVO bookVO = (BookVO) o;
        return Objects.equals(id, bookVO.id) && Objects.equals(author, bookVO.author) && Objects.equals(launch_date, bookVO.launch_date) && Objects.equals(price, bookVO.price) && Objects.equals(title, bookVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launch_date, price, title);
    }
}
