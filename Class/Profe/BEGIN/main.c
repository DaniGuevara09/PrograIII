#include <stdio.h>
#include "tools.h"
#include <ctype.h>

void mainMenu();

int main(void) {
    mainMenu();

    return 0;
}

void mcd(){

    int num1, num2;

    printf("Numero 1..: ");
    scanf("%d",&num1);

    printf("Numero 2..: ");
    scanf("%d",&num2);

    fflush(stdin);

    printf("El MCD de %d y %d es %d\n",num1,num2, calcMCD( &num1,&num2));

    getchar();
}

void cousing(){

}

void mainMenu(){
    char option;
    char *menu = "<<<<<<<MENÚ PRINCIPAL>>>>>>\n\n"
                 "1. Hallar el MCD\n"
                 "2. Número Primo\n\n"
                 "X. Salir\n\n"
                 "Digite su Opcion";

    do{
        printf( menu);
        scanf("%c",&option);
        fflush(stdin);
        switch(option){
            case '1' : mcd();
            break;

            case '2' : cousing();
            break;
        }
    }while( toupper(option) != 'X');
}
