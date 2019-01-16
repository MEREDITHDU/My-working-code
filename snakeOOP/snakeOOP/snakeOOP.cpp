// snakeOOP.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <cstdlib>
#include <conio.h>
#include <windows.h>
#include <ctime>
#include <vector>
using namespace std;

class Game
{
public:

	virtual void update() = 0;
};

enum objects { EMPTY, WALL, SNAKE_HEAD, SNAKE_TAIL, Food };
objects** Map;

const int m_x = 40;
const int m_y = 10;

class Snake : public Game
{
public:

	void update();

private:
	int _x = 19;
	int _y = 4;
	int _x_old, _y_old;
	int _direction = 3;
	int _tsize = 0;

	struct Tail
	{
		int x;
		int y;
	};

	vector<Tail>tails;


	void Key();
	void _MoveSnake();
	void _AddTail();
	bool _Ate();
	void _MoveTail();
	void _Collision();
};


  
void Snake::_MoveSnake()
{
	
	_x_old = _x;
	_y_old = _y;

	switch (_direction)
	{
	case 1:
	{
		_y--;
		break;
	}
	case 2:
	{
		_x--;
		break;
	}
	case 3:
	{
		_x++;
		break;
	}
	case 4:
	{
		_y++;
		break;
	}
	}

	Map[_y_old][_x_old] = EMPTY;
	Map[_y][_x] = SNAKE_HEAD;
}

void Snake::Key()
{
	if (_kbhit())
	{
		char input = _getch();

		if (input == 'w')
		{
			_direction = 1;
		}
		else if (input == 'a')
		{
			_direction = 2;
		}
		else if (input == 'd')
		{
			_direction = 3;
		}
		else if (input == 's')
		{
			_direction = 4;
		}
	}
}
void Snake::_AddTail()
{
	
	if (_tsize == 0)
	{
		for (int i = 0; i<2; i++)
		{
			tails.push_back(Tail());
			tails[i].x = 19 - i;    
			tails[i].y = 4;

			Map[tails[i].y][tails[i].x] = SNAKE_TAIL;

			_tsize++;
		}
	}

	if (_Ate())
	{
		tails.push_back(Tail());

		switch (_direction)
		{
		case 1:
		{
			tails[_tsize].x = tails[_tsize - 1].x;
			tails[_tsize].y = tails[_tsize - 1].y - 1;
			break;
		}
		case 2:
		{
			tails[_tsize].x = tails[_tsize - 1].x + 1;
			tails[_tsize].y = tails[_tsize - 1].y;
			break;
		}
		case 3:
		{
			tails[_tsize].x = tails[_tsize - 1].x - 1;
			tails[_tsize].y = tails[_tsize - 1].y;
			break;
		}
		case 4:
		{
			tails[_tsize].x = tails[_tsize - 1].x;
			tails[_tsize].y = tails[_tsize - 1].y + 1;
			break;
		}
		}

		_tsize++;
	}
}


bool Snake::_Ate()
{
	
	if (_direction == 1 && Map[_y - 1][_x] == Food)
	{
		return true;
	}
	else if (_direction == 2 && Map[_y][_x - 1] == Food)
	{
		return true;
	}
	else if (_direction == 3 && Map[_y][_x + 1] == Food)
	{
		return true;
	}
	else if (_direction == 4 && Map[_y + 1][_x] == Food)
	{
		return true;
	}

	return false;
}


void Snake::_MoveTail()
{
	Map[tails[_tsize - 1].y][tails[_tsize - 1].x] = EMPTY;

	
	for (int i = _tsize - 1; i != 0; i--)
	{
		tails[i].x = tails[i - 1].x;
		tails[i].y = tails[i - 1].y;
	}

	tails[0].x = _x_old;
	tails[0].y = _y_old;


	Map[_y_old][_x_old] = SNAKE_TAIL;
}



void Snake::_Collision()
{

	if (_x == 0 || _x == 39)
	{
		cout << "YOU LOST";
		system("pause");
		exit(0);
	}

	if (_direction == 1 && Map[_y - 1][_x] == WALL || _direction == 4 && Map[_y + 1][_x] == WALL)
	{
		cout << "YOU LOST";
		system("pause");
		exit(0);
	}


	if (_direction == 1 && Map[_y - 1][_x] == SNAKE_TAIL)
	{
		cout << "YOU LOST";
		system("pause");
		exit(0);
	}
	else if (_direction == 2 && Map[_y][_x - 1] == SNAKE_TAIL)
	{
		cout << "YOU LOST";
		system("pause");
		exit(0);
	}
	else if (_direction == 3 && Map[_y][_x + 1] == SNAKE_TAIL)
	{
		cout << "YOU LOST";
		system("pause");
		exit(0);
	}
	else if (_direction == 4 && Map[_y + 1][_x] == SNAKE_TAIL)
	{
		cout << "YOU LOST";
		system("pause");
		exit(0);
	}
}



void Snake::update()
{
	Key();
	_AddTail();
	_Collision();
	_MoveSnake();
	_MoveTail();
}

class Food : public Game
{
public:

	void update();

private:
	int _x;
	int _y;

	void _spawnFood();
	bool _check_for_Food();
};


void Food::_spawnFood()
{
	int x, y;
	x = 1 + rand() % 38;
	y = 1 + rand() % 8;

	Map[y][x] = Food;
}



bool Food::_check_for_Food()
{
	for (int i = 1; i<m_y - 1; i++)
	{
		for (int j = 1; j<m_x - 1; j++)
		{
			if (Map[i][j] == Food)
			{
				return true;
			}
		}
	}
	return false;
}


void Food::update()
{
	if (!_check_for_Food())
	{
		_spawnFood();
	}
}


void Scene(vector<Game*>&updates)
{

	if (updates.size() == 0)
	{
		updates.push_back(new Snake());
		updates.push_back(new Food());
	}

	for (vector<Game*>::iterator itr = updates.begin(), end = updates.end(); itr != end; itr++)
	{
		(*itr)->update();
	}

}

void draw()
{

	COORD cur = { 0,0 };
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), cur);

	for (int i = 0; i<m_y; i++)
	{
		for (int j = 0; j<m_x; j++)
		{
			if (Map[i][j] == WALL)
			{
				cout << "*";
			}
			else if (Map[i][j] == EMPTY)
			{
				cout << " ";
			}
			else if (Map[i][j] == SNAKE_HEAD)
			{
				cout << "O";
			}
			else if (Map[i][j] == SNAKE_TAIL)
			{
				cout << "o";
			}
			else if (Map[i][j] == Food)
			{
				cout << "+";
			}
		}
		cout << endl;
	}
}

int main()
{
	Map = new objects*[m_y];
	for (int i = 0; i<m_y; i++)
	{
		Map[i] = new objects[m_x];
	}

	for (int i = 0; i<m_y; i++)
	{
		for (int j = 0; j<m_x; j++)
		{
			if (i == 0 || i == m_y - 1 || j == 0 || j == m_x - 1)
			{
				Map[i][j] = WALL;
			}
			else
			{
				Map[i][j] = EMPTY;
			}
		}
	}

	vector<Game*>updates;

	while (1)
	{
		draw();
		Scene(updates);
		Sleep(200);
	}


	return 0;
}
