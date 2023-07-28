//스택 구현하기
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 100000

typedef struct stack{
	int array[SIZE];
	int top;
	int size;
}stack;

void init(struct stack* s){ //스택 초기화 
	s->top = -1;
	s->size = 0;
}

int empty(struct stack* s){
	if(s->top == -1){
		return 1;
	}
	return 0;
}

void top(struct stack* s){
	if(s->top == -1){
		printf("%d",-1);
		return;
	}
	printf("%d",s->array[s->top]);
}

void push(struct stack* s, int number){
	s->top++;
	s->array[s->top] = number;
	s->size++;
}

int pop(struct stack* s){
	if(s->top == -1){
		printf("%d",-1);
		return -1;
	}
	s->size--;
	return s->array[s->top--];
	
}

int printSum(struct stack* s){
	int sum=0;
	for(int i=0; i<(s->size); i++){
		sum += s->array[i];
	}
	return sum;
}


int main(void){
	struct stack s;
	init(&s);
	
	int t;
	scanf("%d",&t);
	
	for(int i=0; i<t; i++){
		int number;
		scanf("%d",&number);
		
		if(number==0){
			pop(&s);
		}
		else{
			push(&s,number);
		}
	}
	printf("%d", printSum(&s));
	
	return 0;
} 