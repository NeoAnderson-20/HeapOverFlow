package Aspectj;

public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name,Integer age) {
        System.out.println("doSome()");


    }
    public String doOthers(){
        return "qwer";
    }

    @Override
    public String doAround(String name) {

        return name;
    }
}
