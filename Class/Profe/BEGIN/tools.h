//
// Created by Jairo Riaño on 30/08/24.
//
int calcMCD( int *div, int *dvz ){

    int aux = *div % *dvz;

    return aux == 0 ? *dvz : calcMCD(dvz, &aux );
}