package com.example.mycafe.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name="category_idx", nullable = false)
    private Long categoryIdx;

    @Column(name="menu_name", nullable = false)
    private String menuName;

    @Column(name="comment")
    private String comment;

    @Column(name="use_yn", columnDefinition = "boolean default true")
    private boolean useYN;

    @CreationTimestamp
    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    public Menu(Long categoryIdx, String menuName, String comment) {
        this.categoryIdx = categoryIdx;
        this.menuName = menuName;
        this.comment = comment;
    }
}
