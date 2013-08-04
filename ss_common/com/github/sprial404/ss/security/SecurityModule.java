package com.github.sprial404.ss.security;

import net.minecraft.nbt.NBTTagList;

public abstract class SecurityModule {

    protected SecurityModule() { }
    
    public abstract void writeToNBT(NBTTagList par1NBTTagList);
    
    public abstract void readFromNBT(NBTTagList par1NBTTagList);
}
