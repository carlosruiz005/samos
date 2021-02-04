package com.mx.getweb.samos.entity;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "cursivas_usuarios")
@Data
public class User {

    @Id
    private String id;
    private String username;
    private String name;
    private String email;
    private List<Role> roles;
    private boolean active;

}
