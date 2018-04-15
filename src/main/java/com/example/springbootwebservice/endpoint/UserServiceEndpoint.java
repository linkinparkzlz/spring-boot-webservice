package com.example.springbootwebservice.endpoint;

import com.example.springbootwebservice.domain.User;
import com.example.springbootwebservice.domain.UserIdRequest;
import com.example.springbootwebservice.domain.UserResponse;
import com.example.springbootwebservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.Instant;

@Endpoint
public class UserServiceEndpoint {


    @Autowired
    private UserRepository userRepository;


    @PayloadRoot(namespace = "http://segmentfault.com/schemas", localPart = "UserIdRequest")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload UserIdRequest userIdRequest) {

        Long userId = userIdRequest.getUserId();

        System.out.println("web service请求的时间 : " + Instant.ofEpochMilli(userId));


        User user = userRepository.findById(userId);

        UserResponse userResponse = new UserResponse();

        userResponse.setUser(user);

        userResponse.setTimestamp(Instant.now().toEpochMilli());

        return userResponse;
    }


}
