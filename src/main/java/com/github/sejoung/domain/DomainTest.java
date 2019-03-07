package com.github.sejoung.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
@ToString
@Entity
public class DomainTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime createDateTime;

    @Column(nullable = false)
    private LocalDateTime updateDateTime;

    @PrePersist
    private void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.setCreateDateTime(now);
        this.setUpdateDateTime(now);
    }

    @PreUpdate
    private void preUpdate(){
        LocalDateTime now = LocalDateTime.now();
        this.setUpdateDateTime(now);
    }

    @Builder
    private DomainTest(String title) {
        this.title = title;
    }
}
