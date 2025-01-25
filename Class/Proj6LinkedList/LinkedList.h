//
// Created by dani on 9/19/24.
//

#ifndef LINKEDLIST_H
#define LINKEDLIST_H
#include <vector>
#include "Node.h"

template <class T>

class LinkedList {
public:
    LinkedList();

    bool isEmpty();
    void addNodeFirst(T* node);
    void addNodeLast( T* );
    void addNodeAfterTo( Node<T>*, T* );
    void addNodeBeforeTo( Node<T>*, T* );
    void addNodeSorted(T*);
    Node<T>* findNode(T*);
    T* findInfo( int );
    std::vector<T*> getLinkedList();
    T* deleteNode(Node<T>*);
    int getSize();
    T* getObject(int key);
    T* getFirst();
    T* getLast();

    virtual ~LinkedList();


private:
    Node<T> *head;
    Node<T> *last;
};



#endif //LINKEDLIST_H
