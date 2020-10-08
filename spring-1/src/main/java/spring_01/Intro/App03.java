package spring_01.Intro;

public class App03 {
    String id;
    String location;

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public App03() {
    }

    public App03(String id, String location) {
        this.id = id;
        this.location = location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(String id) {
        this.id = id;
    }


}
