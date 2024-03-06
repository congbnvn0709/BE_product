package be.manageproducts;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

@SpringBootApplication
public class ManageProductsApplication {

    public static void main(String[] args) {
        ClassLoader classLoader = ManageProductsApplication.class.getClassLoader();
        FileInputStream serviceAccount = null;
        try {
            File file = new File(Objects.requireNonNull(classLoader.getResource("storeimageKey.json")).getFile());
            serviceAccount = new FileInputStream(file.getAbsolutePath());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("storeimage-3237b.appspot.com")
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SpringApplication.run(ManageProductsApplication.class, args);
    }

}
