package com.company;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Volume {
    //
    private List<FileSystem> mFileAndFolderList;
    private FileSystem mParent;

    public Folder(String name, FileSystem parent) throws Exception {
        super(name);
        //
        if (parent == null)
            throw new Exception("parent cannot be null");
        //
        if (parent instanceof File)
            throw new Exception("File cannot be a parent");
        //
        mFileAndFolderList = new ArrayList<>();
        //
        this.mParent = parent;
    }

    private static User getCurrentUser() {
        return new User(2, "hamed");
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

        if (mParent instanceof Folder) {
            for (FileSystem fileSystem : ((Folder) mParent).getFileAndFolderList())
                if (fileSystem.getName().toLowerCase().equals(newName.toLowerCase()))
                    throw new Exception("this name is duplicated");
        } else if (mParent instanceof Volume) {
            for (FileSystem fileSystem : ((Volume) mParent).getFileAndFolderList())
                if (fileSystem.getName().toLowerCase().equals(newName.toLowerCase()))
                    throw new Exception("this name is duplicated");
        }
        System.out.println("folder successfully renamed");
        return super.rename(newName);
    }

    public boolean add(FileSystem fileOrFolder) throws Exception {
        for (FileSystem fileSystem1 :
                mFileAndFolderList) {
            if (fileSystem1.getName().equals(fileOrFolder.getName())) {
                throw new Exception("this name is duplicated");
            }
        }
        mFileAndFolderList.add(fileOrFolder);
        mParent = this;
        return true;
    }


}
