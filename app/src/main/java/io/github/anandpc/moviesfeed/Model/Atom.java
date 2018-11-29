package io.github.anandpc.moviesfeed.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Atom")
public class Atom {

    @Element(name = "rel")
    private String rel;

    @Element(name = "type")
    private String type;

    @Element(name = "href")
    private String href;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "ClassPojo [rel = " + rel + ", type = " + type + ", href = " + href + "]";
    }
}