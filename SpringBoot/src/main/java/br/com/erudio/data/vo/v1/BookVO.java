package br.com.erudio.data.vo.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "author", "launch_date", "price", "title"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {


    private static final long serialVersionUID = -7548976478221436686L;

    @Mapping("id")
    @JsonProperty("id")
    private Long Key;
    private String author;
    private Date launch_date;
    private double price;
    private String title;

    public BookVO(){}

    public Long getKey() {
        return Key;
    }

    public void setKey(Long key) {
        Key = key;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        if (!(o instanceof BookVO bookVO)) return false;
        if (!super.equals(o)) return false;

        if (Double.compare(bookVO.price, price) != 0) return false;
        if (!Objects.equals(Key, bookVO.Key)) return false;
        if (!Objects.equals(author, bookVO.author)) return false;
        if (!Objects.equals(launch_date, bookVO.launch_date)) return false;
        return Objects.equals(title, bookVO.title);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (Key != null ? Key.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (launch_date != null ? launch_date.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
