package spring_01.Anno_Intro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("anno_02")        //别忘加!!!
public class Anno_02 {
    @Value("SCU")
    String name;
    @Value("Suzhou")
    String location;

    @Override
    public String toString() {
        return "Annp_02{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Anno_02() {
    }

    public Anno_02(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
