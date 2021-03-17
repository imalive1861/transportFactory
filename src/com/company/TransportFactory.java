package com.company;

import com.company.transport.*;

public class TransportFactory {
    public Transport getTransport(int numberOfWheels) {
        switch (numberOfWheels) {
            case 1:
                return new Monocycle();
            case 2:
                return new Motorcycle();
            case 3:
                return new Tricycle();
            case 4:
                return new Quadricycle();
            default:
                return new Default(numberOfWheels);
        }
    }
}
