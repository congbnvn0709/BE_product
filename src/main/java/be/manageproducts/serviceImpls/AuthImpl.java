package be.manageproducts.serviceImpls;

import be.manageproducts.ResponseData;
import be.manageproducts.configuration.common.KeycloakProperties;
import be.manageproducts.dto.auth.request.LoginRequest;
import be.manageproducts.services.AuthService;
import be.manageproducts.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthImpl implements AuthService {
//    private final KeycloakProperties keycloakConfiguration;
    @Override
    public ResponseData login(LoginRequest loginRequest) {
        if(StringUtils.isNullOrEmpty(loginRequest.getUsername()) || StringUtils.isNullOrEmpty(loginRequest.getPassword())){

        }
        return null;
    }
}
