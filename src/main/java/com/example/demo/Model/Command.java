package com.example.demo.Model;

import com.example.demo.Dish;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "command", schema = "public")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "date", columnDefinition = "date")
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private LocalDate date;
    private Integer price;

    @Column(name = "dishes")
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(write = "?::dish")
    private Dish dishes;

    private Integer clientid;
}
