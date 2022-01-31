package com.example.cryptoapp.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coin_to_user")
public class UserCoins {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;
    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User user;
    @Column(name = "registration_price")
    private double registrationPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserCoins userCoins = (UserCoins) o;
        return id != null && Objects.equals(id, userCoins.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}