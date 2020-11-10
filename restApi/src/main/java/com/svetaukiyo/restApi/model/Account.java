package com.svetaukiyo.restApi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "ACCOUNT")
public class Account implements Serializable, Comparable<Account> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    private Boolean status;

    @Column
    private Integer active;

    @Column
    private String role = "";

    @Column
    private String permission = "";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "follower_id")
    private Follower follower;

    public List<String> getPermissionList() {
        if (this.permission.length() > 0) {
            return Arrays.asList(this.permission.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getRoleList() {
        if (this.role.length() > 0) {
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }

    @Override
    public int compareTo(Account account) {
        return this.getId().compareTo(account.id);
    }
}
