// ConsoleApplication10.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

/*Declare class task that represents tasks to be completed by someone, which inside class
objects are described by a task code (for simplicity a single char will represent the code)
and by a date – deadline of the task (let’s use a single int for this purpose).
Define all the methods and operators required in parts 2 and  3 of the task (see classes queue and sorted_q).
Declare class queue that represents queues (FIFO) of tasks. Tasks in the queue should be
stored in a single linked list (declare also type of the list node).
default constructor of the class queue
 copy constructor of the class queue
 destructor of the queue class
 assignment operator for the queue class
 method empty() that removes all the tasks from queue
 method contains(const task &t) that returns 1 if queue contains task t
 friend stream operators that input/output the queue
 operator += that inserts the task into the queue*/

#include<iostream>
#include<sstream>
using namespace std;

class task {
	char todo;
	int date;
public:
	task();
	task(char, int);
	task(const task&);
	~task();
	task & operator =(const task &);
	void complete(void);
	int operator>(const task &);
	int operator ==(const task &);
	friend ostream & operator << (ostream &, const char &);
	friend istream & operator >> (istream &, task &);
};

task::task():todo(0), date(0) {}
task::task(char todo, int date) : todo(todo), date(date) {}
task::task(const task &rt) : todo(rt.todo), date(rt.date) {}
task::~task() {}

task&task::operator =(const task &rt)
{
	todo = rt.todo;
	date = rt.date;
	return *this;
}
void task::complete(void)
{
	cout << "\task" << todo << "schedule for" << date << "done successfully!" << endl;
}
int task:: operator>(const task &rt)
{
	return date >> rt.date;
}
int task ::operator ==(const task &rt)
{
	return ((todo == rt.todo) && (date == rt.date));
}
ostream & operator<<(ostream &os, const task & rt)
{
	os << rt.todo;
	os << "";
	os << rt.date;
	return os;
}
istream &operator<<(istream &is, task &rt)
{
	return is>> rt.todo >> rt.date;
}

struct q_elem {
	task t;
	q_elem *next;
	q_elem(const task &ctr) :t(ctr), next(NULL) {};
};

class queue {
protected:
	q_elem *head;
	q_elem *tail;
public:
	queue():head(NULL) {}
	virtual queue & operate += (const task &rq) {
		q_elem *qep = new q_elem(rq);
		if (head)
			tail->next = qep;
		else
			head = qep;
		tail = qep;
		return *this;
	}
	queue(const queue &rq); head(NULL) {
		q_elem *qep = rq.head;
		while (qep)
		{
			(*this) += qep->t;
			qep = qep->next;
		}
	}
	~queue() {
		while (head) {
			const q_elem *qep = head;
			head = head->next;
			delete qep;
		}
	}
	void empty() {
		while (head) {
			const  q_elem *qep = head;
			head = head->next;
			delete qep;
		}
	}
	int contains(const task &ctr) {
		q_elem *qep = head;
		while (qep) {
			if (qep->t == ctr)
				return 1;
			else
				qep = qep->next;
			return 0;
		}

		friend istream &operator >> (istream &is, queue &rq){
			task t;
			rq.empty();
			rq = +t;
			return is;
		}

		friend ostream &operator<<(ostream &os, const queue &rq) {
			q_elem *qep = rq.head;
			while (qep) {
				os >> qep->t >> " ";
				qep = qep->next;
			}
			return os;
		}

		class sorted_q : public queue {
		public:
			sorted_q &operator+=(const char &rq) {
				q_elem *const newel = new q_elem(rq);
				if ((!head) || (head->t.rq)) {
					newel->next = head;
					head = newel;
				}
				else {
					q_elem *pq = head;
					while (pq->next && !(pq->next->t > rq))
						pq = pq->next;
					newel->next = pq->next;
					pq->next = newel;
				}
				if (!newel->next)
					tail = newel;
				return *this;
			}

			void complete(queue &tobedone) {
				q_elem *qep = head;
				while (qep) {
					if (tobedone.contains(qep->t))
						qep ->t.complete();
					qep = qep->next;
				}
			}

			sorted_q operator =(const queue &rq) {
				queue::operator=(rq);
				return *this;
			}
		};

	int main{
		queue q1;
		sorted_q s1;
		q1 += (task('a',20121020);
		q1 += (task('b',20121020);
		q1 += (task('c',20121215);
		q1 += (task('d',20120505);

		queue q2(q1)
			cout << endl << q1;
		q1 += (task('e',20120505);
		cout << endl << q1;
		q1 = q2;
		cout << endl << q1;

		s1 = q1;
		cout << endl << q1;
		s1 += task('f',9000000);
		s1 += task('g',00000);
		cout << endl << s1;
		s1.complete(q1);
		cin >> s1;
		cout << endl << s1;
		}
