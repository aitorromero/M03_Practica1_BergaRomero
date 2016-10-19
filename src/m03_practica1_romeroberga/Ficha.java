package m03_practica1_romeroberga;

public class Ficha {
    int num1;
    int num2;

    public Ficha(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    public void cambioOrientacion(Ficha ficha){
        int aux=ficha.getNum1();
        ficha.setNum1(ficha.getNum2());
        ficha.setNum2(aux);
    }
    
    @Override
    public String toString() {
        return "{" + num1 + " | " + num2 + '}';
    }
    
    
}

