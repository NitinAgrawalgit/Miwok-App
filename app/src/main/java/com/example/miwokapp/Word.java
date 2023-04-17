package com.example.miwokapp;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageId = NO_IMAGE_PROVIDED;
    private static final int NO_AUDIO_PROVIDED = -1;

    private int mAudioId = NO_AUDIO_PROVIDED;

    public Word(String miwokTranslation, String defaultTranslation){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(String miwokTranslation, String defaultTranslation, int AudioId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioId = AudioId;
    }

    public Word(String miwokTranslation, String defaultTranslation, int ImageId, int AudioId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageId = ImageId;
        mAudioId = AudioId;
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

    public int getAudioId() {
        return mAudioId;
    }

    public boolean hasImage(){
        return (mImageId != NO_IMAGE_PROVIDED);
    }

    public boolean hasAudio() {
        return (mAudioId != NO_AUDIO_PROVIDED);
    }
}
