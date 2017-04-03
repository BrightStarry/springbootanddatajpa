package com.zx.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by 97038 on 2017-04-03.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 4)
    private String cupSize;
    @Min(value = 18,message = "未成年")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Girl() {
    }
}
