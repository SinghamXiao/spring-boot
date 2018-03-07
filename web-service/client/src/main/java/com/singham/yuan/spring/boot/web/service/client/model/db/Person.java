package com.singham.yuan.spring.boot.web.service.client.model.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person", indexes = {
        @Index(columnList = "id", name = "id"),
        @Index(columnList = "name", name = "name")})
public class Person {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createTime = new Date();

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastUpdateTime = createTime;

    public Person(String name) {
        this.name = name;
    }

}
