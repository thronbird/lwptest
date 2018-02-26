package Thread.ThreadLocal;

public class SequenceA implements Sequence{

    private static int number=0;

    public int getNumber() {
        number=number+1;
        return this.number;
    }

    public static void main (String[] args ){
        Sequence  sequence= new SequenceA();
        ClientThread cli1=new ClientThread(sequence);
        ClientThread cli2=new ClientThread(sequence);
        ClientThread cli3=new ClientThread(sequence);
        cli1.start();
        cli2.start();
        cli3.start();
    }
}
