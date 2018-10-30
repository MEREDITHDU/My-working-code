// ConsoleApplication7.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include<iostream>
#include<cstdlib>
#include<ctime>
#include<typeinfo>

using namespace std;

class Element {
public:
	Element() {};
	virtual ~Element() {};

	string counter;
	string counteredBy;
};

class Fire : public Element {
public:
	Fire() {};
	~Fire() {};
};
class Nature : public Element {
public:
	Nature() {};
	~Nature() {};
};
class Water :public Element {
public:
	Water() {};
	~Water() {};
};

int main()
{
	srand(time(NULL));
	Element *myElement;
	Element *enemyElement;

	int myNumber;
	cout <<"Choose your element: " << endl;
	cin >> myNumber;
	switch (myNumber) {
	case 1:
		myElement = new Fire;
		myElement->counter = typeid(Nature).name();
		myElement->counteredBy= typeid(Water).name();
		break;
	case 2:
		myElement = new Nature;
		myElement->counter = typeid(Water).name();
		myElement->counteredBy = typeid(Fire).name();
		break;
	case 3:
		myElement = new Water;
		myElement->counter = typeid(Fire).name();
		myElement->counteredBy = typeid(Nature).name();
		break;
	default:
		myElement = new Element;
		break;
	}

	int rand;
	rand = 1 + std::rand() % 3;

	switch (rand) {
	case 1:
		enemyElement = new Fire;
		break;
	case 2:
		enemyElement = new Nature;
		break;
	case 3:
		enemyElement = new Water;
		break;
	default:
		enemyElement = new Element;
		break;
	}


	if (dynamic_cast<Fire *>(enemyElement)) {
		cout << "we met Fire enemy" << endl;
	}
	if (dynamic_cast<Water *>(enemyElement)) {
		cout << "we met Water enemy" << endl;
	}
	if (dynamic_cast<Nature *>(enemyElement)) {
		cout << "we met Nature enemy" << endl;
	}
	
	if (typeid(*enemyElement).name()==myElement->counter) {
		cout << "you won" << endl;
	}
	else if (typeid(*enemyElement).name()==myElement->counteredBy) {
		cout << "you failed" << endl;
	}
	else {
		cout << "draw" << endl;
	}
	system("pause");
		return 0;
}

