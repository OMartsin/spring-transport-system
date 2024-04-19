package com.example.transportsystem.controller;

import com.example.transportsystem.dto.UserTokenDto;
import com.example.transportsystem.dto.driver.UserDto;
import com.example.transportsystem.model.User;
import com.example.transportsystem.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @ResponseBody
    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public ResponseEntity loginAdmin(@RequestBody UserDto userDto)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                            (userDto.login(), userDto.password()));
            String login = authentication.getName();
            User user = new User(login, userDto.password());
            String token = jwtUtil.createToken(user, "ADMIN");
            UserTokenDto loginRes = new UserTokenDto(login,token);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>().put("message","Invalid username or password"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>().put("message",e.getMessage()));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/driver",method = RequestMethod.POST)
    public ResponseEntity loginDriver(@RequestBody UserDto userDto)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                            (userDto.login(), userDto.password()));
            String login = authentication.getName();
            User user = new User(login, userDto.password());
            String token = jwtUtil.createToken(user, "DRIVER");
            UserTokenDto loginRes = new UserTokenDto(login,token);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>().put("message","Invalid username or password"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>().put("message",e.getMessage()));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/client",method = RequestMethod.POST)
    public ResponseEntity loginClient(@RequestBody UserDto userDto)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                            (userDto.login(), userDto.password()));
            String login = authentication.getName();
            User user = new User(login, userDto.password());
            String token = jwtUtil.createToken(user, "CLIENT");
            UserTokenDto loginRes = new UserTokenDto(login,token);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>().put("message","Invalid username or password"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>().put("message",e.getMessage()));
        }
    }
}