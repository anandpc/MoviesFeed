package io.github.anandpc.moviesfeed.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Guid")
public class Guid
{
    @Element(name = "content")
    private String content;

    @Element(name = "isPermaLink")
    private String isPermaLink;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getIsPermaLink ()
    {
        return isPermaLink;
    }

    public void setIsPermaLink (String isPermaLink)
    {
        this.isPermaLink = isPermaLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", isPermaLink = "+isPermaLink+"]";
    }
}
