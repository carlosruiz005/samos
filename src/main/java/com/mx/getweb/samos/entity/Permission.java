package com.mx.getweb.samos.entity;

import java.util.Objects;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "cursivas_permisos")
@Data
public class Permission {

    private String permissionName;

}
