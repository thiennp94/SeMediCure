package coms309.demo2.authToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public List<Auth> getAuth() {
        return authRepository.findAll();
    }


    public void getNewCode(Auth newCode) {
    }
}
