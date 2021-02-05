package com.boot.domain.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor @Setter @Getter
public class CoreBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank( message = "dateCaptured Required")
    @Column( name = "DateCaptured")
    protected Date dateCaptured;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank( message = "Update Date Required")
    @Column( name = "UpdateDate")
    protected Date updateDate;
}
