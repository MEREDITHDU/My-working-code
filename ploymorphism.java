// ConsoleApplication2.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include<iostream>
#include<stdlib.h>
#include<time.h>

using namespace std;


class item {
public:
	int amount;
	int Inspect() {
		return 11;
	};
};

class Food : public item {
public:
	int Inspect() {
		return rand() % 10;
	}
};
class Money : public item {
public:
	int Inspect() {
		return rand() % 10;
	}
};
class Key : public item {
public:
	int Inspect(){
		return rand() % 10;
	
	}
};
int main()
{
	srand(time(NULL));
	//item *item;
	Food *f;
	Money m;
	Key k;

	item *item[10];
	const int num = 10;
	for (int i = 0;i < num;i++) {
		item[i] = new Food();
		cout << item[i]->Inspect() << endl;
	}
	for (int i = 0;i < num;i++) {
		item[i] = new Money();
		cout << item[i]->Inspect() << endl;
	}
	for (int i = 0;i < num;i++) {
		item[i] = new Key();
		cout << item[i]->Inspect() << endl;
	}

	return 0;
}
