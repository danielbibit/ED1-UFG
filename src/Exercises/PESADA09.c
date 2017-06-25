#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int max(int a, int b){
	if(a > b)
		return a;
	else
		return b;
}

int split_string(char* str, int* tree){
	int i = 0;
	char* pch;

	pch = strtok (str," ");

	while (pch != NULL){
		tree[i] = atoi(pch);
		pch = strtok (NULL, " ");
		i++;
	}

	return i;
}

void initialize_tree(int* tree){
	int i;

	for(i = 0; i < 250; i++){
		tree[i] = -1;
	}
}

int height(int* tree, int node){
	if(tree[node] == -1){
		return -1;
	}else{
		return 1 + max(height(tree, node*2+1), height(tree, node*2+2));
	}
}

int balance(int* tree, int node){
	return height(tree, node*2+1) - height(tree, node*2+2);
}

int verify_AVL(int* tree, int tree_size){
	int i;

	for(i = 0; i < tree_size*2+5; i++){
		if(tree[i] != -1){
			int balance_node = balance(tree, i); //optimization

			if(balance_node < -1 || balance_node > 1){
				printf("F\n");
				return 0;
			}
		}
	}

	printf("T\n");
	return 1;
}

int main(){
	int tree[250];
	char buffer[600];
	int number_of_tests;

	int i;
	scanf("%i", &number_of_tests);
	fgets(buffer, 5, stdin);

	for(i = 0; i < number_of_tests; i++){
		memset(buffer, 0, strlen(buffer));
		fgets(buffer, 600, stdin);
		fflush(stdin);

		//start gambs
		char* p = buffer;
		p += 2;
		//end gambs

		initialize_tree(tree);
		int size_of_tree = split_string(p, tree);

		verify_AVL(tree, size_of_tree);
	}

	return 0;
}
