package logic;

import model.BinaryTree;
import model.Word;

public class Controller {
    private BinaryTree<Word> diccionario;

    public Controller() {
        diccionario = new BinaryTree<>(
                (w1, w2) -> w1.getWord().compareToIgnoreCase(w2.getWord())
        );
    }

    //public void add
}
