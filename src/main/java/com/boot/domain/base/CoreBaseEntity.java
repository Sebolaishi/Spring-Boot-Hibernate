package com.boot.domain.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Parent entity that will have all entities common fields
 */
@MappedSuperclass
@NoArgsConstructor @Setter @Getter
public class CoreBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column( name = "CreateDate", nullable = false)
    protected LocalDateTime createDate;

    @Column( name = "UpdateDate", nullable = false)
    protected LocalDateTime updateDate;
}
