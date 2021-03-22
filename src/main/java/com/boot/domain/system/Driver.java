package com.boot.domain.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
@NoArgsConstructor @Setter @Getter
public class Driver extends Person{
}
