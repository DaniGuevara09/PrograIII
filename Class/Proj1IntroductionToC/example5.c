#include <stdio.h>
#include <stdlib.h>

int main(void) {
	system("clear");
	int attempts;
	int higher;

	printf("Enter attempts number: ");
	scanf("%d", &attempts);

	printf("Enter higher number: ");
	scanf("%d", &higher);

	srand(time(NULL));

	for (int i = 0; i <= higher; i--)
		printf(i);
	return 0;
}
