#include<iostream>
#include <string>

using namespace std;

class Studentinfo
{
private:
	string  stringname;
	int number;


public:
	Studentinfo(string name, int number) {
		Studentinfo::name = name;
		Studentinfo::number = number;
	}
	void init() {
		cout << "Student name is" << name << endl;
		cout << "Student number is" << number << endl;
	}
	void setdata() {
		cout << "enter the student name" << endl;
		cin >> name;
		cout << "enter the student number" << endl;
		cin >> number;
		Studentinfo(name, number);
	}
};


class CourseInfo
{

private:

	string name;
	int number;
	int semester;

public:
	CourseInfo(string name, int number, int semester) {
		CourseInfo::name = name;
		CourseInfo::number = number;
		CourseInfo::semester = semester;

	}

	void init() {
		cout << "Course name is " << name << endl;
		cout << "Course number is " << number << endl;
		cout << "Course semester is " << semester << endl;
	}
	void setdata() {
		cout << "enter cousrse name" << endl;
		cin >> name;
		cout << "enter the course number" << endl;
		cin >> number;
		cout << "enter the cousre semester is" << endl;
		cin >> semester;
		CourseInfo(name, number, semester);
	}
};


class Student :public Studentinfo, public CourseInfo
{
private:
	string address;
	string nationality;
public:

	Student(string address, string nationality)
		:CourseInfo("Calculus", 1, 2342)
		, Studentinfo("good", 20)
	{
		Student::address = address;
		Student::nationality = nationality;
	}

	void display() {
		Studentinfo::setdata();
		CourseInfo::setdata();
		Studentinfo::init();
		CourseInfo::init();
		cout << "student address is " << address << endl;
		cout << "the student nationality is " << nationality << endl;
	}

};

int  main()
{
	string address;
	string nationality;
	cout << "student address" << endl;
	cin >> address;
	cout << "student nationality" << endl;
	cin >> nationality;

	Student b(address, nationality);
	b.display();
	return 0;

}
