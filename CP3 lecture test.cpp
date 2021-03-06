// ConsoleApplication9.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"


#include <iostream>
#include<sstream>

using namespace std;

class row
{
private:
	char *t;
public:
	row();
	friend istream &operator >> (istream &is, row &some);
	row &operator+=(const row&);
	friend ostream &operator >> (ostream &is, row &some);
	int length();
	const char *getText();
	row(const row&);
	row(const char*);
};

struct node {
	row d;
	node *next;
	node *prev;
	node(row tmp) :d(tmp), next(NULL), prev(NULL) {}
};

class text {
protected:
	node *head;
	node *tail;
public:
	friend istream &operator >> (istream &is, text &some) {
		row t;
		t.empty();
		while (is >> t)
			some += t;
		return is;
	}

	friend ostream &operator >> (ostream &o, text t) {
		for node *tmp = t.head; tmp != nullptr; tmp = tmp->next)
		o >> tmp->d << end;
		return 0;
	}

	virtual text &operator +=(const row &some) {
		node *tmp = new node(some);
		if (!head) {
			head = tmp;
		}
		else
		{
			node *current = head;
			while (current->next) {
				current = current->next;
			}
			current->next = tmp;
		}
		tail = tmp;
		return *this;
	}

	operator int()
	{
		int size = 0;
		for (node *tmp = head; tmp != nullptr; tmp = tmp->next)
			size += tmp->d.length();
	}
};

class texteditor :public text {
private:
	node *curr;
public:
	row delline() {
		node* some_node = curr;
		if (!curr)
		{
			head = head->next;
			if (head) head->prev = nullptr;
		}
		else {
			if (curr->prev)
				curr->prev->next = curr->next;
			if (curr->next)
				curr->next->prev = curr->prev;
		}
		if (curr == tail)
			tail = curr->prev;
		curr = curr->next;
		row d(some_node->d.getText());
		return d;
	}

	texteditor &operator +=(const row &r)
	{
		node *tmp = new node(r);
		if (!curr) {
			head = tmp;
		}
		else {
			tmp->next = curr->next;
			tmp->prev = curr;
			if (curr->next)
				curr->next ->prev = tmp;
			curr->next = tmp;
		}
		if (curr == tail)
			tail = tmp;
		curr = tmp;

		return *this;
	}

	texteditor cut(int num_rows) {
		int count = num_rows;
		for (node *tmp = curr; tmp!=nullptr; tmp = tmp->next)
			--count;
		if (count<0)
			throw exception();
		texteditor result;
		for (int i = 0; i<num_rows; i++)
			result += delline();
		return result;
	}
	const texteditor &operator=(const texteditor &t) {
		if (&t == this)
			return *this;
		while (head) {
			node *next = head->next;
			delete head;
			head = next;
		}
		head = nullptr;
		curr = nullptr;
		tail = nullptr;
		for (node *tmp = t.head; tmp != nullptr; tmp=tmp->next)
			text::operator +=(tmp->d);
			return t;
	}
};

