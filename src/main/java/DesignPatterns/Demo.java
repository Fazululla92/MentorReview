package DesignPatterns;

abstract class PhoneCameraApp {

    protected ShareStrategy shareStrategy;

    public void setShareStrategy(ShareStrategy shareStrategy) {
        this.shareStrategy = shareStrategy;
    }

    public void takePhoto() {
        System.out.println("Photo taken");
    }

    public void savePhoto() {
        System.out.println("Photo saved");
    }
    public void sharePhoto(String photoPath) {
        if (shareStrategy == null) {
            throw new IllegalStateException("Share strategy not set");
        }
        shareStrategy.share(photoPath);
    }
    public abstract void editPhoto();
}

class BasicCameraApp extends PhoneCameraApp {

    @Override
    public void editPhoto() {
        System.out.println("Basic editing features: crop only");
    }
}

class CameraPlusApp extends PhoneCameraApp {

    @Override
    public void editPhoto() {
        System.out.println("Advanced editing: filters + crop + brightness");
    }
}

public class Demo {
    public static void main(String[] args) {

        PhoneCameraApp app = new CameraPlusApp();

        app.takePhoto();
        app.editPhoto();
        app.savePhoto();

        // User decides HOW to share at runtime
        app.setShareStrategy(new SocialMediaShareStrategy());

        app.sharePhoto("photo1.jpg");
    }
}