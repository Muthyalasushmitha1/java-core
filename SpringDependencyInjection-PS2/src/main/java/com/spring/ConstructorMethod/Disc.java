package com.spring.ConstructorMethod;


public class Disc extends Product {
    private String storageCapacity;
    
 
    
    public Disc(String name, double price, String storageCapacity) {
        super(name, price);
        this.storageCapacity = storageCapacity;
    }


    public String getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(String storageCapacity) {
		this.storageCapacity = storageCapacity;
	}


	@Override
	public String toString() {
		return "Disc [storageCapacity=" + storageCapacity + ", getStorageCapacity()=" + getStorageCapacity()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", hashCode()=" + hashCode() +  "]";
	}

	
}

