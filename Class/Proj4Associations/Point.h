//
// Created by dani on 9/5/24.
//

#ifndef POINT_H
#define POINT_H



class Point {
    public:
    Point();

    Point(int x, int y)
        : x(x),
          y(y) {
    }

private:
    int x;
    int y;
};



#endif //POINT_H
