package pers.xf.learn.designpattern.mementopattern;

public class ArticleMemento {
    private String title;
    private String content;
    private String imgs;

    public ArticleMemento(String title, String content, String imgs) {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImgs() {
        return imgs;
    }

    @Override
    public String toString() {
        return  "ArticleMemento: " + "\n"
                + "title = " + this.title + "\n"
                + "content = " + this.content + "\n"
                + "imgs = " + this.imgs + "\n";
    }
}
