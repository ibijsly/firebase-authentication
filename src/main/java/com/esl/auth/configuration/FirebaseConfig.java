package com.esl.auth.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseOptions firebaseOptions() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("configKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bookit-ce8ed.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        return options;
    }
}
