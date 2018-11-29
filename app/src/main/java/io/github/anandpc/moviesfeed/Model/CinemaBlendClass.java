package io.github.anandpc.moviesfeed.Model;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CinemaBlendClass")
public class CinemaBlendClass
{
    @Element(name = "rss")
    private Rss rss;

    public Rss getRss ()
    {
        return rss;
    }

    public void setRss (Rss rss)
    {
        this.rss = rss;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rss = "+rss+"]";
    }
}