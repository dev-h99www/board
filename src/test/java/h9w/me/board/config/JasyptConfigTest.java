package h9w.me.board.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@PropertySource("classpath:properties/jasypt-env.properties")
class JasyptConfigTest {

    @Value("${jasypt.password}")
    public String appEn;

    @Test
    void jasypt() {
        String url = "url";
        String user = "user";
        String password = "pwd";

        System.out.println("=========jasyptEncoding Test=========");
        System.out.println(jasyptEncoding(url));
        System.out.println(jasyptEncoding(user));
        System.out.println(jasyptEncoding(password));
        System.out.println("=========jasyptEncoding Test=========");

    }

    public String jasyptEncoding(String value) {
        StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
        enc.setAlgorithm("PBEWithMD5AndDES");
        enc.setPassword(appEn);

        return enc.encrypt(value);
    }


}