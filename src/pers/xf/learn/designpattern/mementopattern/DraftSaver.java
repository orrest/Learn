package pers.xf.learn.designpattern.mementopattern;

import java.util.LinkedList;

public class DraftSaver {
    private final LinkedList<ArticleMemento> STACK = new LinkedList<>();

    public ArticleMemento getMemento(){
        return STACK.peek();
    }

    public ArticleMemento removeHistory(){
        // 丢弃当前状态
        STACK.pop();
        // 返回上一次的状态
        return STACK.pop();
    }

    public void addMemento(ArticleMemento articleMemento){
        STACK.push(articleMemento);
    }
}
