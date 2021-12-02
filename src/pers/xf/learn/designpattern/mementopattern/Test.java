package pers.xf.learn.designpattern.mementopattern;

public class Test {
    public static void main(String[] args) {
        DraftSaver draftSaver = new DraftSaver();

        Editor editor = new Editor("一个题目", "一些内容", "一个图片链接?");

        ArticleMemento articleMemento = editor.saveToMemento();
        draftSaver.addMemento(articleMemento);

        System.out.println(editor);
        System.out.println("---首次修改---");
        editor.setTitle("[一个题目]");
        System.out.println("---修改完成---");

        System.out.println("---保存---");
        articleMemento = editor.saveToMemento();
        draftSaver.addMemento(articleMemento);

        System.out.println("---查看修改---");
        System.out.println(draftSaver.getMemento());

        System.out.println("---再次修改---");
        editor.setImgs("<一个图片链接?>");
        System.out.println(editor);
        System.out.println("---修改完成---");
        System.out.println("---保存---");
        articleMemento = editor.saveToMemento();
        draftSaver.addMemento(articleMemento);
        System.out.println("---查看修改---");
        System.out.println(draftSaver.getMemento());

        System.out.println("---一次撤销---");
        articleMemento = draftSaver.removeHistory();
        editor.undoFromMemento(articleMemento);
        System.out.println("---保存---");
        articleMemento = editor.saveToMemento();
        draftSaver.addMemento(articleMemento);
        System.out.println("---查看修改---");
        System.out.println(draftSaver.getMemento());

    }
}
