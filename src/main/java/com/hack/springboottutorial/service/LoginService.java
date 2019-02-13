package com.hack.springboottutorial.service;

import com.hack.springboottutorial.domain.entity.User;
import com.hack.springboottutorial.exception.UserDefineException;
import com.hack.springboottutorial.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private LoginRepository loginRepository;

    public User login(User user) {
        User user1 = loginRepository.findById(user.getId()).orElseThrow(() -> new UserDefineException(user.getId() + "의 아이디를 찾을 수 없습니다."));

        if(user.getPw().equals(user1.getPw())){
            return user1;
        }else {
            throw new UserDefineException(user.getId() + "의 비밀번호가 잘못 되었습니다.");
        }
    }

    public User signup(User user) {
        return loginRepository.save(
                loginRepository.findById(user.getId())
                        .orElseThrow(() -> new UserDefineException("아이디가 중복됩니다."))
        );
    }
}
