#include <iostream>
#include "Sale.h"
#include <cstdlib>

#include "Node.h"

using namespace std;

int main( int argc, char** argv ) {

    /*
    Sale sale1("Pantalon",145000,10);

    cout<<sale1<<endl;

    Sale *sale2 = new Sale("Falda",89000,5);


    cout<<*sale2<<endl;

    delete(sale2);
    */

    Node <char> *node = new Node <char> ('D');
    Node <char> *node2 = new Node <char> ('A');
    Node <char> *node3 = new Node <char> ('N');

    Node <int> *int1 = new Node <int> (5);
    Node <int> *int2 = new Node <int> (4);
    Node <int> *int3 = new Node <int> (3);
    Node <int> *int4 = new Node <int> (2);
    Node <int> *int5 = new Node <int> (1);
    Node <int> *int6 = new Node <int> (0);

    node->set_next (node2);
    node2->set_next (node3);

    int1->set_next (int2);
    int2->set_next (int3);
    int3->set_next (int4);
    int4->set_next (int5);
    int5->set_next (int6);

    Node <char> *aux = node;
    Node <int> *auxInt = int1;

    while (aux != NULL) {
        cout<<aux->info1()<<"\t";
        aux = aux->next1();
    }

    cout<<endl;

    while (auxInt != NULL) {
        cout<<auxInt->info1()<<"\t";
        auxInt = auxInt->next1();
    }

    delete(node);
    delete(int1);

    Node<Sale> *sale1 = new Node<Sale>(Sale ("Pantalon", 150000, 5));

    return EXIT_SUCCESS;
}
