package Helpers.Enums.Statics;

import Selenium.Base;

public enum Message {
    DROPDOWN_NOTFOUND("Brak wyników", "Not found");

    public final String pl;
    public final String en;

    Message(String pl, String en) {
        this.pl = pl;
        this.en = en;
    }
    public String current(){
        return Base.config.getLanguage().equals("pl") ? pl : en;
    }
}
