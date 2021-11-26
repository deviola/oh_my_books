package com.app.ohmybooks.component.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    protected Long id;

    @Column(name = "`createdAt`")
    protected OffsetDateTime createdAt;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @PrePersist
    void setCreatedAt(){
        if(this.createdAt == null)
            this.setCreatedAt(OffsetDateTime.now());
    }

}
