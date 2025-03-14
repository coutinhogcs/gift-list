package com.example.giftlist.entity;
//
//id: Identificador único da lista.
//user_id: Chave estrangeira que referencia o usuário que criou a lista.
//title: Título da lista (ex: "Chá de Cozinha", "Aniversário", "Casamento").
//description: Descrição opcional da lista.
//creation_date: Data de criação da lista.
//        event_date: Data


import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "list")
public class ListGift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name ="description", nullable = false)
    private String description;

    @Column(name = "date")
    private LocalDate creationDate;


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
