package spring_01.Intro;

public class App02 {
    int id;
    String name;
    App03 info;

    public void setInfo(App03 info) {
        this.info = info;
    }

    public App02() {
    }

    public App02(int id, String name,App03 info){
        this.id = id;
        this.name = name;
        this.info = info;

    }

    public void setId(int id) {
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "App02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info=" + info +
                '}';
    }


}

