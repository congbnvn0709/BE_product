package be.manageproducts.controllers.auth;

import be.manageproducts.ResponseData;
import be.manageproducts.dto.auth.request.LoginRequest;
import be.manageproducts.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("v1/login")
    public ResponseData login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
