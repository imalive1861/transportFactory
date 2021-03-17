package com.company.transport;

public interface Transport {
    void setTransportName(String transportName);

    String getTransportName();

    void setNumberOfWheels(int numberOfWheels);

    int getNumberOfWheels();

    int getFuelTankVolume();

    void setFuelTankVolume(int fuelTankVolume);

    int getFuelConsumptionPer100Km();

    void setFuelConsumptionPer100Km(int fuelConsumptionPer100Km);
}
