package duoxiancheng;

public class trainticket implements Runnable{


    public trainticket(String trainstation) {
        this.trainstation = trainstation;
    }

    public static Integer getTicket() {
        return ticket;
    }

    public static void setTicket(Integer ticket) {
        trainticket.ticket = ticket;
    }

    public String getTrainstation() {
        return trainstation;
    }

    public void setTrainstation(String trainstation) {
        this.trainstation = trainstation;
    }
    private static Integer  ticket =30;
    String trainstation ="";
    private static Integer suo=1;
    @Override
    public void run() {
        while (true){
                 synchronized (suo){
                if(ticket<=0){
                    System.out.println("票已卖完");
                    break;
                }else{
                    ticket--;
                    System.out.println("第"+(30-ticket)+"已出票,由"+this.trainstation+"出票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
        }
    }
    public static void main(String[] args) {
        for(int i=1;i<=4;i++){
            new Thread(new trainticket(i+"号售票窗口")).start();
        }

    }
}
