package com.company;

public class File extends FileSystem {


    private FileSystem mParent;

    public File(String name, FileSystem parent) throws Exception {
        super(name);

        if (parent == null)
            throw new Exception("parent cannot be null");

        if (parent instanceof File)
            throw new Exception("file cannot be a parent");

        this.mParent = parent;
    }


    public FileSystem getParent() {
        return mParent;
    }

    @Override
    public long getSize() {
        return 100;
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
}
