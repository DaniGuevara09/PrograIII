cmake_minimum_required(VERSION 3.29)
project(Proj6LinkedList)

set(CMAKE_CXX_STANDARD 20)

add_executable(Proj6LinkedList main.cpp
        Node.cpp
        Node.h
        LinkedList.cpp
        LinkedList.h)
