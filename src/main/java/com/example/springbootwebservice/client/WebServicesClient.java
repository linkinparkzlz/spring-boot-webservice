package com.example.springbootwebservice.client;

import com.example.springbootwebservice.domain.User;
import com.example.springbootwebservice.domain.UserIdRequest;
import com.example.springbootwebservice.domain.UserResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.time.Instant;

public class WebServicesClient {


    public static void main(String[] args) {


        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();


        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();

        jaxb2Marshaller.setClassesToBeBound(UserIdRequest.class,UserResponse.class, User.class);

        webServiceTemplate.setMarshaller(jaxb2Marshaller);

        webServiceTemplate.setUnmarshaller(jaxb2Marshaller);

        //  构造SOAP请求

        UserIdRequest userIdRequest = new UserIdRequest();

        userIdRequest.setUserId(1L);
        userIdRequest.setTimestamp(Instant.now().toEpochMilli());


        UserResponse userResponse = (UserResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/web-services/user", userIdRequest);


        System.out.println(userIdRequest);

    }


}
















































