#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void my_gets(char *string){
	fflush(stdin);
	fflush(stdout);
	
	fgets(string, 1000, stdin);
	
	if(strlen(string) > 0 && string[strlen(string) - 1] == '\n')
		string[strlen(string - 1)] = '\0';

	fflush(stdin);
	fflush(stdout);	
}

int max(int a, int b){
	if(a > b)
		return a;
	else
		return b;
}

void print_char_array(char *array){
	int i;
	for(i = 0; i < sizeof(array) / sizeof(char); i++){
		printf("%s", &array[i]);
	}
}

void initialize_tree(int *tree){
	int i = 0;
	
	for(i = 0; i < sizeof(tree) / sizeof(int); i++){
		*tree = -1;
		tree++;
	}
}

int height(int *tree, int node){
	if(tree[node] == -1)
		return 0;
	else
		return 1 + max(height(tree, node*2+1), height(tree, node*2+2));
}

int tree[200];
char buffer[500];
int number_of_tests;

int main(){
	my_gets(buffer);
	number_of_tests = (int)buffer[0];

	strtok(buffer, " ");
	print_char_array(buffer);
	//get all test cases
	//verify if any node balance is greater than 1 or lesser than -1

	return 0;
}
