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
import java.util.Map;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @ResponseBody
    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public ResponseEntity<UserTokenDto> loginAdmin(@RequestBody UserDto userDto)  {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                        (userDto.login(), userDto.password()));
        String login = authentication.getName();
        User user = new User(login, userDto.password());
        String token = jwtUtil.createToken(user, "ADMIN");
        UserTokenDto loginRes = new UserTokenDto(login,token);

        return ResponseEntity.ok(loginRes);
    }

    @ResponseBody
    @RequestMapping(value = "/driver",method = RequestMethod.POST)
    public ResponseEntity<UserTokenDto> loginDriver(@RequestBody UserDto userDto)  {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                        (userDto.login(), userDto.password()));
        String login = authentication.getName();
        User user = new User(login, userDto.password());
        String token = jwtUtil.createToken(user, "DRIVER");
        UserTokenDto loginRes = new UserTokenDto(login,token);

        return ResponseEntity.ok(loginRes);
    }

    @ResponseBody
    @RequestMapping(value = "/client",method = RequestMethod.POST)
    public ResponseEntity<UserTokenDto> loginClient(@RequestBody UserDto userDto)  {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                        (userDto.login(), userDto.password()));
        String login = authentication.getName();
        User user = new User(login, userDto.password());
        String token = jwtUtil.createToken(user, "CLIENT");
        UserTokenDto loginRes = new UserTokenDto(login,token);

        return ResponseEntity.ok(loginRes);
    }

    @RequestMapping(value = "/get-credentials",method = RequestMethod.GET)
    public ResponseEntity<Map<String,String>> getCredentials(@RequestHeader("Authorization") String token)  {
        Map<String,String> res = new HashMap<>();
        res.put("login",jwtUtil.getLogin(token));
        res.put("role", jwtUtil.getRole(token));
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/get-role",method = RequestMethod.GET)
    public ResponseEntity<Map<String,String>> getRole(@RequestHeader("Authorization") String token)  {
        Map<String,String> res = new HashMap<>();
        res.put("role",jwtUtil.getRole(jwtUtil.parseJwtClaims(token)));
        return ResponseEntity.ok(res);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String,String>> handleBadCredentialsException(BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Invalid login or password"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Invalid login or password"));
    }
}