interface Test_Interface {
    String name = "hello";//public static final
    String getName();//abstract
}

class T_final{
    public static final int num = 10;
}

class Test_T_final extends T_final{
    public static void main(String[] args) {
        T_final tt = new Test_T_final();
        System.out.println(tt.num);
    }
}
