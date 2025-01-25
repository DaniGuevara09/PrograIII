//
// Created by dani on 9/2/24.
//

#ifndef NODE_H
#define NODE_H


template <class T>

class Node {
public:
    explicit Node(const T &info)
        : info(info) {
    }

    [[nodiscard]] T info1() const {
        return info;
    }

    void set_info(const T &info) {
        this->info = info;
    }

    [[nodiscard]] Node<T> * next1() const {
        return next;
    }

    void set_next(Node<T> *next) {
        this->next = next;
    }

    ~Node() = default;

private:
    T info;
    Node<T> *next; // Call itself
};




#endif //NODE_H
