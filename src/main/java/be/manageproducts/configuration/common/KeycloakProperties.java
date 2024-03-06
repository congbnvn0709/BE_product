package be.manageproducts.configuration.common;

import lombok.RequiredArgsConstructor;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@RequiredArgsConstructor
//@ComponentScan
public class KeycloakProperties {

//    private final KeycloakSpringBootProperties keycloakSpringBootProperties;
//
//    public Keycloak getKeycloakInstance(String username, String password) {
//        return Keycloak.getInstance(
//                keycloakSpringBootProperties.getAuthServerUrl(),
//                keycloakSpringBootProperties.getRealm(),
//                username,
//                password,
//                keycloakSpringBootProperties.getResource(),
//                keycloakSpringBootProperties.getCredentials().get("secret").toString());
//    }

}
