package com.lino.hruser.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_Role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    public Role() {
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
