package com.spring.ConstructorMethod;

public class Battery extends Product {
    private boolean rechargeable;

    public boolean isRechargeable() {
		return rechargeable;
	}

	public void setRechargeable(boolean rechargeable) {
		this.rechargeable = rechargeable;
	}

	public Battery(String name, double price, boolean rechargeable) {
        super(name, price);
        this.rechargeable = rechargeable;
    }

	@Override
	public String toString() {
		return "Battery [rechargeable=" + rechargeable + ", isRechargeable()=" + isRechargeable() + ", getName()="
				+ getName() + ", getPrice()=" + getPrice() + ", hashCode()=" + hashCode()+ "]";
	}

    
}

