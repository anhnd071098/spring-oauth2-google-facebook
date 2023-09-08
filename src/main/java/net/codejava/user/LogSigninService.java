package net.codejava.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogSigninService {
    @Autowired LogSigninRepository logSigninRepository;
    public LogSignIn saveNewLog(LogSignIn log) {
        return logSigninRepository.save(log);
    }
}
