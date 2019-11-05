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
        return 0;
    }

    @Override
    public boolean rename(String newName) throws Exception {
        return false;
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
