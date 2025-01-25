//
// Created by dani on 9/19/24.
//

#include "LinkedList.h"

template<class T>
LinkedList<T>::LinkedList() {
    LinkedList<T>::head = NULL;
    LinkedList<T>::last = NULL;
}

template<class T>
bool LinkedList<T>::isEmpty() {
    return head == NULL;
}

template<class T>
void LinkedList<T>::addNodeFirst(T *node) {
    Node <T> *newNode = new Node<T>(node);
    newNode->next = head;
    newNode->prev = nullptr;

    if (head !=NULL) {
        head->prev = newNode;
    }
    head = newNode;
}

template<class T>
void LinkedList<T>::addNodeLast(T * node) {
    Node <T> *newNode = new Node<T>(node);
    newNode->next = nullptr;

    if (isEmpty()) {
        newNode->prev = nullptr;
        head = newNode;
    } else {
        Node<T> *aux = head;

        while (aux->next != nullptr) {
            aux = aux->next;
        }

        aux->next = newNode;
        newNode->prev = aux;
    }
}

template<class T>
void LinkedList<T>::addNodeAfterTo(Node<T> *, T * data) {
    Node<T> *newNode = new Node<T>(data);
    
}

template<class T>
void LinkedList<T>::addNodeBeforeTo(Node<T> *, T *) {
}

template<class T>
void LinkedList<T>::addNodeSorted(T *) {
}

template<class T>
Node<T> * LinkedList<T>::findNode(T *) {
}

template<class T>
T * LinkedList<T>::findInfo(int) {
}

template<class T>
std::vector<T *> LinkedList<T>::getLinkedList() {
}

template<class T>
T * LinkedList<T>::deleteNode(Node<T> *) {
}

template<class T>
int LinkedList<T>::getSize() {
}

template<class T>
T * LinkedList<T>::getObject(int key) {
}

template<class T>
T * LinkedList<T>::getFirst() {
}

template<class T>
T * LinkedList<T>::getLast() {
}

template<class T>
LinkedList<T>::~LinkedList() {
}


