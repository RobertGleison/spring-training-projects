package crud.application.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int status;

    private OrderStatus(int value){
        this.status = value;
    }

    public int getStatus() {
        return status;
    }

    public static OrderStatus valueOf(int code){
        for (OrderStatus o : OrderStatus.values()){
            if(o.getStatus() == code){
                return o;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
