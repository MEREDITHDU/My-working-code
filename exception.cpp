// ConsoleApplication3.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include<iostream>
#include<string>
using namespace std;
#pragma once
 
class myException1:public exception {
public:
	const char *what1() {
		return "Error! This name is forbidden!";
	}
};
class myException2 :public exception {
public:
	const char *what2() {
		return "Error! Id out of bound(0-60)!";
	}
};
class myException3 :public exception {
public:
	const char *what3() {
		return "Error! Grade out of bound(0-100)!";
	}
};

class Student
{
	string name;
	int id;
	double grade;
public:
	void student_register();
	void show();

	bool operator==(const Student &x);

	Student(string, int, double);
};

void Student::student_register()
{
	cout << "name (God if forbidden): ";
	cin >> name;
	if (name == "God") {
		myException1 e1;
		throw e1;
	}

	cout << "id in class: ";
	cin >> id;
	if ((id <= 0) || (id >= 60)) {
		myException2 e2;
		throw e2;
	}

	cout << "Grade in percent: ";
	cin >> grade;
	if ((grade <= 0) || (grade >= 100)) {
		myException3 e3;
		throw e3;
	}
}

bool Student::operator==(const Student &x)
{
	if ((this->name == x.name) && (this->id == x.id) && (this->grade == x.grade)) return true;
	else return false;
}

void Student::show()
{
	cout << endl << "Student data" << endl;
	cout << "name : " << name << endl;
	cout << "id : " << id << endl;
	cout << "grade : " << grade << endl;
}

Student::Student(string nname, int iid, double ggrade)
{
	name = nname;
	id = iid;
	grade = ggrade;
}


int main()
{
	Student you("empty", 0, 0);
	Student already_existing_user("jan", 20, 20);

	try
	{
		you.student_register();
		if (you == already_existing_user) throw you;
	}
	catch (myException1 e1)
	{
		cout << e1.what1();
		return 0;
	}
	catch (myException2 e2)
	{
		cout << e2.what2();
		return 0;
	}
	catch (myException3 e3)
	{
		cout << e3.what3();
		return 0;
	}
	catch (Student stu)
	{
		cout << "Such student already exist : ";
		stu.show();
		cout << "Please choose other data" << endl;
		return 0;
	}
	catch (...)
	{
		cout << "Unknown error!" << endl;
		return 0;
	}

	cout << endl << endl << "Registration succesed!" << endl;
	you.show();
	system("pause");
    return 0;
}

