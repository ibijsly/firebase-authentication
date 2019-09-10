package com.esl.auth.service;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final FirebaseOptions firebaseOptions;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(FirebaseOptions firebaseOptions) {
        this.firebaseOptions = firebaseOptions;
    }

    public void addUser() throws FirebaseAuthException {
        CreateRequest createRequest = new CreateRequest();
        createRequest.setEmail("ibijsly@yahoo.com");
        createRequest.setEmailVerified(false);
        createRequest.setDisabled(false);
        createRequest.setPassword("Welcome");
        createRequest.setPhoneNumber("+2347068476643");
        createRequest.setDisplayName("Ibijola Test");

        UserRecord userRecord = FirebaseAuth.getInstance().createUser(createRequest);
        System.out.println(userRecord.getUid());
        logger.info("User Record: {}", userRecord);
    }
}
