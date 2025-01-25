#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (void) {
	system("clear");
	short int age ;
	char name [30];
	char city [30];

	printf("Name: ");
	fgets(name, sizeof(name), stdin);
	name[strcspn(name, "\n")] = '\0';

	printf("What old are you?: ");
	scanf("%d", &age);
	getchar();

	printf("Where are you from?: ");
	fgets(city, 30, stdin);

	printf("Hi, %s. You are %d and you are from %s", name, age, city);
	return 0;
}
