package com.singham.yuan.spring.boot.web.service.server.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "info", indexes = {
        @Index(columnList = "id", name = "id"),
        @Index(columnList = "name", name = "name")})
public class Info {

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

    public Info(String name) {
        this.name = name;
    }

}
