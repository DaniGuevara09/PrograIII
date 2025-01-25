#include <iostream>
#include "Sale.h"
#include <cstdlib>

using namespace std;

int main( int argc, char** argv ) {

    Sale sale1("Pantalon",145000,10);

    cout<<sale1<<endl;

    Sale *sale2 = new Sale("Falda",89000,5);


    cout<<*sale2<<endl;

    delete(sale2);


    return EXIT_SUCCESS;
}
