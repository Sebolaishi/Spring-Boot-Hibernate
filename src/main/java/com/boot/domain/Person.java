package com.boot.domain;

import com.boot.domain.base.CoreBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor @Setter @Getter
public class Person extends CoreBaseEntity implements Serializable {
}
