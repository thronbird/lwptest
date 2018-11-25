package other;

/**
 * @author liwanping
 * @date 2018-10-25
 */
public class EnumEntity {

    private enum State{

        OPEN{
            @Override
            void proceed(EnumEntity enumEntity) {
                enumEntity.state = PENDING_APPROVAL;
            }
            @Override
            void notifyMerchant(EnumEntity enumEntity) {

            }

        },
        PENDING_APPROVAL{
            void proceed(EnumEntity enumEntity) {
                enumEntity.state = APPROVED;
            }
            @Override
            void notifyMerchant(EnumEntity enumEntity) {

            }
        },
        APPROVED{
            void proceed(EnumEntity enumEntity) {
                enumEntity.state = CLOSED;
                sendNotifcation(enumEntity);
            }
            @Override
            void notifyMerchant(EnumEntity enumEntity) {

            }
        },
        CLOSED{
            void proceed(EnumEntity enumEntity) {
                throw new RuntimeException("EnumEntity already closed");
            }
            @Override
            void notifyMerchant(EnumEntity enumEntity) {

            }
        };

        abstract void proceed(EnumEntity enumEntity);

        abstract void notifyMerchant(EnumEntity enumEntity);
    }

    private State state = State.OPEN;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void proceed(){
        this.state.proceed(this);
    }

    private static void sendNotifcation(EnumEntity enumEntity){}


    public static void main (String[] args ){
        EnumEntity entity = new EnumEntity();
        System.out.println(entity.getState());
        entity.proceed();
        System.out.println(entity.getState());
        entity.proceed();
        System.out.println(entity.getState());
        entity.proceed();
        System.out.println(entity.getState());
    }
}
