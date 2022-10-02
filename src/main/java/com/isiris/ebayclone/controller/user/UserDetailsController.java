package com.isiris.ebayclone.controller.user;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Response;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserDetailsController {

    private final RealmResource realmResource;

    @GetMapping
    public ResponseEntity<UserRepresentation> getUser(Principal principal) {
        return ResponseEntity.ok(realmResource.users().get(principal.getName()).toRepresentation());
    }

    @GetMapping("/all")
    @RolesAllowed("admin")
    public ResponseEntity<List<UserRepresentation>> getAllUsers() {
        return ResponseEntity.ok(realmResource.users().list());
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("admin")
    public ResponseEntity<Response> deleteUsers(@PathVariable String id) {
        return ResponseEntity.ok(realmResource.users().delete(id));
    }
}
