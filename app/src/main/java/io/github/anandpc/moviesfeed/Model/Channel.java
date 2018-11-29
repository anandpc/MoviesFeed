package io.github.anandpc.moviesfeed.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Channel")
public class Channel
{
    @Element(name = "title")
    private String title;

    @Element(name = "description")
    private String description;

    @Element(name = "docs")
    private String docs;

    @Element(name = "link")
    private String link;

    @Element(name = "lastBuildDate")
    private String lastBuildDate;

    @Element(name = "item")
    private Item[] item;

    @Element(name = "generator")
    private String generator;

    @Element(name = "language")
    private String language;

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

    public String getDocs ()
    {
        return docs;
    }

    public void setDocs (String docs)
    {
        this.docs = docs;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getLastBuildDate ()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate (String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public Item[] getItem ()
    {
        return item;
    }

    public void setItem (Item[] item)
    {
        this.item = item;
    }

    public String getGenerator ()
    {
        return generator;
    }

    public void setGenerator (String generator)
    {
        this.generator = generator;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", description = "+description+", docs = "+docs+", link = "+link+", lastBuildDate = "+lastBuildDate+", item = "+item+", generator = "+generator+", language = "+language+"]";
    }
}

