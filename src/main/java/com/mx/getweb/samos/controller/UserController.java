package com.mx.getweb.samos.controller;

import com.mx.getweb.samos.entity.User;
import com.mx.getweb.samos.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/find/{id}")
    @ApiOperation(value = "Busca el usuario por id", notes = "User endpoint.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<User> find(@PathVariable(required = true) String id) {
        User u = this.userService.findUser(id);
        return new ResponseEntity<>(u, u == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/find")
    @ApiOperation(value = "Obtiene todos los usuarios", notes = "User endpoint.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<User>> find() {
        List<User> us = this.userService.findAll();
        return new ResponseEntity<>(us, us == null || us.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @ApiOperation(value = "Crear usuario", notes = "User endpoint.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/update")
    public ResponseEntity<User> update(User user) {
        User createdUser = this.userService.save(user);
        return new ResponseEntity<>(createdUser, createdUser == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
    }

    @ApiOperation(value = "Eliminar usuario", notes = "User endpoint.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Found"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 400, message = "Bad Request")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(User user) {
        this.userService.delete(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
