#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int isOdd(int n){
	return n % 2 != 0;
}

int main (){
	srand(time(NULL));
	printf("%d\n", rand () %21 + 10);
	return 0;
}
