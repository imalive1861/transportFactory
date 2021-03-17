package com.company.transport;

import com.company.Utils;

public class Default implements Transport {
    private int numberOfWheels;
    private String transportName;
    private int fuelTankVolume;
    private int fuelConsumptionPer100Km;

    public Default() {
    }

    public Default(int numberOfWheels) {
        setParameters(numberOfWheels, 10, 100, 100, 500, "Z");
    }

    public void setParameters(int numberOfWheels,
                              int fuelConsumptionMinRange,
                              int fuelConsumptionMaxRange,
                              int fuelTankVolumeMinRange,
                              int fuelTankVolumeMaxRange,
                              String namePrefix) {
        setNumberOfWheels(numberOfWheels);
        setTransportName(namePrefix + Utils.generateTransportName());
        setFuelConsumptionPer100Km(Utils.getRandomNumberInRange(fuelConsumptionMinRange, fuelConsumptionMaxRange));
        setFuelTankVolume(Utils.getRandomNumberInRange(fuelTankVolumeMinRange, fuelTankVolumeMaxRange));
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public int getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(int fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }

    public int getFuelConsumptionPer100Km() {
        return fuelConsumptionPer100Km;
    }

    public void setFuelConsumptionPer100Km(int fuelConsumptionPer100Km) {
        this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
    }
}
