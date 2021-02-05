package com.boot.domain.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

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

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank( message = "Creation Date Required")
    @Column( name = "CreateDate")
    protected Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank( message = "Update Date Required")
    @Column( name = "UpdateDate")
    protected Date updateDate;
}
