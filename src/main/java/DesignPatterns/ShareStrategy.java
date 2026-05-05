package DesignPatterns;

public interface ShareStrategy {
    void share(String photoPath);
}

class EmailShareStrategy implements ShareStrategy {

    @Override
    public void share(String photoPath) {
        System.out.println("Sharing photo via EMAIL: " + photoPath);
    }
}

class TextShareStrategy implements ShareStrategy {

    @Override
    public void share(String photoPath) {
        System.out.println("Sharing photo via TEXT: " + photoPath);
    }
}

class SocialMediaShareStrategy implements ShareStrategy {

    @Override
    public void share(String photoPath) {
        System.out.println("Sharing photo via SOCIAL MEDIA: " + photoPath);
    }
}