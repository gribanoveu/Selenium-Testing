package selenium.enums;

public enum RemoteStand {
    REMOTE_URL("http://youip:4444");

    private final String remoteUrl;

    RemoteStand(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    /** Получить имя браузера в виде строки */
    @Override
    public String toString() {
        return String.valueOf(this.remoteUrl);
    }

    /** Возврат значения по строковому значению константы */
    public static RemoteStand fromString(String remoteUrl) {
        if (remoteUrl != null) {
            for(RemoteStand remoteStand : RemoteStand.values()) {
                if (remoteUrl.equalsIgnoreCase(remoteStand.remoteUrl)) {
                    return remoteStand;
                }
            }
        }
        return null;
    }

    /** Получить удаленный стенд в виде строки  */
    public String getRemoteUrl() {
        return this.remoteUrl;
    }
}
