package com.company;

import java.util.ArrayList;
import java.util.List;

public class Volume extends FileSystem {


    private List<FileSystem> mFileAndFolderList;

    public Volume(String name) {
        super(name);
        mFileAndFolderList = new ArrayList<>();
    }

    public List<FileSystem> getFileAndFolderList() {
        return mFileAndFolderList;
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystem fileSystem : mFileAndFolderList) {
            totalSize += fileSystem.getSize();
        }
        return totalSize;
    }

    @Override
    public boolean rename(String newName) throws Exception {
        if (getName().equals(newName)) {
            System.out.println("The old name and the new one are the same");
            return false;
        }
        for (Volume volume :
                getAllVolume())
            if (volume.getName().toLowerCase().equals(newName.toLowerCase()))
                throw new Exception("this name is duplicated");

        System.out.println("Volume successfully renamed");
        return super.rename(newName);
    }

    private List<Volume> getAllVolume() {
        return new ArrayList<>();
    }

    public boolean add(FileSystem fileOrFolder) throws Exception {
        for (FileSystem fileSystem1 :
                mFileAndFolderList) {
            if (fileSystem1.getName().equals(fileOrFolder.getName())) {
                throw new Exception("this name is duplicated");
            }
        }
        mFileAndFolderList.add(fileOrFolder);
        System.out.println("Successfully created");
        return true;
    }
}
