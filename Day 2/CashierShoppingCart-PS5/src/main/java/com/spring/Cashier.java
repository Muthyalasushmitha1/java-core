package com.spring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Cashier {
	    private String fileName;
	    private String path;
	    private BufferedWriter writer;
	 
	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }
	 
	    public void setPath(String path) {
	        this.path = path;
	    }
	 
	    public void openFile() throws IOException {
	        File targetDir = new File(path);
	        if (!targetDir.exists()) {
	            targetDir.mkdirs();
	        }
	        File checkoutFile = new File(path, fileName + ".txt");
	        if (!checkoutFile.exists()) {
	            checkoutFile.createNewFile();
	        }
	        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
	    }
	 
	    public void checkout(ShoppingCart cart) throws IOException {
	        writer.write(new java.util.Date() + "\t" + cart.getItems() + "\r\n");
	        writer.flush();
	    }
	 
	    public void closeFile() throws IOException {
	        writer.close();
	    }

		@Override
		public String toString() {
			return "Cashier [fileName=" + fileName + ", path=" + path + ", writer=" + writer + "]";
		}
	    
}
	

