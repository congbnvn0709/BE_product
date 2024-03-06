package be.manageproducts.services;

import be.manageproducts.ResponseData;
import be.manageproducts.dto.auth.request.LoginRequest;


public interface AuthService {

    ResponseData login (LoginRequest loginRequest);
}
