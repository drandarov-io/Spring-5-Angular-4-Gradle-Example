package angularboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("api")
public class AngularBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(AngularBootApplication.class, args);
    }

    public static final List<Hero> HEROES;

    static {
        Random r = new Random();
        final String[] NAMES = {"Mr. Nice", "Narco", "Bombasto", "Celeritas", "Magneta", "RubberMan", "Dynama",
                "Dr IQ", "Magma", "Tornado"};
        HEROES = Arrays.stream(NAMES).map(name -> new Hero(r.ints(0,20).findFirst()
                .getAsInt(), name)).collect(Collectors.toList());
    }

    @RequestMapping("/resource")
    public Greeting home() {
        Greeting greeting = new Greeting();
        greeting.setId(UUID.randomUUID().toString());
        greeting.setContent("Hello World");
        return greeting;
    }

    @RequestMapping("/heroes")
    public List<Hero> getHeroes() {
        return HEROES;
    }

}
