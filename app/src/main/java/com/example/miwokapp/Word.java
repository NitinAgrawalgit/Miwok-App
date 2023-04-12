package com.example.miwokapp;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageId = NO_IMAGE_PROVIDED;

    public Word(String miwokTranslation, String defaultTranslation){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(String miwokTranslation, String defaultTranslation, int ImageId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageId = ImageId;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageId(){
        return mImageId;
    }

    public boolean hasImage(){
        return (mImageId != NO_IMAGE_PROVIDED);
    }
}
