#include <stdio.h>
#include <string.h>
#include <stdlib.h>

<<<<<<< HEAD
=======
void my_gets(char *string){
	fflush(stdin);
	fflush(stdout);

	fgets(string, 1000, stdin);

	if(strlen(string) > 0 && string[strlen(string) - 1] == '\n')
		string[strlen(string - 1)] = '\0';

	fflush(stdin);
	fflush(stdout);
}

>>>>>>> 27338ed08168cf5f702148de98d019376513d576
int max(int a, int b){
	if(a > b)
		return a;
	else
		return b;
}

int split_string(char *str, int* tree){
	int i = 0;
	char * pch;

<<<<<<< HEAD
	pch = strtok (str," ");

	while (pch != NULL){
		tree[i] = atoi(pch);
		pch = strtok (NULL, " ");
		i++;
	}
=======
    pch = strtok (str," ");

    while (pch != NULL){
		tree[i] = atoi(pch);
		pch = strtok (NULL, " ");
		i++;
    }
>>>>>>> 27338ed08168cf5f702148de98d019376513d576

	return i-1;
}

void print_char_array(char *array){
	int i;
	printf("print_char_aray::");
<<<<<<< HEAD

=======
>>>>>>> 27338ed08168cf5f702148de98d019376513d576
	for(i = 0; i < 1000; i++){
		printf("%c", array[i]);
	}
}

void print_int_array(int* array){
<<<<<<< HEAD
	int i;

=======
	printf("\nPRINT ADDR %d", &array);

	int i;
>>>>>>> 27338ed08168cf5f702148de98d019376513d576
	for(i = 0; i < 250; i++){
		printf("%i ", array[i]);
	}
}

void initialize_tree(int* tree){
	int i;

	for(i = 0; i < 250; i++){
		tree[i] = -1;
	}
}

int height(int* tree, int node){
<<<<<<< HEAD
	if(tree[node] == -1){
		return -1;
	}else{
=======
	if(tree[node] == -1)
		return 0;
	else
>>>>>>> 27338ed08168cf5f702148de98d019376513d576
		return 1 + max(height(tree, node*2+1), height(tree, node*2+2));
	}
}

//height(tree, node[n]==-1) should be 0
int balance(int* tree, int node){
	return height(tree, node*2+1) - height(tree, node*2+2);
}

int verify_AVL(int* tree){
	int i;
	for(i = 0; i < 250; i++){
		if(tree[i] != -1){
			int balance_l = balance(tree, i);

			if(balance_l < -1 || balance_l > 1){
				printf("F\n");
				return 0;
			}
		}
	}

	printf("T\n");
	return 1;
}

<<<<<<< HEAD
=======
int balance(int* tree, int node){
	return height(tree, node*2+1) - height(tree, node*2+2);
}

int verify_AVL(int* tree){
	int i;
	for(i = 0; i < 100; i++){
		if(tree[i] != -1){
			if(balance(tree, i) < -1 || balance(tree, i) > 1){
				printf("F\n");
				return 0;
			}
		}
	}

	printf("T\n");
	return 1;
}

>>>>>>> 27338ed08168cf5f702148de98d019376513d576
int tree[250];
char buffer[500];
int number_of_tests;

int main(){
	int i;
	scanf("%i", &number_of_tests);
	fgets(buffer, 100, stdin);

	initialize_tree(tree);
<<<<<<< HEAD
	
	for(i = 0; i < number_of_tests; i++){
		memset(buffer, 0, strlen(buffer));
		fgets(buffer, 100, stdin);
		fflush(stdin);

		//~~le gambs
		char* p = buffer;
		p++;
		p++;
		//end gambs

		split_string(p, tree);

		//printf("Root Heigt: %d\n", height(tree, 0) );
		//printf("Root Balance: %d\n", balance(tree, 0));

		//print_int_array(tree);
=======

	for(i = 0; i < number_of_tests; i++){
		memset(buffer, 0, strlen(buffer));
		fgets(buffer, 100, stdin);
		fflush(stdin);

		split_string(buffer, tree);
>>>>>>> 27338ed08168cf5f702148de98d019376513d576

		verify_AVL(tree);
	}

	return 0;
}
