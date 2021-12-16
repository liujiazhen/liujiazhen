public class Test {
    public static void method(String param) {
        byte var2 = -1;
        switch(param.hashCode()) {
            case 114215:
                if (param.equals("param")) {
                    var2 = 0;
                }
                break;
            case 3392903:
                if (param.equals("String")) {
                    var2 = 1;
                }
                break;
            case 1232141:
                if (param.equals("null")) {
                    var2 = 2;
                }
        }

        switch(var2) {
            case 0:
                System.out.println("print param");
                break;
            case 1:
                System.out.println("print String");
                break;
            case 2:
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    public static void main(String[] args) {

    }
}
