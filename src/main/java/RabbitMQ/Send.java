package RabbitMQ;

import com.rabbitmq.client.*;


public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("192.168.7.83");
        factory.setPort(5672);
        factory.setUsername("cif");
        factory.setPassword("cif");
        factory.setVirtualHost("/cif");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        for(int i = 0; i < 2;i++){
            String message = "6456467567685678";
          //  message = message + "[[[" + i + "]]]";
            message = message + "[[[" + i + "]]]";
            channel.basicPublish("cif_x_phoneUnbind", "cif_q_phoneUnbind", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }

        channel.close();
        connection.close();
    }
}
