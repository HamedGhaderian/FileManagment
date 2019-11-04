package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here


        Volume volume = new Volume("v1");
        Folder folder = new Folder("fo1",volume);
        Folder folder2 = new Folder("fo2",volume);
        volume.add(folder);
        volume.add(folder2);
        File file = new File("f1",volume);
        volume.add(file);

        folder.rename("fo1");

    }
}
