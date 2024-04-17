package com.educandoweb2.course.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT (1),
    PAID (2),
    SHIPPED (3),
    DELIVERED (4),
    CANCELED (5);

    private int code; //atributo


    private OrderStatus (int code){ //construtor, nesse caso ele é "PRIVATE"
        this.code = code;
    }


    public int getCode() {
        return code;
    }


    public static OrderStatus valueOf (int code){
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException ("Invalid OrderStatus code");
    }
}
