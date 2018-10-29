[![Build Status](https://travis-ci.org/urgenmagger/JavaCourse.svg?branch=master)](https://travis-ci.org/urgenmagger/JavaCourse)
[![codecov](https://codecov.io/gh/urgenmagger/JavaCourse/branch/master/graph/badge.svg)](https://codecov.io/gh/urgenmagger/JavaCourse)
# JavaCourse
Этот репозиторий - курс по Java, который основан на проектах и задачах ресурса [Job4j](http://job4j.ru/).

Уровень обучения стажер/trainee разбит на три части. В первой части демонстрируются  разные способы решения задач с помощью алгоритмов (сортировка пузырьком, вращение матрицы, сортировка строк), структура:

```
├── array
│   ├── ArrayDublicate.java
│   ├── BubbleSort.java
│   ├── RotateArray.java
│   ├── Substring.java
│   └── Turn.java
├── Calculate.java
├── calculator
│   └── Calculator.java
├── condition
│   ├── Point.java
│   └── Triangle.java
├── loop
│   ├── Board.java
│   ├── Counter.java
│   ├── Factorial.java
│   └── Paint.java
├── max
    └── Max.java
```
Инструменты - Maven, JUnit, Git. Эта часть была сделана в эмуляторе терминала Linux с использованием связки Vim + Tmux.

Вторая часть включает в себя обучение основным принципам ООП при помощи создания консольного CRUD приложения tracker (создание, редактирование, добавление, удаление заявок). Данный этап предполагает также знакомство с паттернами проектирования (Декоратор, Стратегия).


Структура:
```
├── chessboard
│   ├── Bishop.java
│   ├── Board.java
│   ├── Cell.java
│   ├── Figure.java
│   ├── FigureNotFoundException.java
│   ├── ImpossibleMoveException.java
│   └── OccupiedWayException.java
├── package-info.java
├── professions
│   ├── Clients.java
│   ├── Doctor.java
│   ├── Engineer.java
│   ├── package-info.java
│   ├── Profession.java
│   └── Teacher.java
├── strategy
│   ├── Paint.java
│   ├── Shape.java
│   ├── Square.java
│   └── Triangle.java
└── tracker
    ├── BaseActions.java
    ├── ConsoleInput.java
    ├── Input.java
    ├── Item.java
    ├── MenuOutException.java
    ├── MenuTracker.java
    ├── package-info.java
    ├── StartUI.java
    ├── Stop.java
    ├── StubInput.java
    ├── Tracker.java
    ├── UserAction.java
    └── ValidateInput.java
 ```
Инструменты - Maven, JUnit, Git. Эта часть сделана в среде разработки IntelliJ IDEA (плагин IdeaVIM).

Третья часть - Collections Framework  
Структура
```
├── bank
│   ├── Account.java
│   ├── Bank.java
│   └── User.java
├── comparator
│   ├── ListCompare.java
│   ├── SortUser.java
│   └── User.java
├── departament
│   └── Department.java
├── list
│   ├── ConvertList2Array.java
│   └── ConvertMatrix2List.java
├── map
│   ├── UserConvert.java
│   └── User.java
├── package-info.java
├── phonebook
│   ├── Person.java
│   └── PhoneDictionary.java
└── search
    ├── PriorityQueue.java
    └── Task.java
```
Применение на практике различных структур данных:  
* ArrayList
* HashMap 
* LinkedList   

Рефакторинг приложения Tracker(из Array в ArrayList).  