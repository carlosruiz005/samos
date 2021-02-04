package com.mx.getweb.samos.entity;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "cursivas_roles")
@Data
public class Role {

    private String rolename;
    private List<Permission> permissions;
}
