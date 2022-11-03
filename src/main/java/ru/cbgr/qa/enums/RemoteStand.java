package ru.cbgr.qa.enums;

public enum RemoteStand {
    REMOTE_URL("localhost:4444", "REMOTE"),
    TEST("172.17.117.26:86/real", "TEST");

    private final String url;
    private final String standName;

    RemoteStand(String url, String standName) {
        this.url = url;
        this.standName = standName;
    }

    public String getRemoteUrl() {
        return "http://" + url + "/wd/hub/";
    }

    public String getUrl() {
        return "http://" + url + "/webui/index.html#/" ;
    }

    public String getStandName() {
        return standName;
    }

    public static String getStandUrl(String propertyName) {
    /*  если добавлено несколько стендов
      if (propertyName.equalsIgnoreCase(DEV.standName)) return StandAddress.DEV.getUrl();
      else return StandAddress.TEST.getUrl(); */

        return RemoteStand.TEST.getUrl();
    }
}
