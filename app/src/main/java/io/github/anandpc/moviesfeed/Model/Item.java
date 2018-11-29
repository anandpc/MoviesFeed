package io.github.anandpc.moviesfeed.Model;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "item",strict = false
)
public class Item
{
    @Element(name = "title",required = false)
    private String title;

    @Element(name = "description",required = false)
    private String description;

   /* @Attribute(name = "url",required = false)
    private String url;

    public String getUrl ()
    {
        return url;
    }*/

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

}