package io.github.anandpc.moviesfeed.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Enclosure")
public class Enclosure
{
    @Element(name = "title")
    private String length;

    @Element(name = "type")
    private String type;

    @Element(name = "url")
    private String url;

    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [length = "+length+", type = "+type+", url = "+url+"]";
    }
}
