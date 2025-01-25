//
// Created by dani on 9/19/24.
//

#ifndef NODE_H
#define NODE_H
#include <cstdlib>

template <class T> class LinkedList;
template <class T>

class Node {
    friend class LinkedList<T>;

public:
    Node(){}

    explicit Node(T *info) : info(info) {
        Node<T>::next = NULL;
        Node<T>::prev = NULL;
    }

private:
    T* info;
    Node<T> *next;
    Node<T> *prev;
};



#endif //NODE_H
