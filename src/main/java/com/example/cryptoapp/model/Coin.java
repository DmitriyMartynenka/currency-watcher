package com.example.cryptoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coin")
public class Coin {

    @Id
    private Integer id;
    private String symbol;
    private double price;

    @JsonIgnore
    @OneToMany(mappedBy = "coin")
    @ToString.Exclude
    private Set<UserCoins> userCoins = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Coin coin = (Coin) o;
        return id != null && Objects.equals(id, coin.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
